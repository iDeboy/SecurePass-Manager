package models;

import java.util.Date;

/**
 * Representación abstracta de una credencial.
 */
public abstract class AbstractCredencial implements ICredencial {

	protected int id;
	protected Date fechaAlta;
	protected Date fechaUpdate;
	protected String infoExtra;

	/**
	 * Constructor de datos básicos que tiene una credencial.
	 *
	 * @param id Id de la credencial
	 * @param fechaAlta Fecha de alta de la credencial
	 * @param fechaUpdate Fecha en la que se actualizó algo de la credencial.
	 * @param infoExtra Algún dato extra que sea relevante para la credencial.
	 */
	protected AbstractCredencial(int id, Date fechaAlta, Date fechaUpdate, String infoExtra) {
		this.id = id;
		this.fechaAlta = fechaAlta;
		this.fechaUpdate = fechaUpdate;
		this.infoExtra = infoExtra;
	}

	/**
	 * Constructor de datos básicos que tiene una credencial sin su identificador.
	 * <br><br>
	 * Este constructor se utiliza para la operación de agregar credencial,
	 * <br>
	 * ya que la id no es relevante porque se genera por la base de datos.
	 * @param fechaAlta Fecha de alta de la credencial
	 * @param fechaUpdate Fecha en la que se actualizó algo de la credencial.
	 * @param infoExtra Algún dato extra que sea relevante para la credencial.
	 */
	protected AbstractCredencial(Date fechaAlta, Date fechaUpdate, String infoExtra) {
		this(0, fechaAlta, fechaUpdate, infoExtra);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Date getFechaAlta() {
		return fechaAlta;
	}

	@Override
	public Date getFechaUpdate() {
		return fechaUpdate;
	}

	@Override
	public String getInfoExtra() {
		return infoExtra;
	}

}
