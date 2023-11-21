package pruebas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import models.CredencialBancaria;
import models.CredencialInternet;
import models.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositories.*;
import sql.SqlConnection;

public final class SqlCredencialesTests {

	private Usuario usuario;

	public SqlCredencialesTests() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		usuario = RepositorioUsuario.loginUsuario("usuario01", "pass123");
	}

	@After
	public void tearDown() {
	}

	@Test
	public void getCredenciales() {

		var credenciales = RepositorioCredencial.getCredenciales(usuario);

		assertNotNull(credenciales);
	}

	@Test
	public void addCredencialInternet() throws Exception {

		CredencialInternet credencial = new CredencialInternet();

		credencial.setNombreUsuario(usuario.getNombre());
		credencial.setNombrePlataforma("Prueba");
		credencial.setUsuarioWeb("Prueba");
		credencial.setPassword("Prueba");
		credencial.setUrl("Prueba");
		credencial.setInfoExtra("Prueba");
		var now = LocalDateTime.now();
		credencial.setFechaAlta(now);
		credencial.setFechaUpdate(now);

		assertTrue(RepositorioCredencial.addCredencial(credencial));

		SqlConnection sql = new SqlConnection();
		try (var conn = sql.getConnection(); var stmt = conn.prepareStatement("DELETE FROM T_CREDENCIALES WHERE ID_Credencial = ?")) {

			stmt.setInt(1, credencial.getId());
			stmt.executeUpdate();
		}

	}

	@Test
	public void addCredencialBancarias() throws Exception {

		CredencialBancaria credencial = new CredencialBancaria();

		credencial.setNombreUsuario(usuario.getNombre());
		credencial.setNombreBanco("Prueba");
		credencial.setNumeroTarjeta("1111222233334444");
		credencial.setCVV("123");
		credencial.setFechaCaducidad(LocalDate.of(2025, 12, 1));
		credencial.setInfoExtra("Prueba");
		var now = LocalDateTime.now();
		credencial.setFechaAlta(now);
		credencial.setFechaUpdate(now);

		assertTrue(RepositorioCredencial.addCredencial(credencial));

		SqlConnection sql = new SqlConnection();
		try (var conn = sql.getConnection(); var stmt = conn.prepareStatement("DELETE FROM T_CREDENCIALES_BANCARIAS WHERE ID_Credencial_Bancaria = ?")) {

			stmt.setInt(1, credencial.getId());
			stmt.executeUpdate();
		}

	}

	@Test
	public void editCredencialInternet() throws Exception {

		CredencialInternet credencial = new CredencialInternet();

		credencial.setNombreUsuario(usuario.getNombre());
		credencial.setNombrePlataforma("Prueba");
		credencial.setUsuarioWeb("Prueba");
		credencial.setPassword("Prueba");
		credencial.setUrl("Prueba");
		credencial.setInfoExtra("Prueba");
		var now = LocalDateTime.now();
		credencial.setFechaAlta(now);
		credencial.setFechaUpdate(now);

		RepositorioCredencial.addCredencial(credencial);

		credencial.setNombrePlataforma("PruebaOtra");
		credencial.setPassword("123456");

		assertTrue(RepositorioCredencial.editCredencial(credencial));

		SqlConnection sql = new SqlConnection();
		try (var conn = sql.getConnection(); var stmt = conn.prepareStatement("DELETE FROM T_CREDENCIALES WHERE ID_Credencial = ?")) {

			stmt.setInt(1, credencial.getId());
			stmt.executeUpdate();
		}
	}

	@Test
	public void editCredencialBancaria() throws Exception {

		CredencialBancaria credencial = new CredencialBancaria();

		credencial.setNombreUsuario(usuario.getNombre());
		credencial.setNombreBanco("Prueba");
		credencial.setNumeroTarjeta("1111222233334444");
		credencial.setCVV("123");
		credencial.setFechaCaducidad(LocalDate.of(2025, 12, 1));
		credencial.setInfoExtra("Prueba");
		var now = LocalDateTime.now();
		credencial.setFechaAlta(now);
		credencial.setFechaUpdate(now);

		RepositorioCredencial.addCredencial(credencial);

		credencial.setNombreBanco("OtroBanco");
		credencial.setCVV("999");

		assertTrue(RepositorioCredencial.editCredencial(credencial));

		SqlConnection sql = new SqlConnection();
		try (var conn = sql.getConnection(); var stmt = conn.prepareStatement("DELETE FROM T_CREDENCIALES_BANCARIAS WHERE ID_Credencial_Bancaria = ?")) {

			stmt.setInt(1, credencial.getId());
			stmt.executeUpdate();
		}

	}

	@Test
	public void removeCredencialInternet() throws Exception {

		CredencialInternet credencial = new CredencialInternet();

		credencial.setNombreUsuario(usuario.getNombre());
		credencial.setNombrePlataforma("Prueba");
		credencial.setUsuarioWeb("Prueba");
		credencial.setPassword("Prueba");
		credencial.setUrl("Prueba");
		credencial.setInfoExtra("Prueba");
		var now = LocalDateTime.now();
		credencial.setFechaAlta(now);
		credencial.setFechaUpdate(now);

		RepositorioCredencial.addCredencial(credencial);

		assertTrue(RepositorioCredencial.removeCredencial(credencial));
	}

	@Test
	public void removeCredencialBancaria() throws Exception {

		CredencialBancaria credencial = new CredencialBancaria();

		credencial.setNombreUsuario(usuario.getNombre());
		credencial.setNombreBanco("Prueba");
		credencial.setNumeroTarjeta("1111222233334444");
		credencial.setCVV("123");
		credencial.setFechaCaducidad(LocalDate.of(2025, 12, 1));
		credencial.setInfoExtra("Prueba");
		var now = LocalDateTime.now();
		credencial.setFechaAlta(now);
		credencial.setFechaUpdate(now);

		RepositorioCredencial.addCredencial(credencial);

		assertTrue(RepositorioCredencial.removeCredencial(credencial));

	}
}
