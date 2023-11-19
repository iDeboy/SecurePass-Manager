package pruebas;

import java.sql.SQLException;
import models.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositories.RepositorioUsuario;
import sql.SqlConnection;

public final class SqlUsuarioTests {

	private Usuario usuario;

	public SqlUsuarioTests() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws Exception {

		usuario = new Usuario();
		usuario.setNombre("UsuarioPrueba");
		usuario.setPassword("contraseña");
		usuario.setNombrePersona("NombrePrueba");
		usuario.setApellidoPaternoPersona("PatPrueba");
		usuario.setApellidoMeternoPersona("MatPrueba");

	}

	@After
	public void tearDown() throws SQLException {
	}

	@Test
	public void testConnection() {

		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			assertTrue(true);
		} catch (SQLException ex) {
			assertTrue(false);
		}

	}

	@Test
	public void loginUsuarioExistente() {

		var usuario = RepositorioUsuario.loginUsuario("usuario01", "pass123");

		assertNotNull(usuario);
	}

	@Test
	public void loginUsuarioExistenteMal() {

		var usuario = RepositorioUsuario.loginUsuario("usuario01", "pass132");

		assertNull(usuario);
	}

	@Test
	public void loginUsuarioNoExistente() {

		var usuario = RepositorioUsuario.loginUsuario("usuario02", "1234");

		assertNull(usuario);
	}

	@Test
	public void loginNoSqlInjection() {
		var intento = RepositorioUsuario.loginUsuario("' or 1=1 -- ", "1234");

		assertNull(intento);
	}

	@Test
	public void registerUsuario() {

		try {
			assertTrue("No se agrego el usuario", RepositorioUsuario.addUsuario(usuario));

			SqlConnection sql = new SqlConnection();
			try (var conn = sql.getConnection(); var stmt = conn.prepareStatement("DELETE FROM T_USUARIOS WHERE PK_Nombre_Usuario = ?")) {

				stmt.setString(1, "UsuarioPrueba");
				stmt.executeUpdate();
			}
		} catch (SQLException ex) {
			assertTrue(false);
		}

	}
}
