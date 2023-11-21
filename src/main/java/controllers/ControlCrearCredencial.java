package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import models.CredencialBancaria;
import models.CredencialInternet;
import models.CredencialTableModel;
import models.Usuario;
import repositories.RepositorioCredencial;
import views.ViewCrearCredencialB;
import views.ViewCrearCredencialP;

public class ControlCrearCredencial implements ActionListener {

	private ViewCrearCredencialP viewCrearCredencialP;
	private ViewCrearCredencialB viewCrearCredencialB;

	private final CredencialTableModel credenciales;
	private final Usuario usuario;

	public ControlCrearCredencial(ViewCrearCredencialP viewCrearCredencialP, Usuario usuario, CredencialTableModel credenciales) {
		this.usuario = usuario;
		this.viewCrearCredencialP = viewCrearCredencialP;
		this.credenciales = credenciales;

		this.viewCrearCredencialP.bRegresar.addActionListener(this);
		this.viewCrearCredencialP.bGuardar.addActionListener(this);
	}

	public ControlCrearCredencial(ViewCrearCredencialB viewCrearCredencialB, Usuario usuario, CredencialTableModel credenciales) {
		this.usuario = usuario;
		this.viewCrearCredencialB = viewCrearCredencialB;
		this.credenciales = credenciales;

		this.viewCrearCredencialB.bRegresar.addActionListener(this);
		this.viewCrearCredencialB.bGuardar.addActionListener(this);
	}

	public void iniciarVistaCrear() {

		if (viewCrearCredencialP != null) {
			viewCrearCredencialP.setVisible(true);
			return;
		}

		if (viewCrearCredencialB != null) {
			viewCrearCredencialB.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/**
		 * Componentes de la clase ViewCrearCredencialP
		 *
		 * ViewCrearCredencialP es la vista para crear nuevas credenciales por
		 * plataforma.
		 */
		if (viewCrearCredencialP != null) {

			if (e.getSource() == viewCrearCredencialP.bRegresar) {
				viewCrearCredencialP.dispose();
			}

			if (e.getSource() == viewCrearCredencialP.bGuardar) {

				viewCrearCredencialP.bGuardar.setEnabled(false);

				try {
					CredencialInternet credencial = new CredencialInternet();
					credencial.setNombreUsuario(usuario.getNombre());
					credencial.setUsuarioWeb(viewCrearCredencialP.txtUsuario.getText());
					credencial.setNombrePlataforma(viewCrearCredencialP.txtPlataforma.getText());
					credencial.setPassword(viewCrearCredencialP.txtPassword.getText());
					credencial.setUrl(viewCrearCredencialP.txtURL.getText());
					credencial.setInfoExtra(viewCrearCredencialP.txtDatos.getText());

					var ahora = LocalDateTime.now();

					credencial.setFechaAlta(ahora);
					credencial.setFechaUpdate(ahora);

					if (RepositorioCredencial.addCredencial(credencial)) {

						credenciales.getOriginal().add(credencial);

					} else {
						JOptionPane.showMessageDialog(
										viewCrearCredencialP,
										"La credencial no se pudo agregar.",
										"Error al agregar credencial",
										JOptionPane.ERROR_MESSAGE);

						viewCrearCredencialP.limpiar();
						return;
					}
				} catch (Exception ex) {

					JOptionPane.showMessageDialog(
									viewCrearCredencialP,
									"La credencial no se pudo agregar.",
									"Error al agregar credencial",
									JOptionPane.ERROR_MESSAGE);

					viewCrearCredencialP.limpiar();
					return;

				}

				JOptionPane.showMessageDialog(
								viewCrearCredencialP,
								"La credencial se ha guardado con exito.",
								"Agregar credencial",
								JOptionPane.INFORMATION_MESSAGE);

				credenciales.fireTableDataChanged();
				viewCrearCredencialP.dispose();
			}

		}

		if (viewCrearCredencialB != null) {

			if (e.getSource() == viewCrearCredencialB.bRegresar) {
				viewCrearCredencialB.dispose();
			}

			if (e.getSource() == viewCrearCredencialB.bGuardar) {

				viewCrearCredencialB.bGuardar.setEnabled(false);

				try {
					CredencialBancaria credencial = new CredencialBancaria();
					credencial.setNombreUsuario(usuario.getNombre());
					credencial.setNombreBanco(viewCrearCredencialB.txtBanco.getText());
					credencial.setNumeroTarjeta(viewCrearCredencialB.txtNomTarjeta.getText());
					credencial.setCVV(viewCrearCredencialB.txtCVV.getText());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
					var date = LocalDate.parse(viewCrearCredencialB.txtCaducidad.getText(), formatter);

					credencial.setFechaCaducidad(date);
					credencial.setInfoExtra(viewCrearCredencialB.txtDatos.getText());

					var ahora = LocalDateTime.now();

					credencial.setFechaAlta(ahora);
					credencial.setFechaUpdate(ahora);

					if (RepositorioCredencial.addCredencial(credencial)) {

						credenciales.getOriginal().add(credencial);

					} else {
						JOptionPane.showMessageDialog(
										viewCrearCredencialB,
										"La credencial no se pudo agregar.",
										"Error al agregar credencial",
										JOptionPane.ERROR_MESSAGE);

						viewCrearCredencialB.limpiar();
						return;
					}
				} catch (Exception ex) {

					JOptionPane.showMessageDialog(
									viewCrearCredencialB,
									"La credencial no se pudo agregar.",
									"Error al agregar credencial",
									JOptionPane.ERROR_MESSAGE);

					viewCrearCredencialB.limpiar();
					return;

				}

				JOptionPane.showMessageDialog(
								viewCrearCredencialB,
								"La credencial se ha guardado con exito.",
								"Agregar credencial",
								JOptionPane.INFORMATION_MESSAGE);

				credenciales.fireTableDataChanged();
				viewCrearCredencialB.dispose();
			}

		}

//		if (viewCrearCredencialP.bGuardar == e.getSource()) {
//			controlLogin.limpiarTextFields(viewCrearCredencialP); //Consulta para guardar credenciales por plataforma, luego se limpian los TextField si sale todo bien.
//		}
		/**
		 * Componentes de la clase ViewCrearCredencialB
		 *
		 * ViewCrearCredencialB es la vista para crear nuevas credenciales por
		 * banco.
		 */
//		if (viewCrearCredencialB.bCredencial == e.getSource()) {
//			try {
//				controlPrincipal.iniciarVistaSelección();
//			} catch (UnsupportedLookAndFeelException ex) {
//			}
//		}
//		if (viewCrearCredencialB.bCerrar == e.getSource()) {
//			try {
//				controlLogin.iniciarVistaLogin();
//			} catch (UnsupportedLookAndFeelException ex) {
//			}
//			controlLogin.limpiarTextFields(viewCrearCredencialB);
//			viewCrearCredencialB.dispose();
//			viewTipoCrede.dispose();
//		}
//		if (viewCrearCredencialB.bRegresar == e.getSource()) {
//			try {
//				controlPrincipal.iniciarVistaPrincipal();
//			} catch (UnsupportedLookAndFeelException ex) {
//			}
//			controlLogin.limpiarTextFields(viewCrearCredencialB);
//			viewCrearCredencialB.dispose();
//			viewTipoCrede.dispose();
//		}
//		if (viewCrearCredencialB.bGuardar == e.getSource()) {
//			controlLogin.limpiarTextFields(viewCrearCredencialB); //Consulta para guardar credenciales por banco, luego se limpian los TextField si sale todo bien.
//		}
	}

}
