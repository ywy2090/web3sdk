package org.fisco.bcos.v2.rpc.methods.response;

import java.util.List;

/** getGroupList */
public class GroupList extends Response<List<String>> {

    public List<String> getGroupList() {
        return getResult();
    }
}
