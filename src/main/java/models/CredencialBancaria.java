package models;

import java.util.Date;

public final class CredencialBancaria extends AbstractCredencial {

	private	String nombreBanco;
	private int numeroTarjeta;
	private String cvv;
	private Date fechaCaducidad;

	public CredencialBancaria(int id, String nombreBanco, int numeroTarjeta, String cvv, Date fechaCaducidad, Date fechaAlta, Date fechaUpdate, String infoExtra) {
		super(id, fechaAlta, fechaUpdate, infoExtra);
		this.nombreBanco = nombreBanco;
		this.numeroTarjeta = numeroTarjeta;
		this.cvv = cvv;
		this.fechaCaducidad = fechaCaducidad;
	}

	public CredencialBancaria(String nombreBanco, int numeroTarjeta, String cvv, Date fechaCaducidad, Date fechaAlta, Date fechaUpdate, String infoExtra) {
		this(0, nombreBanco, numeroTarjeta, cvv, fechaCaducidad, fechaAlta, fechaUpdate, infoExtra);
	}

	/**
	 * 
	 * @return Devuelve el nombre del banco de la credencial.
	 */
	public String getNombreBanco() {
		return nombreBanco;
	}

	/**
	 * 
	 * @return Devuelve el numero de tarjeta, este numero consta de 16 digitos.
	 */
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * 
	 * @return Devuelve el CVV de la tarjeta y está encriptada con AES 256.
	 */
	public String getCVV() {
		return cvv;
	}

	/**
	 * 
	 * @return Devuelve la fecha de caducidad de la credencial.
	 */
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	
	
	@Override
	public void show() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
