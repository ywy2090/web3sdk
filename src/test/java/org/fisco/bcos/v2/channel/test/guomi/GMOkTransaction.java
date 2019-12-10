package org.fisco.bcos.v2.channel.test.guomi;

import java.math.BigInteger;
import org.fisco.bcos.v2.channel.client.Service;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.crypto.EncryptType;
import org.fisco.bcos.v2.crypto.tools.GenCredential;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.rpc.service.ChannelService;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GMOkTransaction {
    public static void main(String[] args) throws Exception {
        EncryptType encryptType = new EncryptType(1);
        String groupId = "1";
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Service service = context.getBean(Service.class);
        service.run();
        System.out.println("===================================================================");

        ChannelService channelEthereumService = new ChannelService();
        channelEthereumService.setService(service);
        channelEthereumService.setTimeout(10000);
        Web3j web3 = Web3j.build(channelEthereumService, Integer.parseInt(groupId));
        BigInteger gasPrice = new BigInteger("300000000");
        BigInteger gasLimit = new BigInteger("3000000000");

        Credentials credentials1 =
                GenCredential.create(
                        "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6");

        ContractGasProvider contractGasProvider = new StaticGasProvider(gasPrice, gasLimit);
        final Ok okDemo = Ok.deploy(web3, credentials1, contractGasProvider).send();

        for (int i = 0; i < 1; i++) {
            System.out.println("####contract address is: " + okDemo.getContractAddress());
            TransactionReceipt receipt = okDemo.trans(new BigInteger("4")).send();

            System.out.println(" balance = " + okDemo.get().send().intValue());
        }
        System.exit(0);
    }
}
