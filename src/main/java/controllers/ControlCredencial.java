package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.*;
import repositories.RepositorioCredencial;
import views.ViewCredencialB;
import views.ViewCredencialP;

public class ControlCredencial implements ActionListener, MouseListener {

	private ViewCredencialP viewCredencialP;
	private ViewCredencialB viewCredencialB;

	private final ICredencial credencial;
	private final CredencialTableModel tableModel;

	public ControlCredencial(ViewCredencialP viewCredencialP, CredencialInternet credencial, CredencialTableModel tableModel) {
		this.viewCredencialP = viewCredencialP;
		this.credencial = credencial;
		this.tableModel = tableModel;

		// addListener de editar y eliminar
		this.viewCredencialP.bEliminar.addActionListener(this);
		this.viewCredencialP.bGuardar.addActionListener(this);
		this.viewCredencialP.bPrincipal.addActionListener(this);

		this.viewCredencialP.jlbEditarUsuario.addMouseListener(this);
		this.viewCredencialP.jlbEditarPass.addMouseListener(this);
		this.viewCredencialP.jlbOcultarPass.addMouseListener(this);
		this.viewCredencialP.jlbEditarInfo.addMouseListener(this);
	}

	public ControlCredencial(ViewCredencialB viewCredencialB, CredencialBancaria credencial, CredencialTableModel tableModel) {
		this.viewCredencialB = viewCredencialB;
		this.credencial = credencial;
		this.tableModel = tableModel;

		// addListener de editar y eliminar
		this.viewCredencialB.bEliminar.addActionListener(this);
		this.viewCredencialB.bGuardar.addActionListener(this);
		this.viewCredencialB.bPrincipal.addActionListener(this);

		this.viewCredencialB.jlbOcultarNumTarj.addMouseListener(this);
		this.viewCredencialB.jlbOcultarCVV.addMouseListener(this);
		this.viewCredencialB.jlbEditarInfo.addMouseListener(this);
	}

	public void iniciarVista(Component parent) throws Exception {

		if (viewCredencialP != null) {
			viewCredencialP.setLocationRelativeTo(parent);

			var cInternet = (CredencialInternet) credencial;

			viewCredencialP.txtUsuario.setText(cInternet.getUsuarioWeb());
			viewCredencialP.txtPassword.setText(cInternet.getDecryptedPassword());
			viewCredencialP.txtPlataforma.setText(cInternet.getNombrePlataforma());
			viewCredencialP.txtURL.setText(cInternet.getUrl());
			viewCredencialP.txtDatos.setText(cInternet.getInfoExtra());

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			viewCredencialP.jlbFecha.setText(dateFormat.format(cInternet.getFechaUpdate()));

			viewCredencialP.setVisible(true);
		}

		if (viewCredencialB != null) {
			viewCredencialB.setLocationRelativeTo(parent);

			var cBancaria = (CredencialBancaria) credencial;
			viewCredencialB.txtBanco.setText(cBancaria.getNombreBanco());
			viewCredencialB.txtNoTarjeta.setText(cBancaria.getNumeroTarjeta());
			viewCredencialB.txtCVV.setText(cBancaria.getDecryptedCVV());
			viewCredencialB.txtDatos.setText(cBancaria.getInfoExtra());

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
			viewCredencialB.txtCaducidad.setText(dateFormat.format(cBancaria.getFechaCaducidad()));

			dateFormat.applyPattern("dd/MM/yyyy HH:mm:ss");
			viewCredencialB.jlbFecha.setText(dateFormat.format(cBancaria.getFechaUpdate()));

			viewCredencialB.setVisible(true);
		}
	}

