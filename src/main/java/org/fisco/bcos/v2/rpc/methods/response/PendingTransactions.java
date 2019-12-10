package org.fisco.bcos.v2.rpc.methods.response;

import java.util.List;

/** getPendingTransactions */
public class PendingTransactions extends Response<List<Transaction>> {
    public List<Transaction> getPendingTransactions() {
        return getResult();
    }
}
