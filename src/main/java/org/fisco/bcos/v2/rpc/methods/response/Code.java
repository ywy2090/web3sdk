package org.fisco.bcos.v2.rpc.methods.response;

/** getCode. */
public class Code extends Response<String> {
    public String getCode() {
        return getResult();
    }
}
