package org.fisco.bcos.v2.temp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.v2.abi.FunctionReturnDecoder;
import org.fisco.bcos.v2.abi.TypeReference;
import org.fisco.bcos.v2.abi.datatypes.Function;
import org.fisco.bcos.v2.abi.datatypes.Type;
import org.fisco.bcos.v2.abi.datatypes.Utf8String;
import org.fisco.bcos.v2.abi.datatypes.generated.Uint256;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.common.tuples.Tuple1;
import org.fisco.bcos.v2.common.tuples.Tuple2;
import org.fisco.bcos.v2.common.tuples.Tuple3;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.common.RemoteCall;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;
import org.fisco.bcos.v2.web3j.tx.Contract;
import org.fisco.bcos.v2.web3j.tx.manager.TransactionManager;
import org.fisco.bcos.v2.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.v2.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class DagTransfer extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b506103c6806100206000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630b37617b146100725780631536aedd1461013f5780633fe8e3f5146101c3578063e555f3d91461024a578063ff2b0127146102d1575b600080fd5b34801561007e57600080fd5b50610129600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610358565b6040518082815260200191505060405180910390f35b34801561014b57600080fd5b506101a6600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610364565b604051808381526020018281526020019250505060405180910390f35b3480156101cf57600080fd5b50610234600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610379565b6040518082815260200191505060405180910390f35b34801561025657600080fd5b506102bb600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610384565b6040518082815260200191505060405180910390f35b3480156102dd57600080fd5b50610342600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192908035906020019092919050505061038f565b6040518082815260200191505060405180910390f35b60008090509392505050565b60008060008081915080905091509150915091565b600080905092915050565b600080905092915050565b6000809050929150505600a165627a7a723058209640cbf8667bdfac7fea24cc6a0fd677c972388262b89f52cd0550e195bab25d0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"user_a\",\"type\":\"string\"},{\"name\":\"user_b\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"userTransfer\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"string\"}],\"name\":\"userBalance\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"string\"},{\"name\":\"balance\",\"type\":\"uint256\"}],\"name\":\"userAdd\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"string\"},{\"name\":\"balance\",\"type\":\"uint256\"}],\"name\":\"userSave\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"string\"},{\"name\":\"balance\",\"type\":\"uint256\"}],\"name\":\"userDraw\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_USERTRANSFER = "userTransfer";

    public static final String FUNC_USERBALANCE = "userBalance";

    public static final String FUNC_USERADD = "userAdd";

    public static final String FUNC_USERSAVE = "userSave";

    public static final String FUNC_USERDRAW = "userDraw";

    @Deprecated
    protected DagTransfer(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DagTransfer(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DagTransfer(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DagTransfer(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> userTransfer(String user_a, String user_b, BigInteger amount) {
        final Function function = new Function(
                FUNC_USERTRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user_a),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(user_b),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void userTransfer(String user_a, String user_b, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USERTRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user_a),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(user_b),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String userTransferSeq(String user_a, String user_b, BigInteger amount) {
        final Function function = new Function(
                FUNC_USERTRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user_a),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(user_b),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, BigInteger> getUserTransferInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USERTRANSFER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, String, BigInteger>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getUserTransferOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_USERTRANSFER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> userBalance(String user) {
        final Function function = new Function(FUNC_USERBALANCE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> userAdd(String user, BigInteger balance) {
        final Function function = new Function(
                FUNC_USERADD, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void userAdd(String user, BigInteger balance, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USERADD, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String userAddSeq(String user, BigInteger balance) {
        final Function function = new Function(
                FUNC_USERADD, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getUserAddInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USERADD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getUserAddOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_USERADD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> userSave(String user, BigInteger balance) {
        final Function function = new Function(
                FUNC_USERSAVE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void userSave(String user, BigInteger balance, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USERSAVE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String userSaveSeq(String user, BigInteger balance) {
        final Function function = new Function(
                FUNC_USERSAVE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getUserSaveInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USERSAVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getUserSaveOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_USERSAVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> userDraw(String user, BigInteger balance) {
        final Function function = new Function(
                FUNC_USERDRAW, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void userDraw(String user, BigInteger balance, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USERDRAW, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String userDrawSeq(String user, BigInteger balance) {
        final Function function = new Function(
                FUNC_USERDRAW, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(user),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getUserDrawInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USERDRAW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getUserDrawOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_USERDRAW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    @Deprecated
    public static DagTransfer load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DagTransfer(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DagTransfer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DagTransfer(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DagTransfer load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DagTransfer(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DagTransfer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DagTransfer(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DagTransfer> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DagTransfer.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DagTransfer> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DagTransfer.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DagTransfer> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DagTransfer.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DagTransfer> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DagTransfer.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
