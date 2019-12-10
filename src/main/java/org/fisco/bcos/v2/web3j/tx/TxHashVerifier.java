package org.fisco.bcos.v2.web3j.tx;

public class TxHashVerifier {
    public boolean verify(String hash1, String hash2) {
        return hash1.equals(hash2);
    }
}
