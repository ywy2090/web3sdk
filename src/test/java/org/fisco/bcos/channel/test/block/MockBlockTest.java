package org.fisco.bcos.channel.test.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigInteger;
import org.fisco.bcos.web3j.common.deserializer.ObjectMapperFactory;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.Web3jService;
import org.fisco.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.fisco.bcos.web3j.protocol.core.Request;
import org.fisco.bcos.web3j.protocol.core.methods.response.BcosBlock;
import org.junit.Test;

public class MockBlockTest {

    private Web3jService web3jService = mock(Web3jService.class);
    private ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
    private final String rawResponse =
            "{\"id\":0,\"jsonrpc\":\"2.0\",\"result\":{\"extraData\":[],\"gasLimit\":\"0x0\",\"gasUsed\":\"0x0\",\"hash\":\"0xb1b1612e3d2e6571304e53136002b6c79ae53fcfa207dbe350b61c4a6d0f157f\",\"logsBloom\":\"0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000\",\"number\":\"0x1\",\"parentHash\":\"0xe325463b4ed6746dfc4a127e979fd6b95c7d32c754a21e7afbcb8f16b5d0880c\",\"sealer\":\"0x0\",\"stateRoot\":\"0x06ca72b2a5d14f8497412150ecc2d3744c85c26c43a639ba73879f5106ac64d0\",\"timestamp\":\"0x1684a53a6fb\",\"transactions\":[{\"blockHash\":\"0xb1b1612e3d2e6571304e53136002b6c79ae53fcfa207dbe350b61c4a6d0f157f\",\"blockNumber\":\"0x1\",\"from\":\"0x148947262ec5e21739fe3a931c29e8b84ee34a0f\",\"gas\":\"0x11e1a300\",\"gasPrice\":\"0x11e1a300\",\"hash\":\"0xcf9de56878da55b2fb4156bc6268e65d519b87d2b8a320c9f08a966651aa44b1\",\"input\":\"0x60606040525b6001600060005060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908302179055506402540be4006000600050600101600050819055506002600260005060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff0219169083021790555060006002600050600101600050819055505b6104168061009e6000396000f360606040526000357c01000000000000000000000000000000000000000000000000000000009004806366c99139146100475780636d4ce63c1461006457610042565b610002565b3461000257610062600480803590602001909190505061008c565b005b346100025761007660048050506103fe565b6040518082815260200191505060405180910390f35b80600060005060010160005054036000600050600101600050819055508060026000506001016000828282505401925050819055507fb797d73164cc7b1c119ca7507c18ac67eac964ca7eed3b0fbdd4e63caab2ca65816040518082815260200191505060405180910390a16004600050805480600101828181548183558181151161020c5760040281600402836000526020600020918201910161020b9190610131565b8082111561020757600060008201600050805460018160011615610100020316600290046000825580601f1061016757506101a4565b601f0160209004906000526020600020908101906101a39190610185565b8082111561019f5760008181506000905550600101610185565b5090565b5b506001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556002820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600382016000506000905550600401610131565b5090565b5b5050509190906000526020600020906004020160005b608060405190810160405280604060405190810160405280600881526020017f32303137303431330000000000000000000000000000000000000000000000008152602001508152602001600060005060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168152602001600260005060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681526020018581526020015090919091506000820151816000016000509080519060200190828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061032a57805160ff191683800117855561035b565b8280016001018555821561035b579182015b8281111561035a57825182600050559160200191906001019061033c565b5b5090506103869190610368565b808211156103825760008181506000905550600101610368565b5090565b505060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff0219169083021790555060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff02191690830217905550606082015181600301600050555050505b50565b60006002600050600101600050549050610413565b9056ef\",\"nonce\":\"0x3df8ad22eff71f4a835e6dd61c6f60b71aded81a86fc4771b5ddba5b48256e0\",\"to\":null,\"transactionIndex\":\"0x0\",\"value\":\"0x0\"}],\"transactionsRoot\":\"0x0aa79ed38e5ea8ff8828f379fa671b0f018b3f38f4e2a4f36062bc35bd55b8ff\"}}\n";

    public MockBlockTest() throws IOException {}

    @Test
    public void getBlockNumber() throws IOException {

        BcosBlock block = objectMapper.readValue(rawResponse, BcosBlock.class);
        block.setRawResponse(rawResponse);

        Web3j web3j = Web3j.build(web3jService, 1);
        when(web3jService.send(any(Request.class), eq(BcosBlock.class))).thenReturn(block);

        BcosBlock mockBlocks =
                web3j.getBlockByNumber(DefaultBlockParameter.valueOf(new BigInteger("1")), true)
                        .send();
        BcosBlock.Block mockBlock = mockBlocks.getBlock();
        assertEquals(mockBlock.getNonce(), new BigInteger("0"));
        assertTrue(mockBlock.getNumber().intValue() == 1);
    }
}
