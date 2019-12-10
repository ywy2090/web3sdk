package org.fisco.bcos.v2.channel.client;

import java.math.BigInteger;
import org.fisco.bcos.v2.abi.datatypes.Function;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;
import org.fisco.bcos.v2.web3j.tx.Contract;

public class ExecuteTransaction extends Contract {

    public ExecuteTransaction(
            String contractAddress,
            Web3j web3j,
            Credentials credentials,
            BigInteger gasPrice,
            BigInteger gasLimit) {
        super("", contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public TransactionReceipt send(Function function) throws Exception {
        return executeTransaction(function);
    }

    public void asyncSend(Function function, TransactionSucCallback callback) {
        asyncExecuteTransaction(function, callback);
    }
}
