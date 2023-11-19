package models;

import java.util.regex.Pattern;
import repositories.AESCipher;

public final class CredencialBancaria extends AbstractCredencial {

	private String nombreBanco;
	private String numeroTarjeta;
	private String cvv;
	private java.sql.Date fechaCaducidad;

	/**
	 * Asigna el nombre del banco a la credencial bancaria.
	 * <br>
	 * Nota: La longitud del nombre solo puede ser maximo 30 caracteres.
	 *
	 * @throws Exception Si la longitud es mayor que 30.
	 * @param nombreBanco Nombre del banco
	 */
	public void setNombreBanco(String nombreBanco) throws Exception {
		if (nombreBanco.length() > 30) {
			throw new Exception("La longitud del nombre del banco no puede ser mayor que 30");
		}
		this.nombreBanco = nombreBanco;
	}

	/**
	 * Asigna el numero de tarjeta de la credencial bancaria.
	 * <br>
	 * Nota: El numero de tarjeta debe tener 16 digitos.
	 *
	 * @param numeroTarjeta Número de tarjeta
	 */
	public void setNumeroTarjeta(String numeroTarjeta) throws Exception {

		if (numeroTarjeta.length() != 16) {
			throw new Exception("El numero de tarjeta debe de tener 16 digitos");
		}

		Pattern pattern = Pattern.compile("^\\d{16}$");
		if (!pattern.matcher(numeroTarjeta).matches()) {
			throw new Exception("El numero de tarjeta no tiene un formati valudo.");
		}

		this.numeroTarjeta = numeroTarjeta;
	}

	/**
	 * Asigna e CVV de la tarjeta.
	 * <br>
	 * Nota: El CVV se va a encriptar usando AES 256.
	 *
	 * @throws Exception Si el CVV no se pudo encriptar.
	 * @param cvv CVV de la tarjeta.
	 */
	public void setCVV(String cvv) throws Exception {
		this.cvv = AESCipher.encrypt(cvv, getNombreUsuario());
	}

	/**
	 * Asigna la fecha de caducidad de la tarjeta.
	 * <br>
	 * Nota: Unicamente se guardara el mes y el año.
	 *
	 * @param fechaCaducidad Fecha de caducidad de la tarjeta.
	 */
	public void setFechaCaducidad(java.util.Date fechaCaducidad) {

		this.fechaCaducidad = new java.sql.Date(
						fechaCaducidad.getYear(),
						fechaCaducidad.getMonth(), 1);
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
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 *
	 * @return Devuelve el CVV de la tarjeta y está encriptada con AES 256.
	 */
	public String getEncryptedCVV() {
		return cvv;
	}

	/**
	 *
	 * @return Devuelve el CVV de la tarjeta desencriptada.
	 * @throws Exception Si el CVV no se pudo desencriptar.
	 */
	public String getDecryptedCVV() throws Exception {
		return AESCipher.decrypt(cvv, getNombreUsuario());
	}

	/**
	 *
	 * @return Devuelve la fecha de caducidad de la credencial.
	 */
	public java.sql.Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	@Override
	public void show() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
