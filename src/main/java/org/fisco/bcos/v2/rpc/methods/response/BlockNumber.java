package org.fisco.bcos.v2.rpc.methods.response;

import java.math.BigInteger;
import org.fisco.bcos.v2.common.Numeric;

/** getblockNumber. */
public class BlockNumber extends Response<String> {
    public BigInteger getBlockNumber() {
        return Numeric.decodeQuantity(getResult());
    }
}
