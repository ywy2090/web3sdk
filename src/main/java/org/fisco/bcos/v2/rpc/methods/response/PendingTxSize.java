package org.fisco.bcos.v2.rpc.methods.response;

import java.math.BigInteger;
import org.fisco.bcos.v2.common.Numeric;

/** getPendingTxSize */
public class PendingTxSize extends Response<String> {
    public BigInteger getPendingTxSize() {
        return Numeric.decodeQuantity(getResult());
    }
}
