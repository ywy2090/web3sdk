package org.fisco.bcos.v2.web3j.tx.manager;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.common.Numeric;
import org.fisco.bcos.v2.web3j.tx.BlockLimit;
import org.fisco.bcos.v2.web3j.tx.TxHashVerifier;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.crypto.Hash;
import org.fisco.bcos.v2.web3j.tx.transaction.RawTransaction;
import org.fisco.bcos.v2.web3j.tx.codec.TransactionEncoder;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.rpc.methods.request.Request;
import org.fisco.bcos.v2.rpc.methods.response.SendTransaction;
import org.fisco.bcos.v2.web3j.tx.ChainId;
import org.fisco.bcos.v2.web3j.tx.exceptions.TxHashMismatchException;

/**
 * TransactionManager implementation using Ethereum wallet file to create and sign transactions
 * locally.
 *
 * <p>This transaction manager provides support for specifying the chain id for transactions as per
 * <a href="https://github.com/ethereum/EIPs/issues/155">EIP155</a>.
 */
public class RawTransactionManager extends TransactionManager {
    private final Web3j web3j;
    final Credentials credentials;

    private final byte chainId;

    protected TxHashVerifier txHashVerifier = new TxHashVerifier();
    protected BlockLimit blockLimit = new BlockLimit();

    public RawTransactionManager(Web3j web3j, Credentials credentials, byte chainId) {
        super(web3j, credentials);
        this.web3j = web3j;
        this.credentials = credentials;

        this.chainId = chainId;
    }

    public RawTransactionManager(Web3j web3j, Credentials credentials) {
        this(web3j, credentials, ChainId.NONE);
    }

    BigInteger getBlockLimit() throws IOException {
        return blockLimit.getBlockLimit();
    }

    public TxHashVerifier getTxHashVerifier() {
        return txHashVerifier;
    }

    public void setTxHashVerifier(TxHashVerifier txHashVerifier) {
        this.txHashVerifier = txHashVerifier;
    }

    @Override
    public SendTransaction sendTransaction(
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            String data,
            BigInteger value,
            String extraData)
            throws IOException {

        Random r = new SecureRandom();
        BigInteger randomid = new BigInteger(250, r);
        BigInteger blockLimit = getBlockLimit();
        RawTransaction rawTransaction =
                RawTransaction.createTransaction(
                        randomid, gasPrice, gasLimit, blockLimit, to, value, data);

        return signAndSend(rawTransaction);
    }

    @Override
    public SendTransaction sendTransaction(
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            String data,
            BigInteger value,
            String extraData,
            TransactionSucCallback callback)
            throws IOException {
        Random r = new SecureRandom();
        BigInteger randomid = new BigInteger(250, r);
        BigInteger blockLimit = getBlockLimit();
        RawTransaction rawTransaction =
                RawTransaction.createTransaction(
                        randomid, gasPrice, gasLimit, blockLimit, to, value, data);

        return signAndSend(rawTransaction, callback);
    }

    public SendTransaction signAndSend(RawTransaction rawTransaction) throws IOException {

        byte[] signedMessage;

        if (chainId > ChainId.NONE) {
            signedMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        } else {
            signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        }

        String hexValue = Numeric.toHexString(signedMessage);
        SendTransaction sendTransaction = web3j.sendRawTransaction(hexValue).send();
        if (sendTransaction != null && !sendTransaction.hasError()) {
            String txHashLocal = Hash.sha3(hexValue);
            String txHashRemote = sendTransaction.getTransactionHash();
            if (!txHashVerifier.verify(txHashLocal, txHashRemote)) {
                throw new TxHashMismatchException(txHashLocal, txHashRemote);
            }
        }
        return sendTransaction;
    }

    public SendTransaction signAndSend(
            RawTransaction rawTransaction, TransactionSucCallback callback) throws IOException {

        byte[] signedMessage;

        if (chainId > ChainId.NONE) {
            signedMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        } else {
            signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        }

        String hexValue = Numeric.toHexString(signedMessage);
        Request<?, SendTransaction> request = web3j.sendRawTransaction(hexValue);
        request.setNeedTransCallback(true);
        request.setTransactionSucCallback(callback);
        request.sendOnly();

        return null;
    }
}
