package org.fisco.bcos.v2.rpc.methods.response;

/** getBlockHashByNumber */
public class BlockHash extends Response<String> {
    public String getBlockHashByNumber() {
        return getResult();
    }
}
