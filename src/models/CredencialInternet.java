package models;

import java.util.Date;

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

	public CredencialInternet(int id, String nombrePlataforma, String usuarioWeb, String url, String password, Date fechaAlta, Date fechaUpdate, String infoExtra) {
		super(id, fechaAlta, fechaUpdate, infoExtra);
		this.nombrePlataforma = nombrePlataforma;
		this.usuarioWeb = usuarioWeb;
		this.url = url;
		this.password = password;
	}

	public CredencialInternet(String nombrePlataforma, String usuarioWeb, String url, String password, Date fechaAlta, Date fechaUpdate, String infoExtra) {
		this(0, nombrePlataforma, usuarioWeb, url, password, fechaAlta, fechaUpdate, infoExtra);
						
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
	 * @return Devuelve la contraseña de la credencial
	 * <br>
	 * esta contraseña está encriptada con AES 256.
	 */
	public String getPassword() {
		return password;
	}
	
	
	
	@Override
	public void show() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
