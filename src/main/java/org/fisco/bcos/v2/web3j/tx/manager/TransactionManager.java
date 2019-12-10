package org.fisco.bcos.v2.web3j.tx.manager;

import java.io.IOException;
import java.math.BigInteger;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.web3j.tx.transaction.ExtendedRawTransaction;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.rpc.methods.response.NodeVersion;
import org.fisco.bcos.v2.rpc.methods.response.SendTransaction;
import org.fisco.bcos.v2.web3j.tx.exceptions.TxHashMismatchException;

/**
 * Transaction manager abstraction for executing transactions with Ethereum client via various
 * mechanisms.
 */
public abstract class TransactionManager {

    final Credentials credentials;

    private NodeVersion.Version nodeVersion;

    public NodeVersion.Version getNodeVersion() {
        return nodeVersion;
    }

    public void setNodeVersion(NodeVersion.Version nodeVersion) {
        this.nodeVersion = nodeVersion;
    }

    protected TransactionManager(Credentials credentials) {
        this.credentials = credentials;
    }

    protected TransactionManager(Web3j web3j, Credentials credentials) {
        this(credentials);
    }

    public abstract SendTransaction sendTransaction(
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            String data,
            BigInteger value,
            String extraData)
            throws IOException;

    public SendTransaction sendTransaction(
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            String data,
            BigInteger value,
            String extraData,
            TransactionSucCallback callback)
            throws IOException {
        return null;
    };

    public SendTransaction sendTransaction(String signedTransaction)
            throws IOException, TxHashMismatchException {
        return null;
    }

    public SendTransaction sendTransaction(
            String signedTransaction, TransactionSucCallback callback)
            throws IOException, TxHashMismatchException {
        return null;
    }

    public ExtendedRawTransaction createTransaction(
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            String data,
            BigInteger value,
            String extraData)
            throws IOException {
        return null;
    }

    public String sign(ExtendedRawTransaction transaction) {
        return null;
    }

    public String getFromAddress() {
        return credentials.getAddress();
    }
}
