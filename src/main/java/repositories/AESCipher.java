package repositories;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Brinda metodos para encriptar y desencriptar usando AES 256
 */
public final class AESCipher {

	private AESCipher() {
	}

	/**
	 *
	 * @param <T> Tipo de parametro de entrada
	 * @param input Lo que hay que encriptar
	 * @param key Cadena que servira de llave para encriptar
	 * @return Cadena en base 64
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws InvalidAlgorithmParameterException
	 */
	public static <T> String encrypt(T input, String key) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException {

		var keyBytes = key.getBytes();

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec keySpec = new PBEKeySpec(key.toCharArray(), keyBytes, 10, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(keySpec).getEncoded(), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

		var bytes = adjustKeyLength(keyBytes, 16);
		IvParameterSpec iv = new IvParameterSpec(bytes);
		cipher.init(Cipher.ENCRYPT_MODE, secret, iv);

		byte[] encrypted = cipher.doFinal(input.toString().getBytes());

		return Base64.getEncoder().encodeToString(encrypted);
	}

	public static String decrypt(String input, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException {

		var keyBytes = key.getBytes();

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec keySpec = new PBEKeySpec(key.toCharArray(), keyBytes, 10, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(keySpec).getEncoded(), "AES");

		var bytes = adjustKeyLength(keyBytes, 16);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		IvParameterSpec iv = new IvParameterSpec(bytes);
		cipher.init(Cipher.DECRYPT_MODE, secret, iv);

		byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(input));

		return new String(decrypted, StandardCharsets.UTF_8);

	}

	public static byte[] adjustKeyLength(byte[] key, int desiredLength) throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashedKey = digest.digest(key);

		if (hashedKey.length == desiredLength) {
			return hashedKey;
		} else {
			return Arrays.copyOf(hashedKey, desiredLength);
		}

	}
}
