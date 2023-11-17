package models;

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
	 * Brinda el acceso a la contraseña de la cuenta de usuario del sistema.
	 *
	 * @return Devuelve la contraseña encriptada (AES 256).
	 */
	public String getPassword() {
		return password;
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
