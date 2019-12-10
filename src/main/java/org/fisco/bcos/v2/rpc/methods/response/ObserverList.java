package org.fisco.bcos.v2.rpc.methods.response;

import java.util.List;

public class ObserverList extends Response<List<String>> {

    public List<String> getObserverList() {
        return getResult();
    }
}
