package org.fisco.bcos.v2.precompile.config;

import java.math.BigInteger;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.precompile.common.PrecompiledCommon;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;

public class SystemConfigService {
    private static BigInteger gasPrice = new BigInteger("300000000");
    private static BigInteger gasLimit = new BigInteger("300000000");
    private static String systemConfigPrecompileAddress =
            "0x0000000000000000000000000000000000001000";
    private SystemConfig systemConfig;
    private Web3j web3j;

    public SystemConfigService(Web3j web3j, Credentials credentials) {
        ContractGasProvider contractGasProvider = new StaticGasProvider(gasPrice, gasLimit);
        systemConfig =
                SystemConfig.load(
                        systemConfigPrecompileAddress, web3j, credentials, contractGasProvider);
        this.web3j = web3j;
    }

    public String setValueByKey(String key, String value) throws Exception {
        TransactionReceipt receipt = systemConfig.setValueByKey(key, value).send();
        return PrecompiledCommon.handleTransactionReceipt(receipt, web3j);
    }
}
