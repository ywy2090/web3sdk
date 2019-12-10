package org.fisco.bcos.v2.rpc.methods.response;

/** sendTransaction. */
public class SendTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}
