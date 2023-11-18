package models;

import repositories.AESCipher;

/**
 * Representa una credencial de internet, es decir, de alguna plataforma
 * <br>
 * web o alguna aplicación.
 */
public final class CredencialInternet extends AbstractCredencial {

	private String nombrePlataforma;
	private String usuarioWeb;
	private String url;
	private String password;

	/**
	 * Asigna el nombre de la plataforma a la cual pertenece la credencial.
	 * <br>
	 * Nota: Solo puede tener una longitud maxima de 30 caracteres.
	 *
	 * @throws Exception Si la longitud es mayor que 30.
	 * @param nombrePlataforma Nombre de la plataforma.
	 */
	public void setNombrePlataforma(String nombrePlataforma) throws Exception {

		if (nombrePlataforma.length() > 30) {
			throw new Exception("La longitud de el nombre de la plataforma no puede ser mayor que 30.");
		}
		this.nombrePlataforma = nombrePlataforma;
	}

	/**
	 * Asigna el nombre de usuario, correo o identidad utilizada en la credencial.
	 * <br>
	 * Nota: La longitud tiene que ser como maxima de 30 caracteres.
	 *
	 * @throws Exception Si la longitud es mayor que 30
	 * @param usuarioWeb
	 */
	public void setUsuarioWeb(String usuarioWeb) throws Exception {
		if (usuarioWeb.length() > 30) {
			throw new Exception("La longitud de la identidad de la credencial no puede ser mayor que 30.");
		}
		this.usuarioWeb = usuarioWeb;
	}

	/**
	 * Asigna la URL de la plataforma en que se que registró la credencial.
	 * <br>
	 * Nota: La longitud maxima es de 100 caracteres.
	 *
	 * @throws Exception Si la longitud es mayor que 100.
	 * @param url
	 */
	public void setUrl(String url) throws Exception {
		if (url.length() > 100) {
			throw new Exception("La longitud de la URL no puede ser mayor que 100.");
		}

		this.url = url;
	}

	/**
	 * Asigna la contraseña de la cuenta de usuario.
	 * <br>
	 * Nota: La contraseña que se pase como parametro se va a encriptar usando AES
	 * 256.
	 *
	 * @throws Exception Si la contraseña no se pudo encriptar.
	 * @param password Contraseña de la cuenta de usuario.
	 */
	public void setPassword(String password) throws Exception {
		this.password = AESCipher.encrypt(password, getNombreUsuario());
	}

	/**
	 *
	 * @return Devuelve el nombre de la plataforma en el cual se registró
	 * <br>
	 * la credencial.
	 */
	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	/**
	 *
	 * @return Devuelve el correo o nombre de usuario que se utilizó en la
	 * <br>
	 * credencial.
	 */
	public String getUsuarioWeb() {
		return usuarioWeb;
	}

	/**
	 *
	 * @return Devuelve la url de la plataforma.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 *
	 * @return Devuelve la contraseña encriptada de la credencial,
	 * <br>
	 * esta contraseña está encriptada con AES 256.
	 *
	 */
	public String getEncryptedPassword() {
		return password;
	}

	/**
	 *
	 * @return Devuelve la contraseña desenciptada de la credencial.
	 *
	 * @throws Exception Si la contraseña no se pudo desencriptar.
	 */
	public String getDecryptedPassword() throws Exception {
		return AESCipher.decrypt(password, getNombreUsuario());
	}

	@Override
	public void show() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
