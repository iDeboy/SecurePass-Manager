
package models;

import java.util.Date;

/**
 * Interfaz que representa los métodos y propiedades básicas
 * que debe tener una credencial.
 */
public interface ICredencial {
	
	/**
	 * @return Devuelve la Id de la credencial.
	 */
	int getId();
	
	/**
	 * @return Devuelve la fecha en la que se dio de alta
	 * la credencial.
	 */
	Date getFechaAlta();
	
	/**
	 * @return Devuelve la ultima fecha en la que se actualizó
	 * la credencial.
	 */
	Date getFechaUpdate();
	
	/**
	 * @return Devuelve algun dato extra que sea relevante para 
	 * la credencial.
	 */
	String getInfoExtra();
	
	/**
	 * Método para que la credencial muestre los datos que sean relevantes.
	 */
	void show();
	
}
