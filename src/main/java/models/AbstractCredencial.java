package models;

/**
 * Representación abstracta de una credencial.
 */
public abstract class AbstractCredencial implements ICredencial {

	protected String nombreUsuario;

	protected int id;
	protected java.sql.Date fechaAlta;
	protected java.sql.Date fechaUpdate;
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
	public void setFechaAlta(java.util.Date fechaAlta) {
		this.fechaAlta = new java.sql.Date(fechaAlta.getTime());
	}

	@Override
	public void setFechaUpdate(java.util.Date fechaUpdate) {
		this.fechaUpdate = new java.sql.Date(fechaUpdate.getTime());
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
	public java.sql.Date getFechaAlta() {
		return fechaAlta;
	}

	@Override
	public java.sql.Date getFechaUpdate() {
		return fechaUpdate;
	}

	@Override
	public String getInfoExtra() {
		return infoExtra;
	}

}
