package org.fisco.bcos.v2.crypto.tools;

import java.math.BigInteger;
import java.security.KeyPair;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.crypto.ECKeyPair;
import org.fisco.bcos.v2.crypto.EncryptType;
import org.fisco.bcos.v2.crypto.Keys;
import org.fisco.bcos.v2.crypto.sm.sm2.crypto.asymmetric.SM2KeyGenerator;
import org.fisco.bcos.v2.crypto.sm.sm2.crypto.asymmetric.SM2PrivateKey;
import org.fisco.bcos.v2.crypto.sm.sm2.crypto.asymmetric.SM2PublicKey;
import org.fisco.bcos.v2.crypto.sm.sm2.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenCredential {
    private static Logger logger = LoggerFactory.getLogger(GenCredential.class);

    public static ECKeyPair createSMKeyPair() {
        final SM2KeyGenerator generator = new SM2KeyGenerator();
        final KeyPair keyPairData = generator.generateKeyPair();
        if (keyPairData != null) return genECPairFromKeyPair(keyPairData);
        return null;
    }

    private static ECKeyPair genECPairFromKeyPair(KeyPair keyPairData) {
        SM2PrivateKey vk = (SM2PrivateKey) keyPairData.getPrivate();
        SM2PublicKey pk = (SM2PublicKey) keyPairData.getPublic();
        final byte[] publicKey = pk.getEncoded();
        final byte[] privateKey = vk.getEncoded();

        BigInteger biPublic = new BigInteger(Hex.toHexString(publicKey), 16);
        BigInteger biPrivate = new BigInteger(Hex.toHexString(privateKey), 16);

        ECKeyPair keyPair = new ECKeyPair(biPrivate, biPublic);
        return keyPair;
    }

    private static ECKeyPair createSMKeyPair(String privKey) {
        SM2KeyGenerator generator = new SM2KeyGenerator();
        final KeyPair keyPairData = generator.generateKeyPair(privKey);
        if (keyPairData != null) return genECPairFromKeyPair(keyPairData);
        return null;
    }

    private static ECKeyPair createECDSAKeyPair(String privKey) {
        BigInteger bigPrivKey = new BigInteger(privKey, 16);
        ECKeyPair keyPair = ECKeyPair.create(bigPrivKey);
        return keyPair;
    }

    private static ECKeyPair createECDSAKeyPair() {
        ECKeyPair keyPair = Keys.createEcKeyPair();
        return keyPair;
    }

    public static ECKeyPair createKeyPair(int encryptType) {
        // use guomi
        if (encryptType == EncryptType.SM_TYPE) return createSMKeyPair();
        return createECDSAKeyPair(); // default use ECDSA
    }

    public static ECKeyPair createKeyPair(String privKey, int encryptType) {
        if (encryptType == EncryptType.SM_TYPE) return createSMKeyPair(privKey);
        return createECDSAKeyPair(privKey);
    }

    public static Credentials create(int encryptType) {
        try {
            ECKeyPair keyPair = createKeyPair(encryptType);
            if (keyPair == null) return null;

            Credentials credentials = Credentials.create(keyPair);
            return credentials;
        } catch (Exception e) {
            System.out.println("init credential failed");
            logger.error("init credential failed, error msg:" + e.getMessage());
            return null;
        }
    }

    public static Credentials create(String privKey, int encryptType) {
        try {
            ECKeyPair keyPair = createKeyPair(privKey, encryptType);
            if (keyPair == null) return null;
            Credentials credentials = Credentials.create(keyPair);
            return credentials;
        } catch (Exception e) {
            System.out.println("init credential from private key failed ");
            logger.error("init credential from private key failed, error msg:" + e.getMessage());
            return null;
        }
    }

    public static Credentials create(ECKeyPair keyPair, int encryptType) {
        ECKeyPair newKeyPair = createKeyPair(keyPair.getPrivateKey().toString(16), encryptType);
        if (newKeyPair == null) return null;
        Credentials credentials = Credentials.create(newKeyPair);

        return credentials;
    }
}
