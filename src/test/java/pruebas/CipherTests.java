package pruebas;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositories.AESCipher;

public class CipherTests {

	private final SecureRandom random;

	public CipherTests() {

		random = new SecureRandom();
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void adjustBytesExtact() {

		byte[] bytes = new byte[16];
		random.nextBytes(bytes);

		try {
			var fixedBytes = AESCipher.adjustKeyLength(bytes, 16);

			assertEquals(fixedBytes.length, 16);
		} catch (NoSuchAlgorithmException ex) {
			assertTrue("Exception :(", false);
		}

	}

	@Test
	public void adjustBytesLess() {

		byte[] bytes = new byte[5];
		random.nextBytes(bytes);

		try {
			var fixedBytes = AESCipher.adjustKeyLength(bytes, 16);

			assertEquals(fixedBytes.length, 16);
		} catch (NoSuchAlgorithmException ex) {
			assertTrue("Exception :(", false);
		}

	}

	@Test
	public void adjustBytesMore() {

		byte[] bytes = new byte[24];
		random.nextBytes(bytes);

		try {
			var fixedBytes = AESCipher.adjustKeyLength(bytes, 16);

			assertEquals(fixedBytes.length, 16);
		} catch (NoSuchAlgorithmException ex) {
			assertTrue("Exception :(", false);
		}

	}

	@Test
	public void encyptTest() {

		String value = "contraseñaSegura@2093_ñ";
		String key = "iDeboy_";

		try {
			AESCipher.encrypt(value, key);
			assertTrue("Valor encriptado", true);
		} catch (Exception ex) {
			assertTrue("No se pudo encriptar", false);
		}

	}

	@Test
	public void decryptTest() {

		String value = "contraseñaSegura@2093_ñ";
		String key = "iDeboy_";

		try {
			var encrypted = AESCipher.encrypt(value, key);
			var decrypted = AESCipher.decrypt(encrypted, key);
			assertEquals(value, decrypted);
		} catch (Exception ex) {
			assertTrue("No se pudo desencriptar", false);
		}

	}
}