	private void fillFields(ICredencial credencial) {

		if (credencial instanceof CredencialInternet cInternet) {

			viewCredencialP.txtUsuario.setText(cInternet.getUsuarioWeb());
			viewCredencialP.txtPlataforma.setText(cInternet.getNombrePlataforma());
			try {
				viewCredencialP.txtPassword.setText(cInternet.getDecryptedPassword());
			} catch (Exception ex) {
				viewCredencialP.dispose();
			}
			viewCredencialP.txtURL.setText(cInternet.getUrl());
			viewCredencialP.txtDatos.setText(cInternet.getInfoExtra());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			viewCredencialP.jlbFecha.setText(dateFormat.format(cInternet.getFechaUpdate()));

			viewCredencialP.repaint();
			
		} else if (credencial instanceof CredencialBancaria cBancaria) {

			viewCredencialB.txtBanco.setText(cBancaria.getNombreBanco());
			try {
				viewCredencialB.txtCVV.setText(cBancaria.getDecryptedCVV());
			} catch (Exception ex) {
				viewCredencialB.dispose();
			}
			viewCredencialB.txtNoTarjeta.setText(cBancaria.getNumeroTarjeta());

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
			viewCredencialB.txtCaducidad.setText(dateFormat.format(cBancaria.getFechaCaducidad()));

			dateFormat.applyPattern("dd/MM/yyyy HH:mm:ss");
			viewCredencialB.jlbFecha.setText(dateFormat.format(cBancaria.getFechaUpdate()));
			
			viewCredencialB.txtDatos.getText();
			
			viewCredencialB.repaint();

		}
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (viewCredencialP != null) {

			var cInternet = (CredencialInternet) credencial;

			if (e.getSource() == viewCredencialP.bPrincipal) {
				viewCredencialP.dispose();
			}

			if (e.getSource() == viewCredencialP.bEliminar) {

				var r = JOptionPane.showConfirmDialog(viewCredencialP,
								"¿Está seguro que desea eliminar la credencial?\n Una vez eliminada no se puede recuperar.",
								"Eliminar credencial",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE);

				if (r == JOptionPane.YES_OPTION) {
					if (RepositorioCredencial.removeCredencial(cInternet)) {

						tableModel.getOriginal().remove(cInternet);

						JOptionPane.showMessageDialog(viewCredencialP,
										"Se ha eliminado correctamente.",
										"Eliminar credencial",
										JOptionPane.INFORMATION_MESSAGE);

					} else {

						JOptionPane.showMessageDialog(viewCredencialP,
										"No se pudo eliminar la credencial.",
										"Eliminar credencial",
										JOptionPane.ERROR_MESSAGE);

					}

					tableModel.fireTableDataChanged();
					viewCredencialP.dispose();
				}

			}

			if (e.getSource() == viewCredencialP.bGuardar) {

				var r = JOptionPane.showConfirmDialog(viewCredencialP,
								"¿Está seguro que desea guardar cambios?\n Los datos sobreescritos ya no se pueden recuperar.",
								"Editar credencial",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE);

				if (r == JOptionPane.YES_OPTION) {

					var usuarioWeb = viewCredencialP.txtUsuario.getText();
					var plataforma = viewCredencialP.txtPlataforma.getText();
					var pass = new String(viewCredencialP.txtPassword.getPassword());
					var url = viewCredencialP.txtURL.getText();
					var info = viewCredencialP.txtDatos.getText();

					try {

						var cTemp = new CredencialInternet();
						cTemp.setNombreUsuario(cInternet.getNombreUsuario());
						cTemp.setFechaAlta(cInternet.getFechaAlta());
						cTemp.setFechaUpdate(cInternet.getFechaAlta());
						cTemp.setId(cInternet.getId());

						cTemp.setUsuarioWeb(usuarioWeb);
						cTemp.setNombrePlataforma(plataforma);
						cTemp.setPassword(pass);
						cTemp.setUrl(url);
						cTemp.setInfoExtra(info);

						if (RepositorioCredencial.editCredencial(cTemp)) {

							cInternet.setNombrePlataforma(cTemp.getNombrePlataforma());
							cInternet.setUsuarioWeb(cTemp.getUsuarioWeb());
							cInternet.setUrl(cTemp.getUrl());
							cInternet.setEncryptedPassword(cTemp.getEncryptedPassword());
							cInternet.setFechaUpdate(cTemp.getFechaUpdate());
							cInternet.setInfoExtra(cTemp.getInfoExtra());

							JOptionPane.showMessageDialog(viewCredencialP,
											"Se han editado los cambios correctamente.",
											"Editar credencial",
											JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(viewCredencialP,
											"No se pudo editar la credencial.",
											"Editar credencial",
											JOptionPane.ERROR_MESSAGE);
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(viewCredencialP,
										"No se pudo editar la credencial.",
										"Editar credencial",
										JOptionPane.ERROR_MESSAGE);

						fillFields(cInternet);
					}

				} else {

					fillFields(cInternet);

				}

				viewCredencialP.bloquearCampos();
			}

		}

		if (viewCredencialB != null) {

			var cBancaria = (CredencialBancaria) credencial;

			if (e.getSource() == viewCredencialB.bPrincipal) {
				viewCredencialB.dispose();
			}

			if (e.getSource() == viewCredencialB.bEliminar) {

				var r = JOptionPane.showConfirmDialog(viewCredencialB,
								"¿Está seguro que desea eliminar la credencial?\n Una vez eliminada no se puede recuperar.",
								"Eliminar credencial",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE);

				if (r == JOptionPane.YES_OPTION) {
					if (RepositorioCredencial.removeCredencial(cBancaria)) {

						tableModel.getOriginal().remove(cBancaria);

						JOptionPane.showMessageDialog(viewCredencialB,
										"Se ha eliminado correctamente.",
										"Eliminar credencial",
										JOptionPane.INFORMATION_MESSAGE);

					} else {

						JOptionPane.showMessageDialog(viewCredencialB,
										"No se pudo eliminar la credencial.",
										"Eliminar credencial",
										JOptionPane.ERROR_MESSAGE);

					}

					tableModel.fireTableDataChanged();
					viewCredencialB.dispose();
				}

			}

			if (e.getSource() == viewCredencialB.bGuardar) {

				var r = JOptionPane.showConfirmDialog(viewCredencialB,
								"¿Está seguro que desea guardar cambios?\n Los datos sobreescritos ya no se pueden recuperar.",
								"Editar credencial",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE);

				if (r == JOptionPane.YES_OPTION) {

					var banco = viewCredencialB.txtBanco.getText();
					var cvv = new String(viewCredencialB.txtCVV.getPassword());
					var tarj = new String(viewCredencialB.txtNoTarjeta.getPassword());

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
					var cadu = LocalDate.parse(viewCredencialB.txtCaducidad.getText(), formatter);

					var info = viewCredencialB.txtDatos.getText();

					try {

						var cTemp = new CredencialBancaria();
						cTemp.setNombreUsuario(cBancaria.getNombreUsuario());
						cTemp.setFechaAlta(cBancaria.getFechaAlta());
						cTemp.setFechaUpdate(cBancaria.getFechaAlta());
						cTemp.setId(cBancaria.getId());

						cTemp.setNombreBanco(banco);
						cTemp.setCVV(cvv);
						cTemp.setNumeroTarjeta(tarj);
						cTemp.setFechaCaducidad(cadu);
						cTemp.setInfoExtra(info);

						if (RepositorioCredencial.editCredencial(cTemp)) {

							cBancaria.setNombreBanco(cTemp.getNombreBanco());
							cBancaria.setEncryptedCVV(cTemp.getEncryptedCVV());
							cBancaria.setNumeroTarjeta(cTemp.getNumeroTarjeta());
							cBancaria.setFechaCaducidad(cTemp.getFechaCaducidad());
							cBancaria.setFechaUpdate(cTemp.getFechaUpdate());
							cBancaria.setInfoExtra(cTemp.getInfoExtra());

							JOptionPane.showMessageDialog(viewCredencialB,
											"Se han editado los cambios correctamente.",
											"Editar credencial",
											JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(viewCredencialB,
											"No se pudo editar la credencial.",
											"Editar credencial",
											JOptionPane.ERROR_MESSAGE);
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(viewCredencialB,
										"No se pudo editar la credencial.",
										"Editar credencial",
										JOptionPane.ERROR_MESSAGE);

						fillFields(cBancaria);

					}

				} else {

					fillFields(cBancaria);

				}

				viewCredencialP.bloquearCampos();
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (viewCredencialP != null) {

			if (e.getSource() == viewCredencialP.jlbEditarUsuario) {

				viewCredencialP.txtUsuario.setEditable(true);

			}

			if (e.getSource() == viewCredencialP.jlbEditarPass) {

				viewCredencialP.txtPassword.setEditable(true);

			}

			if (e.getSource() == viewCredencialP.jlbOcultarPass) {

				if (viewCredencialP.txtPassword.getEchoChar() == '\u2022') {

					viewCredencialP.jlbOcultarPass.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON1.png")));
					viewCredencialP.txtPassword.setEchoChar('\u0000');

				} else if (viewCredencialP.txtPassword.getEchoChar() == '\u0000') {

					viewCredencialP.jlbOcultarPass.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOff1.png")));
					viewCredencialP.txtPassword.setEchoChar('\u2022');

				}

			}

			if (e.getSource() == viewCredencialP.jlbEditarInfo) {

				viewCredencialP.txtDatos.setEditable(true);

			}

		}

		if (viewCredencialB != null) {

			if (e.getSource() == viewCredencialB.jlbOcultarNumTarj) {

				if (viewCredencialB.txtNoTarjeta.getEchoChar() == '\u2022') {

					viewCredencialB.jlbOcultarNumTarj.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON1.png")));
					viewCredencialB.txtNoTarjeta.setEchoChar('\u0000');

				} else if (viewCredencialB.txtNoTarjeta.getEchoChar() == '\u0000') {

					viewCredencialB.jlbOcultarNumTarj.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOff1.png")));
					viewCredencialB.txtNoTarjeta.setEchoChar('\u2022');

				}

			}

			if (e.getSource() == viewCredencialB.jlbOcultarCVV) {

				if (viewCredencialB.txtCVV.getEchoChar() == '\u2022') {

					viewCredencialB.jlbOcultarCVV.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON1.png")));
					viewCredencialB.txtCVV.setEchoChar('\u0000');

				} else if (viewCredencialB.txtCVV.getEchoChar() == '\u0000') {

					viewCredencialB.jlbOcultarCVV.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOff1.png")));
					viewCredencialB.txtCVV.setEchoChar('\u2022');

				}

			}

			if (e.getSource() == viewCredencialB.jlbEditarInfo) {

				viewCredencialB.txtDatos.setEditable(true);

			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
