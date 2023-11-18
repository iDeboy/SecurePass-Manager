package models;

import java.util.Date;

/**
 * Interfaz que representa los métodos y propiedades básicas que debe tener una
 * credencial.
 */
public interface ICredencial {

	/**
	 * Obtiene el nombre de usuario al cual le pertenece la credencial.
	 *
	 * @return Nombre de usuario
	 */
	public String getNombreUsuario();

	/**
	 * Asigna el nombre de usuario al cual le pertenece la credencial.
	 * <br>
	 * Nota: el nombre de usuario solo puede medir 15 caracteres alfanumericos.
	 *
	 * @throws Exception Si la longitud es mayor que 15.
	 * @param nombreUsuario Nombre de usuario
	 */
	public void setNombreUsuario(String nombreUsuario) throws Exception;

	/**
	 * Asigna el valor de la id de la credecial
	 *
	 * @param id Id de la credencial.
	 */
	public void setId(int id);

	/**
	 * Asigna el valor de la fecha de alta de la credecial.
	 * <br>
	 * Nota: Tiene el siguiente formato "dd/MM/aaaa hh:mm:ss"
	 *
	 * @param fechaAlta Fecha de alta.
	 */
	public void setFechaAlta(Date fechaAlta);

	/**
	 * Asigna el valor de la fecha del utimo cambio en la credecial.
	 * <br>
	 * Nota: Tiene el siguiente formato "dd/MM/aaaa hh:mm:ss"
	 *
	 * @param fechaUpdate Fecha de ultimo cambio
	 */
	public void setFechaUpdate(Date fechaUpdate);

	/**
	 * Asigna el valor de cualquier dato extra para la credencial.
	 * <br>
	 * Nota: La longitud maxima que puede tener es de 120 caracteres.
	 *
	 * @throws Exception Si la longitud es mayor que 120.
	 * @param infoExtra Información extra de la credencial.
	 */
	public void setInfoExtra(String infoExtra) throws Exception;

	/**
	 * @return Devuelve la Id de la credencial.
	 */
	int getId();

	/**
	 * @return Devuelve la fecha en la que se dio de alta la credencial.
	 */
	Date getFechaAlta();

	/**
	 * @return Devuelve la ultima fecha en la que se actualizó la credencial.
	 */
	Date getFechaUpdate();

	/**
	 * @return Devuelve algun dato extra que sea relevante para la credencial.
	 */
	String getInfoExtra();

	/**
	 * Método para que la credencial muestre los datos que sean relevantes.
	 */
	void show();

}
