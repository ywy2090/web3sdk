package org.fisco.bcos.v2.crypto;
/** Created by websterchen on 2018/3/22. */
public interface SignInterface {
    Sign.SignatureData signMessage(byte[] message, ECKeyPair keyPair);
}
