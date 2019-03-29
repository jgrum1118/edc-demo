package com.optum.chy.tmp.ggmap;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.DatatypeConverter;

public class DesEncryption {
	
	public SecretKey generateSecretKey (String customKey) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
		byte[] keyBytes = DatatypeConverter.parseHexBinary(customKey);
		SecretKeyFactory factory = null;
		factory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = factory.generateSecret(new DESKeySpec(keyBytes));
		return secretKey;
	}
	
	public String encryptString (String stringToEncrypt) throws GeneralSecurityException, NoSuchPaddingException {
		SecretKey secretKey = generateSecretKey("9823456789efcdab");
		Cipher desCipher;
	    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		desCipher.init(Cipher.ENCRYPT_MODE, secretKey);
	    byte[] string = stringToEncrypt.getBytes();
	    byte[] stringEncrypted = desCipher.doFinal(string);
	    
	    final StringBuilder builder = new StringBuilder();
	    for(byte b : stringEncrypted) {
	        builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}
	
	public String decryptString (String stringToDecrypt) throws GeneralSecurityException, NoSuchPaddingException {
		SecretKey secretKey = generateSecretKey("9823456789efcdab");
		Cipher desCipher;
	    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	    desCipher.init(Cipher.DECRYPT_MODE, secretKey);
	    byte[] stringEncrypted = DatatypeConverter.parseHexBinary(stringToDecrypt);
	    byte[] stringDecrypted = desCipher.doFinal(stringEncrypted);
		return new String(stringDecrypted);
	}
}
