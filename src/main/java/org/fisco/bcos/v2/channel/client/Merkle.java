package org.fisco.bcos.v2.channel.client;

import java.util.Arrays;
import java.util.List;
import org.fisco.bcos.v2.crypto.Hash;
import org.fisco.bcos.v2.rpc.methods.response.MerkleProofUnit;

public class Merkle {
    public static String calculateMerkleRoot(List<MerkleProofUnit> merkleProofUnits, String hash) {
        if (merkleProofUnits == null) {
            return hash;
        }
        String result = hash;
        for (MerkleProofUnit merkleProofUnit : merkleProofUnits) {
            String left = splicing(merkleProofUnit.getLeft());
            String right = splicing(merkleProofUnit.getRight());
            String input = splicing("0x", left, result.substring(2), right);
            result = Hash.sha3(input);
        }
        return result;
    }

    private static String splicing(List<String> stringList) {
        StringBuilder result = new StringBuilder();
        for (String eachString : stringList) {
            result.append(eachString);
        }
        return result.toString();
    }

    private static String splicing(String... stringList) {
        return splicing(Arrays.<String>asList(stringList));
    }
}
