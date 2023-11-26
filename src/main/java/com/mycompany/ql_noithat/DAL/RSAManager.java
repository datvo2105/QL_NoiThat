package com.mycompany.ql_noithat.DAL;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAManager {
    private KeyPair keyPair;

    public RSAManager() {
        generateKeys();
    }

    public RSAManager(String privateKey, String publicKey) {
        keyPair = createKeyPair(privateKey, publicKey);
    }

    public String getPrivateKey() {
        return keyToString(keyPair.getPrivate());
    }

    public String getPublicKey() {
        return keyToString(keyPair.getPublic());
    }

    private void generateKeys() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // You can adjust the key size as needed
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private String keyToString(java.security.Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public String encrypt(String userName) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

            byte[] encryptedBytes = cipher.doFinal(userName.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private KeyPair createKeyPair(String privateKey, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            // Private Key
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
            PrivateKey privateKeyObj = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

            // Public Key
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
            PublicKey publicKeyObj = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

            return new KeyPair(publicKeyObj, privateKeyObj);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

}
