package repositories;

import sql.SqlConnection;
import models.Usuario;

/**
 * Clase que unicamente valida o extrae los datos de los usuarios de la base de
 * datos.
 */
public final class RepositorioUsuario {

	/**
	 * Revisa si el usuario y la contraseña coinciden para iniciar sesión.
	 *
	 * @param nombreUsuario Nombre del usuario
	 * @param password Contraseña del usuario
	 * @return Devuelve {@code null} si el usuario alguno de los datos del usuario
	 * esta mal o devuelve los datos completos del usuario.
	 */
	public static Usuario loginUsuario(String nombreUsuario, String password) {

		if (nombreUsuario == null || password == null) {
			return null;
		}

		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			Usuario user = new Usuario();
			user.setNombre(nombreUsuario);
			user.setPassword(password);

			try (var stmt = conn.prepareStatement(
							"SELECT Nombre_Usuario_Titular, AP_PAT, AP_MAT "
							+ "FROM T_USUARIOS "
							+ "WHERE PK_Nombre_Usuario = ? AND Password = ?")) {

				stmt.setString(1, user.getNombre());
				stmt.setString(2, user.getEncryptedPassword());

				try (var result = stmt.executeQuery()) {

					if (result.next()) {

						user.setNombrePersona(result.getString(1));
						user.setApellidoPaternoPersona(result.getString(2));
						user.setApellidoMeternoPersona(result.getString(3));

						return user;
					}

				}

			}

		} catch (Exception ex) {

		}

		return null;
	}

	/**
	 * Registra un usuario a la base de datos.
	 *
	 * @param usuario Usuario a registrar
	 * @return Devuelve {@code false} si el usuario no se pudo registrar o
	 * {@code true} si el registro se hizo con exito.f
	 */
	public static boolean addUsuario(Usuario usuario) {

		if (!validarUsuario(usuario)) {
			return false;
		}

		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			try (var stmt = conn.prepareStatement(
							"INSERT INTO T_USUARIOS "
							+ "VALUES(?, ?, ?, ?, ?)")) {

				stmt.setString(1, usuario.getNombre());
				stmt.setString(2, usuario.getEncryptedPassword());
				stmt.setString(3, usuario.getNombrePersona());
				stmt.setString(4, usuario.getApellidoPaternoPersona());
				stmt.setString(5, usuario.getApellidoMeternoPersona());

				stmt.executeUpdate();

				return true;
			}

		} catch (Exception ex) {

		}

		return false;
	}

	static boolean validarUsuario(Usuario usuario) {

		if (usuario == null) {
			return false;
		}

		if (!validateStr(usuario.getNombre())) {
			return false;
		}

		if (!validateStr(usuario.getNombrePersona())) {
			return false;
		}

		if (!validateStr(usuario.getApellidoMeternoPersona())) {
			return false;
		}

		if (!validateStr(usuario.getApellidoPaternoPersona())) {
			return false;
		}

		return true;
	}

	private static boolean validateStr(String str) {
		return str != null && !str.isEmpty();
	}

}
