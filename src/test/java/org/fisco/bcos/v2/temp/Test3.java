package org.fisco.bcos.v2.temp;

import java.math.BigInteger;
import java.util.Arrays;
import org.fisco.bcos.v2.abi.TypeReference;
import org.fisco.bcos.v2.abi.datatypes.Function;
import org.fisco.bcos.v2.abi.datatypes.Type;
import org.fisco.bcos.v2.abi.datatypes.generated.Uint256;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.common.RemoteCall;
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
public class Test3 extends Contract {
    public static String BINARY = "6080604052348015600f57600080fd5b5060a18061001e6000396000f300608060405260043610603f576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063f8a8fd6d146044575b600080fd5b348015604f57600080fd5b506056606c565b6040518082815260200191505060405180910390f35b600060019050905600a165627a7a723058201b8a3951690092a0367d7d8022491a949b8dedb18e648d9b28ce084fca97fbde0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"test\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_TEST = "test";

    @Deprecated
    protected Test3(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Test3(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Test3(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Test3(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<BigInteger> test() {
        final Function function = new Function(FUNC_TEST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Test3 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test3(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Test3 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test3(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Test3 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Test3(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Test3 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Test3(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Test3> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test3.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test3> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test3.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Test3> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test3.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test3> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test3.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
