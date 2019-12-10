package org.fisco.bcos.v2.crypto.sm.sm2.crypto.params;

import org.fisco.bcos.v2.crypto.sm.sm2.crypto.CipherParameters;

public class KeyParameter implements CipherParameters {

    private byte[] key;

    public KeyParameter(byte[] key) {
        this(key, 0, key.length);
    }

    public KeyParameter(byte[] key, int keyOff, int keyLen) {
        this.key = new byte[keyLen];

        System.arraycopy(key, keyOff, this.key, 0, keyLen);
    }

    public byte[] getKey() {
        return key;
    }
}
