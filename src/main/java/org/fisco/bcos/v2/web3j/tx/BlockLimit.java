package org.fisco.bcos.v2.web3j.tx;


import java.math.BigInteger;

public class BlockLimit {
    private BigInteger blockLimit = BigInteger.valueOf(600);

    public BigInteger getBlockLimit() {
        return blockLimit;
    }

    public void setBlockLimit(BigInteger blockLimit) {
        this.blockLimit = blockLimit;
    }
}
