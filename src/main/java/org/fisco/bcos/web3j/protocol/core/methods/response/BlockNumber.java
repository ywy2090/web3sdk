package org.fisco.bcos.web3j.protocol.core.methods.response;

import java.math.BigInteger;
import org.fisco.bcos.web3j.common.Numeric;
import org.fisco.bcos.web3j.protocol.core.Response;

/** getblockNumber. */
public class BlockNumber extends Response<String> {
    public BigInteger getBlockNumber() {
        return Numeric.decodeQuantity(getResult());
    }
}
