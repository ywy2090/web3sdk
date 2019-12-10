package org.fisco.bcos.v2.web3j;

import org.fisco.bcos.v2.rpc.Rpc;
import org.fisco.bcos.v2.rpc.methods.JsonRpc2_0;
import org.fisco.bcos.v2.rpc.methods.Rpc;
import org.fisco.bcos.v2.rpc.service.RpcService;

/** JSON-RPC Request object building factory. */
public interface Web3j extends Rpc {
    static Web3j build(RpcService web3jService, int groupId) {
        return new JsonRpc2_0(web3jService, groupId);
    }
}
