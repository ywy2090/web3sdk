package org.fisco.bcos.v2.rpc.methods.response;

import java.util.List;

public class SealerList extends Response<List<String>> {

    public List<String> getSealerList() {
        return getResult();
    }
}
