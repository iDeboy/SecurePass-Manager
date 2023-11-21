package views;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ViewRegistro extends JFrame {

	private JPanel PanelPrincipal;
	private JLabel jlbImg1, jlbImgLog, jlbNomApp, jlbEslogan, jlbTitulo, jlbNomUsuario, jlbNombre, jlbApPaterno, jlbApMaterno, jlbPassword, jlbConfPassword;
	public JLabel jlbIco1, jlbIco2;
	public JTextField txtNomUsuario, txtNombre, txtApPaterno, txtApMaterno, txtPassword;
	public JPasswordField pfPassword;
	public JButton bEntrar, bRegresar;

	public ViewRegistro() throws UnsupportedLookAndFeelException {

		setTitle("SecurePass Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		//JPanel
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new Color(31, 74, 125));
		PanelPrincipal.setPreferredSize(new Dimension(1024, 640));
		PanelPrincipal.setLayout(new AbsoluteLayout());

		//JLabel
		jlbImg1 = new JLabel();
		jlbImg1.setIcon(new ImageIcon(getClass().getResource("/images/img4.png")));

		jlbImgLog = new JLabel();
		jlbImgLog.setIcon(new ImageIcon(getClass().getResource("/images/img2.png")));

		jlbNomApp = new JLabel();
		jlbNomApp.setText("SecurePass Manager");
		jlbNomApp.setFont(new Font("Roboto Flex", 1, 20));
		jlbNomApp.setForeground(new Color(255, 255, 255));

		jlbEslogan = new JLabel();
		jlbEslogan.setText("Tu llave maestra para la seguridad digital");
		jlbEslogan.setFont(new Font("Roboto Flex", 1, 16));
		jlbEslogan.setForeground(new Color(255, 255, 255));

		jlbTitulo = new JLabel();
		jlbTitulo.setText("REGISTRO");
		jlbTitulo.setFont(new Font("Roboto", 1, 20));
		jlbTitulo.setForeground(new Color(255, 255, 255));

		jlbNomUsuario = new JLabel();
		jlbNomUsuario.setFont(new java.awt.Font("Roboto", 0, 16));
		jlbNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
		jlbNomUsuario.setText("Nombre de Usuario :");

		jlbNombre = new JLabel();
		jlbNombre.setFont(new java.awt.Font("Roboto", 0, 16));
		jlbNombre.setForeground(new java.awt.Color(255, 255, 255));
		jlbNombre.setText("Nombre(s) :");

		jlbApPaterno = new JLabel();
		jlbApPaterno.setFont(new java.awt.Font("Roboto", 0, 16));
		jlbApPaterno.setForeground(new java.awt.Color(255, 255, 255));
		jlbApPaterno.setText("Apellido Paterno :");

		jlbApMaterno = new JLabel();
		jlbApMaterno.setFont(new java.awt.Font("Roboto", 0, 16));
		jlbApMaterno.setForeground(new java.awt.Color(255, 255, 255));
		jlbApMaterno.setText("Apellido Materno :");

		jlbPassword = new JLabel();
		jlbPassword.setFont(new java.awt.Font("Roboto", 0, 16));
		jlbPassword.setForeground(new java.awt.Color(255, 255, 255));
		jlbPassword.setText("Contraseña :");

		jlbConfPassword = new JLabel();
		jlbConfPassword.setFont(new java.awt.Font("Roboto", 0, 16));
		jlbConfPassword.setForeground(new java.awt.Color(255, 255, 255));
		jlbConfPassword.setText("Confirmar contraseña :");

		jlbIco1 = new JLabel();
		jlbIco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eyeOff.png")));
		jlbIco1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jlbIco2 = new JLabel();
		jlbIco2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmacionOFF.png")));

		//JTextField
		txtNomUsuario = new JTextField();
		txtNomUsuario.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		txtNomUsuario.setForeground(Color.black);

		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		txtNombre.setForeground(Color.black);

		txtApPaterno = new JTextField();
		txtApPaterno.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		txtApPaterno.setForeground(Color.black);

		txtApMaterno = new JTextField();
		txtApMaterno.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		txtApMaterno.setForeground(Color.black);

		txtPassword = new JTextField();
		txtPassword.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		txtPassword.setForeground(Color.black);

		//JButton
		bEntrar = new JButton();
		bEntrar.setBackground(new java.awt.Color(141, 174, 236));
		bEntrar.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16));
		bEntrar.setForeground(new java.awt.Color(51, 51, 51));
		bEntrar.setText("ENTRAR");
		bEntrar.setBorder(null);
		bEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bEntrar.setPreferredSize(new java.awt.Dimension(227, 44));

		bRegresar = new JButton();
		bRegresar.setBackground(new java.awt.Color(141, 174, 236));
		bRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/regresar.png")));
		bRegresar.setBorder(null);
		bRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bRegresar.setPreferredSize(new java.awt.Dimension(227, 44));

		//JPasswordField
		pfPassword = new JPasswordField();
		pfPassword.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		pfPassword.setForeground(Color.black);

		//Diseño
		PanelPrincipal.add(jlbImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));
		PanelPrincipal.add(jlbImgLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));
		PanelPrincipal.add(jlbNomApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));
		PanelPrincipal.add(jlbEslogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));
		PanelPrincipal.add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
		PanelPrincipal.add(bEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, -1, -1));
		PanelPrincipal.add(jlbIco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, -1));
		PanelPrincipal.add(jlbApMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));
		PanelPrincipal.add(jlbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
		PanelPrincipal.add(txtNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, 30));
		PanelPrincipal.add(txtApMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 180, 30));
		PanelPrincipal.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 250, 30));
		PanelPrincipal.add(txtApPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 180, 30));
		PanelPrincipal.add(jlbConfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));
		PanelPrincipal.add(jlbApPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));
		PanelPrincipal.add(jlbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));
		PanelPrincipal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 180, 30));
		PanelPrincipal.add(jlbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));
		PanelPrincipal.add(jlbIco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));
		PanelPrincipal.add(pfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 250, 30));
		PanelPrincipal.add(bRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 50, -1));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		add(PanelPrincipal);

		pack();
		UIManager.setLookAndFeel(new FlatLightLaf());

		bEntrar.putClientProperty("JButton.buttonType", "roundRect");
		UIManager.put("TextComponent.arc", 5);

		SwingUtilities.updateComponentTreeUI(this);

		setLocationRelativeTo(null);

	}

	public void limpiar() {

		jlbIco2.setIcon(new ImageIcon(getClass().getResource("/icons/confirmacionOFF.png")));
		
		txtNomUsuario.setText("");
		txtNombre.setText("");
		txtApPaterno.setText("");
		txtApMaterno.setText("");
		txtPassword.setText("");
		bEntrar.setEnabled(true);

	}
}
