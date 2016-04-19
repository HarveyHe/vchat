package com.harvey.vchat.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * AES Encryption
 * 
 */
public class AESEncryptorHelper {

	private static final Logger LOGGER = Logger
			.getLogger(AESEncryptorHelper.class);

	/** Encryption name */
	private static final String KEY_ALGORITHM = "AES";
	/** Encryption function */
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	/** UC key */
	public static final String KEY_FOR_UC = "dw2e3F30E7BA8@3C";

	private AESEncryptorHelper() {

	}

	/**
	 * generate ram key <br/>
	 * 
	 * 
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @deprecated
	 */
	@Deprecated
	public static Key toRandomKey(String key) {
		// KeyGenerator
		KeyGenerator kgen;
		try {
			kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
			// AES key lenth 128
			kgen.init(128, new SecureRandom(key.getBytes(StandardCharsets.UTF_8)));

			// new key
			SecretKey secretKey = kgen.generateKey();
			//
			byte[] enCodeFormat = secretKey.getEncoded();
			return new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("", e);
		}
		
		return null;
	}

	/**
	 * 
	 * 
	 * @param password
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static Key toKey(String password)
			throws UnsupportedEncodingException {
		return new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8), KEY_ALGORITHM);
	}

	/**
	 * 
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte[] buf) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 
	 * 
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return new byte[0];
		}
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static String encrypt(String content) {
		return encrypt(content, KEY_FOR_UC);
	}

	/**
	 * 
	 * 
	 * @param content
	 * 
	 * @param password
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content, String password) {
		if (StringUtils.isBlank(content)) {
			return "";
		}
		try {
			//
			Key key = toKey(password);
			//
			byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
			//
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			//
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//
			byte[] result = cipher.doFinal(byteContent);

			return parseByte2HexStr(result);
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		return "";
	}

	public static String decrypt(String content) {
		return decrypt(content, KEY_FOR_UC);
	}

	/**
	 * 
	 * 
	 * @param content
	 * 
	 * @param password
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String content, String password) {
		if (StringUtils.isBlank(content)) {
			return "";
		}

		try {
			//
			byte[] contentHex = parseHexStr2Byte(content);

			//
			Key key = toKey(password);
			//
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			//
			cipher.init(Cipher.DECRYPT_MODE, key);
			//
			byte[] result = cipher.doFinal(contentHex);

			return new String(result, StandardCharsets.UTF_8);
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		return "";
	}

}
