/**
 *
 */
package com.ecomm.akhtar.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Mail;

/**
 * @author Ahmar
 *
 */
public class CommonUtils {

	public static String generateEncryptedHash(String key, String keyValue)
			throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, CustomException {
		try {
			byte[] bytekey = hexStringToByteArray(key);
			SecretKeySpec sks = new SecretKeySpec(bytekey, EcommUriConstants.AES);
			Cipher cipher = Cipher.getInstance(EcommUriConstants.AES);
			cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
			byte[] encrypted = cipher.doFinal(keyValue.getBytes());
			// String encryptedpwd = byteArrayToHexString(encrypted);
			return byteArrayToHexString(encrypted);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}

	}

	public static String generateDecryptedHash(String key, String encryptKey)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, CustomException {
		try {
			byte[] bytekey = hexStringToByteArray(key);
			SecretKeySpec sks = new SecretKeySpec(bytekey, EcommUriConstants.AES);
			Cipher cipher = Cipher.getInstance(EcommUriConstants.AES);
			cipher.init(Cipher.DECRYPT_MODE, sks);
			byte[] decrypted = cipher.doFinal(hexStringToByteArray(encryptKey));
			return new String(decrypted);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}

	}

	public static String generatePublicKey(String algorithm) throws NoSuchAlgorithmException, CustomException {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
			keyGen.init(128);
			SecretKey sk = keyGen.generateKey();
			return byteArrayToHexString(sk.getEncoded());
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}

	}

	public static String dBdate(LocalDateTime param) throws CustomException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			return param.format(formatter);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}

	}

	public static String dBdateToDate(String dateString) throws CustomException {

		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = df.parse(dateString);
			DateFormat dfString = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return dfString.format(date);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}
	}

	public static Mail setEmailObject(String to, String subject) {

		Mail mail = new Mail();
		// mail.setFrom("Akhtar Ecommerce");
		mail.setTo(to);
		mail.setSubject(subject);
		return mail;

	}

	private static String byteArrayToHexString(byte[] b) throws CustomException {

		try {
			StringBuilder sb = new StringBuilder(b.length * 2);
			for (int i = 0; i < b.length; i++) {
				int v = b[i] & 0xff;
				if (v < 16) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(v));
			}
			return sb.toString().toUpperCase();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}

	}

	private static byte[] hexStringToByteArray(String s) throws CustomException {

		try {
			byte[] b = new byte[s.length() / 2];
			for (int i = 0; i < b.length; i++) {
				int index = i * 2;
				int v = Integer.parseInt(s.substring(index, index + 2), 16);
				b[i] = (byte) v;
			}
			return b;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), false);
		}

	}

}
