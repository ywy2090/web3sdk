package org.fisco.bcos.v2.rpc.methods.response;

import java.util.List;

/** getNodeIDList */
public class NodeIDList extends Response<List<String>> {
    public List<String> getNodeIDList() {
        return getResult();
    }
}
