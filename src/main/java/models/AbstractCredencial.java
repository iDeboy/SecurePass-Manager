package models;

import java.util.Date;

/**
 * Representación abstracta de una credencial.
 */
public abstract class AbstractCredencial implements ICredencial {

	protected String nombreUsuario;

	protected int id;
	protected Date fechaAlta;
	protected Date fechaUpdate;
	protected String infoExtra;

	@Override
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	@Override
	public void setNombreUsuario(String nombreUsuario) throws Exception {
		if (nombreUsuario.length() > 15) {
			throw new Exception("La logitud del nombre de usuario no debe ser mayor que 15.");
		}
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public void setFechaUpdate(Date fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}

	@Override
	public void setInfoExtra(String infoExtra) {
		this.infoExtra = infoExtra;
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
