package org.fisco.bcos.web3j.protocol.core.methods.response;

import java.math.BigInteger;
import org.fisco.bcos.web3j.common.Numeric;
import org.fisco.bcos.web3j.protocol.core.Response;

/** getPendingTxSize */
public class PendingTxSize extends Response<String> {
    public BigInteger getPendingTxSize() {
        return Numeric.decodeQuantity(getResult());
    }
}
