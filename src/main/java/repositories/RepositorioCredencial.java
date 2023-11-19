package repositories;

import sql.SqlConnection;
import java.util.ArrayList;
import java.util.List;
import models.*;

/**
 * Clase que hace validaciones, agrega, elimina y edita credenciales en la base
 * de datos. Las funcionalidades de los metodos dependen de la clase
 * {@code Usuario}.
 */
public final class RepositorioCredencial {

	/**
	 * Agrega una credencial a la base de datos.
	 * <br>
	 * Nota: La credencial del parametro debe cumplir con todos sus campos llenos.
	 *
	 * @param credencial La credencial a agregar.
	 * @return Devuelve {@code false} si la credencial no se pudo agregar o
	 * {@code true} si se agrego con exito.
	 */
	public static boolean addCredencial(ICredencial credencial) {

		if (credencial == null) {
			return false;
		}

		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			conn.setAutoCommit(false);

			if (credencial instanceof CredencialInternet cInternet) {

				try (var stmt = conn.prepareStatement(
								"INSERT INTO T_CREDENCIALES(Nombre_Plataforma, Usuario_Web, URL, Password, Fecha_Alta, Fecha_Update, Extra, FK_Nombre_Usuario) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) {

					stmt.setString(1, cInternet.getNombrePlataforma());
					stmt.setString(2, cInternet.getUsuarioWeb());
					stmt.setString(3, cInternet.getUrl());
					stmt.setString(4, cInternet.getEncryptedPassword());
					stmt.setDate(5, cInternet.getFechaAlta());
					stmt.setDate(6, cInternet.getFechaUpdate());
					stmt.setString(7, cInternet.getInfoExtra());
					stmt.setString(8, cInternet.getNombreUsuario());

					stmt.executeUpdate();

				}

			} else if (credencial instanceof CredencialBancaria cBancaria) {

				try (var stmt = conn.prepareStatement(
								"INSERT INTO T_CREDENCIALES_BANCARIAS(Nombre_Banco, Numero_Tarjeta, CVV, Fecha_Caducidad, Fecha_Alta, Fecha_Update, Extra, FK_Nombre_Usuario) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) {

					stmt.setString(1, cBancaria.getNombreBanco());
					stmt.setString(2, cBancaria.getNumeroTarjeta());
					stmt.setString(3, cBancaria.getEncryptedCVV());
					stmt.setDate(4, cBancaria.getFechaCaducidad());
					stmt.setDate(5, cBancaria.getFechaAlta());
					stmt.setDate(6, cBancaria.getFechaUpdate());
					stmt.setString(7, cBancaria.getInfoExtra());
					stmt.setString(8, cBancaria.getNombreUsuario());

					stmt.executeUpdate();

				}

			}

			try (var stmt = conn.prepareStatement("SELECT @@identity")) {

				try (var result = stmt.executeQuery()) {

					if (result.next()) {

						credencial.setId(result.getInt(1));
						conn.commit();
						return true;
					}

				}

			}

			conn.rollback();
		} catch (Exception ex) {
		}

		return false;
	}

	/**
	 * Remueve una credencial de la base de datos.
	 *
	 * @param credencial La credencial a eliminar.
	 * @return Devuelve {@code false} si la credencial no se pudo remover o
	 * {@code true} si la credencial se removio con exito.
	 */
	public static boolean removeCredencial(ICredencial credencial) {

		if (credencial == null) {
			return false;
		}

		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			if (credencial instanceof CredencialInternet) {

				try (var stmt = conn.prepareStatement(
								"DELETE FROM T_CREDENCIALES "
								+ "WHERE ID_Credencial = ?")) {

					stmt.setInt(1, credencial.getId());

					stmt.executeUpdate();
					return true;
				}

			} else if (credencial instanceof CredencialBancaria) {

				try (var stmt = conn.prepareStatement(
								"DELETE FROM T_CREDENCIALES_BANCARIAS "
								+ "WHERE ID_Credencial_Bancaria = ?")) {

					stmt.setInt(1, credencial.getId());

					stmt.executeUpdate();
					return true;
				}

			}

		} catch (Exception ex) {

		}

		return false;
	}

	/**
	 * Edita la credencial con la id que tenga el parametro y los datos
	 * actualizados se toman tambien del parametro.
	 *
	 * @param credencial La credencial con los datos cambiados.
	 * @return Devuelve {@code false} si no se pudo editar, o {@code true} si la
	 * credencial se edito con exito.
	 */
	public static boolean editCredencial(ICredencial credencial) {

		if (credencial == null) {
			return false;
		}

		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			credencial.setFechaUpdate(new java.util.Date());

			if (credencial instanceof CredencialInternet cInternet) {

				try (var stmt = conn.prepareStatement(
								"UPDATE T_CREDENCIALES "
								+ "SET Nombre_Plataforma = ?, Usuario_Web = ?, URL = ?, Password = ?, "
								+ "Fecha_Update = ?, Extra = ? "
								+ "WHERE ID_Credencial = ?")) {

					stmt.setString(1, cInternet.getNombrePlataforma());
					stmt.setString(2, cInternet.getUsuarioWeb());
					stmt.setString(3, cInternet.getUrl());
					stmt.setString(4, cInternet.getEncryptedPassword());
					stmt.setDate(5, credencial.getFechaUpdate());
					stmt.setString(6, cInternet.getInfoExtra());
					stmt.setInt(7, cInternet.getId());

					stmt.executeUpdate();
					return true;
				}

			} else if (credencial instanceof CredencialBancaria cBancaria) {

				try (var stmt = conn.prepareStatement(
								"UPDATE T_CREDENCIALES_BANCARIAS "
								+ "SET Nombre_Banco = ?, Numero_Tarjeta = ?, CVV = ?, Fecha_Caducidad = ?, "
								+ "Fecha_Update = ?, Extra = ? "
								+ "WHERE ID_Credencial_Bancaria = ?")) {

					stmt.setString(1, cBancaria.getNombreBanco());
					stmt.setString(2, cBancaria.getNumeroTarjeta());
					stmt.setString(3, cBancaria.getEncryptedCVV());
					stmt.setDate(4, cBancaria.getFechaCaducidad());
					stmt.setDate(5, cBancaria.getFechaUpdate());
					stmt.setString(6, cBancaria.getInfoExtra());
					stmt.setInt(7, cBancaria.getId());

					stmt.executeUpdate();
					return true;
				}

			}

		} catch (Exception ex) {

		}

