package views;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewCredencialP extends JFrame {

	private JPanel PanelPrincipal/*, PanelMenu*/, PanelDatos;
	private JLabel jlbLogo, jlbNomApp/*, jlbImg1*/, jlbIco, jlbTitulo2, jlbPlataforma, jlbUsuario, jlbPassword, jlbURL, jlbDatos, jlbActualizacion;
	public JLabel jlbEditarUsuario, jlbEditarPass, jlbOcultarPass, jlbEditarInfo;
	public JButton bRespaldo, bCerrar, bHistorial, bCredencial, bGuardar, bEliminar, bPrincipal;
	public JTextField txtPlataforma, txtUsuario, txtURL, txtDatos;
	public JPasswordField txtPassword;
	public JLabel jlbFecha;
	private JSeparator sep1, sep2, sep3, sep4;

	public ViewCredencialP() throws UnsupportedLookAndFeelException {

		PanelPrincipal = new JPanel();
//		PanelMenu = new JPanel();
		jlbLogo = new JLabel();
		jlbNomApp = new JLabel();
		bRespaldo = new JButton();
		bCerrar = new JButton();
		bHistorial = new JButton();
		bCredencial = new JButton();
//		jlbImg1 = new JLabel();
		jlbIco = new JLabel();
		jlbTitulo2 = new JLabel();
		PanelDatos = new JPanel();
		jlbUsuario = new JLabel();
		txtUsuario = new JTextField();
		sep1 = new JSeparator();
		jlbPlataforma = new JLabel();
		txtPlataforma = new JTextField();
		sep2 = new JSeparator();
		sep3 = new JSeparator();
		txtPassword = new JPasswordField();
		jlbPassword = new JLabel();
		sep4 = new JSeparator();
		txtURL = new JTextField();
		txtDatos = new JTextField();
		jlbDatos = new JLabel();
		jlbURL = new JLabel();
		jlbEditarInfo = new JLabel();
		jlbEditarUsuario = new JLabel();
		jlbOcultarPass = new JLabel();
		jlbEditarPass = new JLabel();
		jlbFecha = new JLabel();
		jlbActualizacion = new JLabel();
		bPrincipal = new JButton();
		bGuardar = new JButton();
		bEliminar = new JButton();

		setTitle("SecurePass Manager");
		setResizable(false);

		//JPanel
		PanelPrincipal.setBackground(new java.awt.Color(228, 233, 242));
		PanelPrincipal.setMinimumSize(new java.awt.Dimension(1024, 640));
		PanelPrincipal.setPreferredSize(new java.awt.Dimension(1024, 640));
		PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

//		PanelMenu.setBackground(new java.awt.Color(31, 74, 125));
//		PanelMenu.setPreferredSize(new java.awt.Dimension(230, 100));
//		PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		PanelDatos.setBackground(new java.awt.Color(185, 194, 210));
		PanelDatos.setPreferredSize(new java.awt.Dimension(448, 341));
		PanelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		//JLabel
		jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img6.png")));

		jlbNomApp.setFont(new java.awt.Font("Roboto Flex", 1, 16));
		jlbNomApp.setForeground(new java.awt.Color(255, 255, 255));
		jlbNomApp.setText("SecurePass Manager");

//		jlbImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img5.png")));
		jlbIco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plat1.png")));

		jlbTitulo2.setBackground(new java.awt.Color(51, 51, 51));
		jlbTitulo2.setFont(new java.awt.Font("Roboto Flex", 0, 20)); // NOI18N
		jlbTitulo2.setText("Información de la credencial");

		jlbUsuario.setBackground(new java.awt.Color(51, 51, 51));
		jlbUsuario.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
		jlbUsuario.setText("Usuario");

		jlbPlataforma.setBackground(new java.awt.Color(51, 51, 51));
		jlbPlataforma.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
		jlbPlataforma.setText("Plataforma");

		jlbPassword.setBackground(new java.awt.Color(51, 51, 51));
		jlbPassword.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
		jlbPassword.setText("Contraseña");

		jlbDatos.setBackground(new java.awt.Color(51, 51, 51));
		jlbDatos.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
		jlbDatos.setText("Datos extra");

		jlbURL.setBackground(new java.awt.Color(51, 51, 51));
		jlbURL.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
		jlbURL.setText("URL");

		jlbEditarInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png")));
		jlbEditarInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jlbEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png")));
		jlbEditarUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jlbOcultarPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eyeOff1.png")));
		jlbOcultarPass.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jlbEditarPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png")));
		jlbEditarPass.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jlbFecha.setBackground(new java.awt.Color(51, 51, 51));
		jlbFecha.setFont(new java.awt.Font("Roboto Flex", 0, 16)); // NOI18N
		jlbFecha.setText("Fecha de Actualización");

		jlbActualizacion.setBackground(new java.awt.Color(51, 51, 51));
		jlbActualizacion.setFont(new java.awt.Font("Roboto Flex", 0, 16)); // NOI18N
		jlbActualizacion.setText("Actualizado :");

		//JTextField
		txtUsuario.setEditable(false);
		txtUsuario.setBackground(new java.awt.Color(185, 194, 210));
		txtUsuario.setFont(new java.awt.Font("Roboto Flex", 0, 15)); // NOI18N
		txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
		txtUsuario.setBorder(null);
		txtUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		txtPlataforma.setEditable(false);
		txtPlataforma.setBackground(new java.awt.Color(185, 194, 210));
		txtPlataforma.setFont(new java.awt.Font("Roboto Flex", 0, 15)); // NOI18N
		txtPlataforma.setForeground(new java.awt.Color(51, 51, 51));
		txtPlataforma.setBorder(null);
		txtPlataforma.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		txtPassword.setEditable(false);
		txtPassword.setBackground(new java.awt.Color(185, 194, 210));
		txtPassword.setFont(new java.awt.Font("Roboto Flex", 0, 15)); // NOI18N
		txtPassword.setForeground(new java.awt.Color(51, 51, 51));
		txtPassword.setBorder(null);
		txtPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		txtURL.setEditable(false);
		txtURL.setBackground(new java.awt.Color(185, 194, 210));
		txtURL.setFont(new java.awt.Font("Roboto Flex", 0, 15)); // NOI18N
		txtURL.setForeground(new java.awt.Color(51, 51, 51));
		txtURL.setBorder(null);
		txtURL.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		txtDatos.setEditable(false);
		txtDatos.setBackground(new java.awt.Color(185, 194, 210));
		txtDatos.setFont(new java.awt.Font("Roboto Flex", 0, 15)); // NOI18N
		txtDatos.setForeground(new java.awt.Color(51, 51, 51));
		txtDatos.setBorder(null);
		txtDatos.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		//JSeparator
		sep2.setBackground(new java.awt.Color(228, 233, 242));
		sep2.setForeground(new java.awt.Color(228, 233, 242));

		sep1.setBackground(new java.awt.Color(228, 233, 242));
		sep1.setForeground(new java.awt.Color(228, 233, 242));

		sep3.setBackground(new java.awt.Color(228, 233, 242));
		sep3.setForeground(new java.awt.Color(228, 233, 242));

		sep4.setBackground(new java.awt.Color(228, 233, 242));
		sep4.setForeground(new java.awt.Color(228, 233, 242));

		//JButton
		bRespaldo.setBackground(new java.awt.Color(31, 74, 125));
		bRespaldo.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bRespaldo.setForeground(new java.awt.Color(255, 255, 255));
		bRespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/respaldo.png")));
		bRespaldo.setText(" Respaldo");
		bRespaldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bRespaldo.setEnabled(false);
		bRespaldo.setPreferredSize(new java.awt.Dimension(145, 70));

		bPrincipal.setBackground(new java.awt.Color(185, 194, 210));
		bPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/principal.png"))); // NOI18N
		bPrincipal.setPreferredSize(new java.awt.Dimension(60, 68));

		bGuardar.setBackground(new java.awt.Color(185, 194, 210));
		bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardarCam.png"))); // NOI18N
		bGuardar.setPreferredSize(new java.awt.Dimension(60, 68));

		bEliminar.setBackground(new java.awt.Color(185, 194, 210));
		bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eliminar.png"))); // NOI18N
		bEliminar.setPreferredSize(new java.awt.Dimension(60, 68));

		bCerrar.setBackground(new java.awt.Color(31, 74, 125));
		bCerrar.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bCerrar.setForeground(new java.awt.Color(255, 255, 255));
		bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir.png")));
		bCerrar.setText(" Cerrar sesión");
		bCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bCerrar.setPreferredSize(new java.awt.Dimension(145, 70));

		bHistorial.setBackground(new java.awt.Color(31, 74, 125));
		bHistorial.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bHistorial.setForeground(new java.awt.Color(255, 255, 255));
		bHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/historial.png")));
		bHistorial.setText(" Historial");
		bHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bHistorial.setEnabled(false);
		bHistorial.setPreferredSize(new java.awt.Dimension(145, 70));

		bCredencial.setBackground(new java.awt.Color(31, 74, 125));
		bCredencial.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bCredencial.setForeground(new java.awt.Color(255, 255, 255));
		bCredencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png")));
		bCredencial.setText(" Credenciales");
		bCredencial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bCredencial.setPreferredSize(new java.awt.Dimension(145, 70));

		//Diseño
//		PanelMenu.add(jlbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));
//		PanelMenu.add(jlbNomApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
//		PanelMenu.add(bRespaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 230, 60));
//		PanelMenu.add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 230, 60));
//		PanelMenu.add(bHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 60));
//		PanelMenu.add(bCredencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 60));
//		PanelPrincipal.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));
//		PanelPrincipal.add(jlbImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));
		int factor = 280;
		PanelPrincipal.add(jlbIco, new org.netbeans.lib.awtextra.AbsoluteConstraints(600 - factor, 30, -1, -1));
		PanelPrincipal.add(jlbTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520 - factor, 140, -1, -1));
		PanelDatos.add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, -1));
		PanelDatos.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 280, -1));
		PanelDatos.add(sep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 450, 10));
		PanelDatos.add(jlbPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, 90, -1));
		PanelDatos.add(txtPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, -1));
		PanelDatos.add(sep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 450, 10));
		PanelDatos.add(sep3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 450, 10));
		PanelDatos.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 280, -1));
		PanelDatos.add(jlbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));
		PanelDatos.add(sep4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 450, 10));
		PanelDatos.add(txtURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 280, -1));
		PanelDatos.add(txtDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 280, -1));
		PanelDatos.add(jlbDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));
		PanelDatos.add(jlbURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 40, -1));
		PanelDatos.add(jlbEditarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));
		PanelDatos.add(jlbEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));
		PanelDatos.add(jlbOcultarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));
		PanelDatos.add(jlbEditarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));
		PanelPrincipal.add(PanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340 - factor, 210, -1, 350));
		PanelPrincipal.add(jlbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(610 - factor, 590, 170, -1));
		PanelPrincipal.add(jlbActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510 - factor, 590, 100, -1));
		PanelPrincipal.add(bPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880 - factor, 350, -1, -1));
		PanelPrincipal.add(bGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880 - factor, 210, -1, -1));
		PanelPrincipal.add(bEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880 - factor, 280, -1, -1));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
										.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
										.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);

		add(PanelPrincipal);

		pack();

		UIManager.setLookAndFeel(new FlatLightLaf());

		SwingUtilities.updateComponentTreeUI(this);
	}

	public void bloquearCampos() {
		txtDatos.setEditable(false);
		txtPassword.setEditable(false);
		txtPlataforma.setEditable(false);
		txtURL.setEditable(false);
		txtUsuario.setEditable(false);
	}

}
