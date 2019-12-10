package org.fisco.bcos.v2.filter;

import java.math.BigInteger;
import org.fisco.bcos.v2.abi.TypeEncoder;
import org.fisco.bcos.v2.abi.datatypes.Bytes;
import org.fisco.bcos.v2.common.Numeric;
import org.fisco.bcos.v2.crypto.Hash;

public class TopicTools {
    public static final int MAX_NUM_TOPIC_EVENT_LOG = 4;

    public static String integerToTopic(BigInteger i) {
        return Numeric.toHexStringWithPrefixZeroPadded(i, 64);
    }

    public static String boolToTopic(boolean b) {
        if (b) {
            return Numeric.toHexStringWithPrefixZeroPadded(BigInteger.ONE, 64);
        } else {
            return Numeric.toHexStringWithPrefixZeroPadded(BigInteger.ZERO, 64);
        }
    }

    public static String addressToTopic(String s) {

        if (!WalletUtils.isValidAddress(s)) {
            throw new IllegalArgumentException("invalid address");
        }

        return "0x000000000000000000000000" + Numeric.cleanHexPrefix(s);
    }

    public static String stringToTopic(String s) {
        byte[] hash = Hash.sha3(s.getBytes());
        return Numeric.toHexString(hash);
    }

    public static String bytesToTopic(byte[] b) {
        byte[] hash = Hash.sha3(b);
        return Numeric.toHexString(hash);
    }

    public static String byteNToTopic(byte[] b) {
        // byte[] can't be more than 32 byte
        if (b.length > 32) {
            throw new IllegalArgumentException("byteN can't be more than 32 byte");
        }

        Bytes bs = new Bytes(b.length, b);
        return Numeric.prependHexPrefix(TypeEncoder.encode(bs));
    }
}