		return false;
	}

	/**
	 * Obtiene todas las credenciales de internet de un usuario.
	 *
	 * @param usuario El usuario al cual se le van a buscar las credenciales.
	 * @return Devuelve la lista de credenciales de internet que tiene el usuario,
	 * devuelve {@code null} si hugo algun error.
	 */
	public static List<CredencialInternet> getCredencialesInternet(Usuario usuario) {

		if (usuario == null) {
			return null;
		}

		var credenciales = new ArrayList<CredencialInternet>();
		SqlConnection sql = new SqlConnection();

		try (var conn = sql.getConnection()) {

			try (var stmt = conn.prepareStatement(
							"SELECT * FROM T_CREDENCIALES "
							+ "WHERE FK_Nombre_Usuario = ?")) {

				stmt.setString(1, usuario.getNombre());

				try (var result = stmt.executeQuery()) {

					while (result.next()) {

						CredencialInternet cInternet = new CredencialInternet();
						cInternet.setNombreUsuario(usuario.getNombre());
						cInternet.setId(result.getInt(1));
						cInternet.setNombrePlataforma(result.getString(2));
						cInternet.setUsuarioWeb(result.getString(3));
						cInternet.setUrl(result.getString(4));

						var password = AESCipher.decrypt(result.getString(5), cInternet.getNombreUsuario());
						cInternet.setPassword(password);
						cInternet.setFechaAlta(result.getDate(6));
						cInternet.setFechaUpdate(result.getDate(7));
						cInternet.setInfoExtra(result.getString(8));

						credenciales.add(cInternet);
					}

				}

			}

		} catch (Exception ex) {
			return null;
		}

		return credenciales;
	}

	/**
	 * Obtiene todas las credenciales bancarias de un usuario.
	 *
	 * @param usuario El usuario al cual se le van a buscar las credenciales.
	 * @return Devuelve la lista de credenciales bancarias que tiene el usuario,
	 * devuelve {@code null} si hugo algun error.
	 */
	public static List<CredencialBancaria> getCredencialesBancarias(Usuario usuario) {

		if (usuario == null) {
			return null;
		}

		var credenciales = new ArrayList<CredencialBancaria>();
		SqlConnection sql = new SqlConnection();
		try (var conn = sql.getConnection()) {

			try (var stmt = conn.prepareStatement(
							"SELECT * FROM T_CREDENCIALES_BANCARIAS "
							+ "WHERE FK_Nombre_Usuario = ?")) {

				stmt.setString(1, usuario.getNombre());

				try (var result = stmt.executeQuery()) {

					while (result.next()) {

						CredencialBancaria cBancaria = new CredencialBancaria();
						cBancaria.setNombreUsuario(usuario.getNombre());
						cBancaria.setId(result.getInt(1));
						cBancaria.setNombreBanco(result.getString(2));
						cBancaria.setNumeroTarjeta(result.getString(3));

						var cvv = AESCipher.decrypt(result.getString(4), cBancaria.getNombreUsuario());
						cBancaria.setCVV(cvv);

						cBancaria.setFechaCaducidad(result.getDate(5));
						cBancaria.setFechaAlta(result.getDate(6));
						cBancaria.setFechaUpdate(result.getDate(7));
						cBancaria.setInfoExtra(result.getString(8));

						credenciales.add(cBancaria);
					}

				}

			}

		} catch (Exception ex) {
			return null;
		}

		return credenciales;
	}

	/**
	 * Extrae todas las credenciales que le pertenezcan a un usuario.
	 *
	 * @param usuario El usuario al cual se le va a buscar las credenciales.
	 * @return Devuelve {@code null} si ocurrio un error durante la extracción o
	 * devuelve las credenciales que le pertenezcan al usuario. La lista que
	 * devuelve puede estar vacia.
	 */
	public static List<ICredencial> getCredenciales(Usuario usuario) {

		if (usuario == null) {
			return null;
		}

		var credenciales = new ArrayList<ICredencial>();

		var credencialesInternet = getCredencialesInternet(usuario);

		if (credencialesInternet == null) {
			return null;
		}

		var credencialesBancarias = getCredencialesBancarias(usuario);

		if (credencialesBancarias == null) {
			return null;
		}

		credenciales.addAll(credencialesInternet);
		credenciales.addAll(credencialesBancarias);

		return credenciales;
	}
}
