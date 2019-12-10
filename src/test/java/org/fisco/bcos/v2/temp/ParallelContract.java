package org.fisco.bcos.v2.temp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.v2.abi.FunctionReturnDecoder;
import org.fisco.bcos.v2.abi.TypeReference;
import org.fisco.bcos.v2.abi.datatypes.Function;
import org.fisco.bcos.v2.abi.datatypes.Type;
import org.fisco.bcos.v2.abi.datatypes.Utf8String;
import org.fisco.bcos.v2.abi.datatypes.generated.Uint256;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.common.tuples.Tuple1;
import org.fisco.bcos.v2.common.tuples.Tuple2;
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
public class ParallelContract extends Contract {
    public static String BINARY = "";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"},{\"name\":\"criticalSize\",\"type\":\"uint256\"}],\"name\":\"registerParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"}],\"name\":\"unregisterParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"enableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"disableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_REGISTERPARALLELFUNCTION = "registerParallelFunction";

    public static final String FUNC_UNREGISTERPARALLELFUNCTION = "unregisterParallelFunction";

    public static final String FUNC_ENABLEPARALLEL = "enableParallel";

    public static final String FUNC_DISABLEPARALLEL = "disableParallel";

    @Deprecated
    protected ParallelContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ParallelContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ParallelContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ParallelContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> registerParallelFunction(String functionName, BigInteger criticalSize) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(functionName),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(criticalSize)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerParallelFunction(String functionName, BigInteger criticalSize, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(functionName),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(criticalSize)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registerParallelFunctionSeq(String functionName, BigInteger criticalSize) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(functionName),
                new org.fisco.bcos.v2.abi.datatypes.generated.Uint256(criticalSize)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getRegisterParallelFunctionInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> unregisterParallelFunction(String functionName) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(functionName)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void unregisterParallelFunction(String functionName, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(functionName)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String unregisterParallelFunctionSeq(String functionName) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(functionName)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getUnregisterParallelFunctionInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> enableParallel() {
        final Function function = new Function(
                FUNC_ENABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void enableParallel(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ENABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String enableParallelSeq() {
        final Function function = new Function(
                FUNC_ENABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> disableParallel() {
        final Function function = new Function(
                FUNC_DISABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void disableParallel(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DISABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String disableParallelSeq() {
        final Function function = new Function(
                FUNC_DISABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    @Deprecated
    public static ParallelContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ParallelContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ParallelContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ParallelContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ParallelContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ParallelContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ParallelContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ParallelContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ParallelContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ParallelContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ParallelContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ParallelContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ParallelContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ParallelContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ParallelContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ParallelContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
