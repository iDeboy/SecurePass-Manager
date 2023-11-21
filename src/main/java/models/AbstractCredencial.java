package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Representación abstracta de una credencial.
 */
public abstract class AbstractCredencial implements ICredencial {

	protected String nombreUsuario;

	protected int id;
	protected Timestamp fechaAlta;
	protected Timestamp fechaUpdate;
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
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = Timestamp.valueOf(fechaAlta);
	}

	@Override
	public void setFechaUpdate(LocalDateTime fechaUpdate) {
		this.fechaUpdate = Timestamp.valueOf(fechaUpdate);
	}
	
	@Override
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public void setFechaUpdate(Timestamp fechaUpdate) {
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
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}

	@Override
	public Timestamp getFechaUpdate() {
		return fechaUpdate;
	}

	@Override
	public String getInfoExtra() {
		return infoExtra;
	}

}
