package org.fisco.bcos.v2.rpc.methods.response;

import java.math.BigInteger;
import org.fisco.bcos.v2.common.Numeric;

/** getPbftView */
public class PbftView extends Response<String> {

    public BigInteger getPbftView() {
        return Numeric.decodeQuantity(getResult());
    }
}
