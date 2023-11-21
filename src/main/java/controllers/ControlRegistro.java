package controllers;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import models.Usuario;
import repositories.RepositorioUsuario;
import views.ViewLogin;
import views.ViewPrincipal;
import views.ViewRegistro;

public class ControlRegistro implements MouseListener, ActionListener {

	private final ViewRegistro viewRegistro;
//	private ControlLogin controlLogin;
	private boolean bandera = true;
//	private ControlPrincipal controlPrincipal;

	public ControlRegistro(ViewRegistro viewRegistro) {
		this.viewRegistro = viewRegistro;

		this.viewRegistro.bRegresar.addActionListener(this);
		this.viewRegistro.jlbIco1.addMouseListener(this);
		this.viewRegistro.bEntrar.addActionListener(this);
	}

//	//Obsoleto
//	public ControlRegistro(ViewRegistro viewRegistro, ControlLogin controlLogin, ControlPrincipal controlPrincipal) {
//		this.viewRegistro = viewRegistro;
//		this.controlLogin = controlLogin;
//		this.controlPrincipal = controlPrincipal;
//
//		this.viewRegistro.bRegresar.addActionListener(this);
//		this.viewRegistro.jlbIco1.addMouseListener(this);
//		this.viewRegistro.bEntrar.addActionListener(this);
//	}
//
//	public void setControlPrincipal(ControlPrincipal controlPrincipal) {
//		this.controlPrincipal = controlPrincipal;
//	}
	public void iniciarVistaRegistro() throws UnsupportedLookAndFeelException {
//		viewRegistro.setTitle("SecurePass Manager");
//		viewRegistro.pack();
//		viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		viewRegistro.setLocationRelativeTo(null);
//		viewRegistro.setResizable(false);
//
//		UIManager.setLookAndFeel(new FlatLightLaf());
//
//		viewRegistro.bEntrar.putClientProperty("JButton.buttonType", "roundRect");
//		UIManager.put("TextComponent.arc", 5);
//
//		SwingUtilities.updateComponentTreeUI(viewRegistro);
		viewRegistro.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewRegistro.bRegresar == e.getSource()) {
			try {

				ControlLogin cLogin = new ControlLogin(new ViewLogin());
				cLogin.iniciarVistaLogin();
//				controlLogin.iniciarVistaLogin();
			} catch (UnsupportedLookAndFeelException ex) {
			}
//			controlLogin.limpiarTextFields(viewRegistro);

			viewRegistro.dispose();
		}
		if (viewRegistro.bEntrar == e.getSource()) {
			try {

				viewRegistro.bEntrar.setEnabled(false);

				var pass1 = new String(viewRegistro.pfPassword.getPassword());
				var pass2 = viewRegistro.txtPassword.getText();

				if (!pass1.equals(pass2)) {

					viewRegistro.jlbIco2.setIcon(new ImageIcon(getClass().getResource("/icons/confirmacionOFF.png")));

					JOptionPane.showMessageDialog(
									viewRegistro,
									"Las contraseñas no coinciden",
									"Error al registrar",
									JOptionPane.WARNING_MESSAGE);

					viewRegistro.bEntrar.setEnabled(true);
					return;

				}

				viewRegistro.jlbIco2.setIcon(new ImageIcon(getClass().getResource("/icons/confirmacionON.png")));

				Usuario usuario = new Usuario();
				usuario.setNombre(viewRegistro.txtNomUsuario.getText());
				usuario.setNombrePersona(viewRegistro.txtNombre.getText());
				usuario.setPassword(pass1);
				usuario.setApellidoPaternoPersona(viewRegistro.txtApPaterno.getText());
				usuario.setApellidoMeternoPersona(viewRegistro.txtApMaterno.getText());

				if (!RepositorioUsuario.addUsuario(usuario)) {

					JOptionPane.showMessageDialog(
									viewRegistro,
									"No se pudo registrar el usuario. \nIntente más tarde.",
									"Error al registrar",
									JOptionPane.ERROR_MESSAGE);

					viewRegistro.limpiar();
					return;
				}

				ControlPrincipal cPrincipal = new ControlPrincipal(new ViewPrincipal(), usuario);
				cPrincipal.iniciarVistaPrincipal();

//				controlPrincipal.iniciarVistaPrincipal();
			} catch (UnsupportedLookAndFeelException ex) {
			} catch (Exception ex) {

				JOptionPane.showMessageDialog(
								viewRegistro,
								"No se pudo registrar el usuario. \nIntente más tarde.",
								"Error al registrar",
								JOptionPane.ERROR_MESSAGE);

				viewRegistro.limpiar();
				return;

			}
//			controlLogin.limpiarTextFields(viewRegistro);
			viewRegistro.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (viewRegistro.jlbIco1 == e.getSource()) {

			if (viewRegistro.pfPassword.getEchoChar() == '\u2022') {

				viewRegistro.jlbIco1.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON.png")));
				viewRegistro.pfPassword.setEchoChar('\u0000');

			} else if (viewRegistro.pfPassword.getEchoChar() == '\u0000') {

				viewRegistro.jlbIco1.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOFF.png")));
				viewRegistro.pfPassword.setEchoChar('\u2022');

			}

			if (bandera) {
				viewRegistro.jlbIco1.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON.png")));
				viewRegistro.pfPassword.setEchoChar((char) 0);
			} else {
				viewRegistro.jlbIco1.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOFF.png")));
				viewRegistro.pfPassword.setEchoChar('\u2022');
			}

			bandera = !bandera;
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

	public ViewRegistro getView() {
		return viewRegistro;
	}

}
