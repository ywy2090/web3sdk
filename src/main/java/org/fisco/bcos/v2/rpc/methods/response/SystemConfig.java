package org.fisco.bcos.v2.rpc.methods.response;

/** getSystemConfigByKey */
public class SystemConfig extends Response<String> {
    public String getSystemConfigByKey() {
        return getResult();
    }
}
