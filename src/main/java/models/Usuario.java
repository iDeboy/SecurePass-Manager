package models;

import repositories.AESCipher;

/**
 * Modelo que representa al usuario del sistema.
 */
public final class Usuario {

	private String nombre;
	private String nombrePersona;
	private String apellidoPaternoPersona;
	private String apellidoMeternoPersona;
	private String password;

	/**
	 * Asigna un nombre de cuenta de usuario.
	 * <br>
	 * Nota: el nombre de usuario solo puede medir 15 caracteres alfanumericos.
	 *
	 * @param nombre Nombre de la cuenta de usuario
	 */
	public void setNombre(String nombre) throws Exception {
		if (nombre.length() > 15) {
			throw new Exception("La logitud del nombre de usuario no debe ser mayor que 15.");
		}
		this.nombre = nombre;
	}

	/**
	 * Asigna el nombre de la persona a la cual pertenece la cuenta de usuario
	 *
	 * @param nombrePersona Nombre de la persona
	 */
	public void setNombrePersona(String nombrePersona) throws Exception {
		if (nombrePersona.length() > 15) {
			throw new Exception("La logitud del nombre de la persona debe ser menor que 15.");
		}
		this.nombrePersona = nombrePersona;
	}

	/**
	 * Asigna el apellido paterno de la persona a la cual pertenece la cuenta de
	 * usuario
	 *
	 * @param apellidoPaternoPersona Apellido paterno de la persona
	 */
	public void setApellidoPaternoPersona(String apellidoPaternoPersona) throws Exception {

		if (apellidoPaternoPersona.length() > 15) {
			throw new Exception("La logitud del apellido paterno de la persona debe ser menor que 15.");
		}

		this.apellidoPaternoPersona = apellidoPaternoPersona;
	}

	/**
	 * Asigna el apellido materno de la persona a la cual pertenece la cuenta de
	 * usuario
	 *
	 * @param apellidoMeternoPersona Apellido materno de la persona
	 */
	public void setApellidoMeternoPersona(String apellidoMeternoPersona) throws Exception {

		if (apellidoMeternoPersona.length() > 15) {
			throw new Exception("La logitud del apellido materno de la persona debe ser menor que 15.");
		}

		this.apellidoMeternoPersona = apellidoMeternoPersona;
	}

	/**
	 * Asigna la contraseña de la cuenta de usuario.
	 * <br>
	 * Nota: la contraseña que se pase como parametro se va a encriptar usando AES
	 * 256.
	 *
	 * @throws Exception Si la contraseña no se pudo encriptar.
	 * @param password Contraseña de la cuenta de usuario.
	 */
	public void setPassword(String password) throws Exception {
		this.password = AESCipher.encrypt(password, nombre);
	}

	/**
	 * Brinda el acceso al nombre del usuario del sistema.
	 *
	 * @return Delvuelve el nombre de usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Brinda el acceso al nombre del dueño de la cuenta de usuario del sistema.
	 *
	 * @return Devuelve el nombre de la persona dueña de la cuenta del sistema.
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}

	/**
	 * Brinda el acceso al apellido paterno del dueño de la cuenta de usuario del
	 * sistema.
	 *
	 * @return Devuelve el apellido paterno de la persona dueña de la cuenta del
	 * sistema.
	 */
	public String getApellidoPaternoPersona() {
		return apellidoPaternoPersona;
	}

	/**
	 * Brinda el acceso al apellido materno del dueño de la cuenta de usuario del
	 * sistema.
	 *
	 * @return Devuelve el apellido materno de la persona dueña de la cuenta del
	 * sistema.
	 */
	public String getApellidoMeternoPersona() {
		return apellidoMeternoPersona;
	}

	/**
	 * Brinda el acceso a la contraseña encriptada de la cuenta de usuario del
	 * sistema.
	 *
	 * @return Devuelve la contraseña encriptada (AES 256).
	 */
	public String getEncryptedPassword() {
		return password;
	}

	/**
	 * Brinda el acceso a la contraseña encriptada de la cuenta de usuario del
	 * sistema.
	 *
	 * @throws Exception Si la contraseña no se pudo desencriptar.
	 * @return Devuelve la contraseña encriptada (AES 256).
	 */
	public String getDecryptedPassword() throws Exception {
		return AESCipher.decrypt(password, nombre);
	}

	/**
	 * Método para que el usuario inicie sesión.
	 */
	public void login() {

	}

	/**
	 * Método para registrar el usuario con los datos que contenga
	 * <br>
	 * la instancia que llamo este método.
	 */
	public void register() {

	}

	/**
	 * Añade una credencial.
	 *
	 * @param credential Credencial a agregar
	 */
	public void addCredencial(ICredencial credential) {

	}

	/**
	 * Quita una credencial.
	 *
	 * @param credential Credencial a quitar
	 */
	public void removeCredencial(ICredencial credential) {

	}

	/**
	 * Obtiene todas las credenciales del usuario especificado
	 * <br>
	 * en esta instancia.
	 *
	 * @return Devuelve todas las credenciales que le pertenecen al usuario.
	 */
	public ICredencial[] getCredencials() {
		return null;
	}

	/**
	 * Edita una credencial.
	 *
	 * @param credential Credencial a editar
	 */
	public void editCredencial(ICredencial credential) {

	}
}
