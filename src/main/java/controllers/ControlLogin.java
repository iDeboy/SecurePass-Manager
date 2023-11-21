package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import repositories.RepositorioUsuario;
import views.ViewLogin;
import views.ViewPrincipal;
import views.ViewRegistro;

public class ControlLogin implements MouseListener, ActionListener { //implements ActionListener, MouseListener

	private ViewLogin viewLogin;
//	private ControlRegistro controlRegistro;
	private boolean bandera = true;
//	private ControlPrincipal controlPrincipal;

	public ControlLogin(ViewLogin viewLogin) {
		this.viewLogin = viewLogin;

		this.viewLogin.txtNomUsuario.addMouseListener(this);
		this.viewLogin.pfPassword.addMouseListener(this);
		this.viewLogin.jlbIco3.addMouseListener(this);
		this.viewLogin.jlbRegistro.addMouseListener(this);

		this.viewLogin.bEntrar.addActionListener(this);
	}

	public void iniciarVistaLogin() throws UnsupportedLookAndFeelException {
		viewLogin.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (viewLogin.txtNomUsuario == e.getSource()) {

			if (viewLogin.txtNomUsuario.getText().equals("Usuario")) {
				viewLogin.txtNomUsuario.setText("");
				viewLogin.txtNomUsuario.setForeground(Color.black);
//				Vpassword();
			}
			if (String.valueOf(viewLogin.pfPassword.getPassword()).isEmpty()) {
				viewLogin.pfPassword.setText("Contraseña");
				viewLogin.pfPassword.setForeground(new Color(102, 102, 102));
//				Vpassword();
			}

		}
		if (viewLogin.pfPassword == e.getSource()) {

			if (String.valueOf(viewLogin.pfPassword.getPassword()).equals("Contraseña")) {
				viewLogin.pfPassword.setText("");
				viewLogin.pfPassword.setForeground(Color.black);
				viewLogin.pfPassword.setEchoChar('\u2022');
//				Vpassword();
			}
			if (viewLogin.txtNomUsuario.getText().isEmpty()) {
				viewLogin.txtNomUsuario.setText("Usuario");
				viewLogin.txtNomUsuario.setForeground(new Color(102, 102, 102));
//				Vpassword();
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (viewLogin.jlbIco3 == e.getSource()) {

			if (viewLogin.pfPassword.getEchoChar() == '\u2022') {

				viewLogin.jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON.png")));
				viewLogin.pfPassword.setEchoChar('\u0000');

			} else if (viewLogin.pfPassword.getEchoChar() == '\u0000') {

				viewLogin.jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOff.png")));

				if (!new String(viewLogin.pfPassword.getPassword()).equals("Contraseña")) {
					viewLogin.pfPassword.setEchoChar('\u2022');
				}

			}

//			bandera = !bandera;
//			if (bandera) {
//				viewLogin.jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOff.png")));
//				Vpassword();
//			} else {
//				viewLogin.jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON.png")));
//				Vpassword();
//			}
		}

		if (viewLogin.jlbRegistro == e.getSource()) {
			try {

				ControlRegistro cRegistro = new ControlRegistro(new ViewRegistro());
				cRegistro.iniciarVistaRegistro();

			} catch (UnsupportedLookAndFeelException ex) {
			}

			viewLogin.dispose();
		}
	}

	public void Vpassword() {

		if ((String.valueOf(viewLogin.pfPassword.getPassword()).isEmpty()) && (bandera == true)) {
			viewLogin.pfPassword.setEchoChar('\u2022');
		} else if ((String.valueOf(viewLogin.pfPassword.getPassword()).isEmpty()) && (bandera == false)) {
			viewLogin.pfPassword.setEchoChar((char) 0);
		} else if (String.valueOf(viewLogin.pfPassword.getPassword()).equals("Contraseña")) {
			viewLogin.pfPassword.setEchoChar((char) 0);
		} else if (bandera == true) {
			viewLogin.pfPassword.setEchoChar('\u2022');
		} else {
			viewLogin.pfPassword.setEchoChar((char) 0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewLogin.bEntrar == e.getSource()) {
			try {

				viewLogin.bEntrar.setEnabled(false);
				var usuario = RepositorioUsuario.loginUsuario(viewLogin.txtNomUsuario.getText(), new String(viewLogin.pfPassword.getPassword()));

				if (usuario == null) {
					JOptionPane.showMessageDialog(
									viewLogin,
									"El usuario o contraseña son incorrectos.",
									"Error al iniciar sesión",
									JOptionPane.ERROR_MESSAGE);

					mouseClicked(new MouseEvent(viewLogin.jlbIco3, 0, 0, 0, 0, 0, 0, false));
					viewLogin.limpiar();
					return;
				}

				ControlPrincipal cPrincipal = new ControlPrincipal(new ViewPrincipal(), usuario);
				cPrincipal.iniciarVistaPrincipal();

			} catch (UnsupportedLookAndFeelException ex) {
			}

			viewLogin.dispose();
		}
	}

//	// Obsoleto
//	public void limpiarTextFields(Container container) {
//		Component[] components = container.getComponents();
//		for (Component component : components) {
//			if (component instanceof JTextField) {
//				JTextField textField = (JTextField) component;
//				textField.setText("");
//			} else if (component instanceof Container) {
//				limpiarTextFields((Container) component);
//			}
//		}
//	}
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

	public ViewLogin getView() {
		return viewLogin;
	}

}
