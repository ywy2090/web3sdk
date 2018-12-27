package org.fisco.bcos.temp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
public class Ok extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060016000800160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506402540be40060006001018190555060028060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600260010181905550610388806100c26000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806366c99139146100515780636d4ce63c1461007e575b600080fd5b34801561005d57600080fd5b5061007c600480360381019080803590602001909291905050506100a9565b005b34801561008a57600080fd5b506100936102aa565b6040518082815260200191505060405180910390f35b8060006001015410806100c757506002600101548160026001015401105b156100d1576102a7565b80600060010154036000600101819055508060026001016000828254019250508190555060046080604051908101604052806040805190810160405280600881526020017f323031373034313300000000000000000000000000000000000000000000000081525081526020016000800160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381525090806001815401808255809150509060018203906000526020600020906004020160009091929091909150600082015181600001908051906020019061020a9291906102b7565b5060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550606082015181600301555050505b50565b6000600260010154905090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106102f857805160ff1916838001178555610326565b82800160010185558215610326579182015b8281111561032557825182559160200191906001019061030a565b5b5090506103339190610337565b5090565b61035991905b8082111561035557600081600090555060010161033d565b5090565b905600a165627a7a7230582072dfc0a67a2f46c154cec9a870fbdf1c6d138c599bdb121a63f6c4d23e11a8c70029";

    public static final String FUNC_TRANS = "trans";

    public static final String FUNC_GET = "get";

    @Deprecated
    protected Ok(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ok(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Ok(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Ok(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> trans(BigInteger num) {
        final Function function = new Function(
                FUNC_TRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(num)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> get() {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Ok load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ok(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Ok load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ok(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Ok load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Ok(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Ok load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Ok(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Ok> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Ok.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Ok> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Ok.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Ok> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Ok.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Ok> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Ok.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
