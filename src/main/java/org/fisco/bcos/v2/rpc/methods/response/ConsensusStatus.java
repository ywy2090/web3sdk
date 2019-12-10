package org.fisco.bcos.v2.rpc.methods.response;

/** getConsensusStatus */
public class ConsensusStatus extends Response<String> {
    public String getConsensusStatus() {
        return getResult();
    }
}
