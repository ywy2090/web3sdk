package org.fisco.bcos.v2.rpc.methods.response;

import java.util.List;

/** getGroupPeers */
public class GroupPeers extends Response<List<String>> {
    public List<String> getGroupPeers() {
        return getResult();
    }
}
