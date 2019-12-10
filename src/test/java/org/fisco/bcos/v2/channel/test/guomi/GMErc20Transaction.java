package org.fisco.bcos.v2.channel.test.guomi;

import java.math.BigInteger;
import org.fisco.bcos.v2.channel.client.Service;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.crypto.EncryptType;
import org.fisco.bcos.v2.crypto.tools.GenCredential;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.rpc.service.ChannelService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GMErc20Transaction {
    public static void main(String[] args) throws Exception {
        EncryptType encryptType = new EncryptType(1);
        System.out.println(encryptType.getEncryptType());
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
        BigInteger gasLimit = new BigInteger("300000000");

        Credentials credentials1 =
                GenCredential.create(
                        "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6");

        ContractGasProvider contractGasProvider = new StaticGasProvider(gasPrice, gasLimit);
        NewSolTest erc20 = NewSolTest.deploy(web3, credentials1, contractGasProvider).send();

        for (int i = 0; i < 1; i++) {
            System.out.println("####contract address is: " + erc20.getContractAddress());
            erc20.transfer("0x0f49a17d17f82da2a7d92ecf19268274150eaf5e", new BigInteger("100"))
                    .send();

            BigInteger oldBalance =
                    erc20.balanceOf("0x0f49a17d17f82da2a7d92ecf19268274150eaf5e").send();
            System.out.println(
                    "0x0f49a17d17f82da2a7d92ecf19268274150eaf5e balance" + oldBalance.intValue());
        }
        System.exit(0);
    }
}
