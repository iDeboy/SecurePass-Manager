package views;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewPrincipal extends JFrame {

	private JPanel PanelPrincipal, PanelMenu, PanelFiltro;
	private JLabel jlbTituloF, jlbLogo, jlbNomApp, jlbImg1;
	public JButton bRespaldo, bCerrar, bHistorial, bCredencial;
	public JTextField txtBuscar;
	public JTable jTLista;
	public JComboBox jcbCorreo, jcbBanco, jcbPlataforma;
	private JScrollPane jspTabla;

	public ViewPrincipal() throws UnsupportedLookAndFeelException {

		setTitle("SecurePass Manager");
		setResizable(false);

		//JPanel
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new java.awt.Color(249, 247, 247));
		PanelPrincipal.setPreferredSize(new java.awt.Dimension(1024, 640));
		PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		PanelFiltro = new JPanel();
		PanelFiltro.setBackground(new java.awt.Color(222, 225, 232));
		PanelFiltro.setPreferredSize(new java.awt.Dimension(220, 220));
		PanelFiltro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		PanelMenu = new JPanel();
		PanelMenu.setBackground(new java.awt.Color(31, 74, 125));
		PanelMenu.setPreferredSize(new java.awt.Dimension(230, 100));
		PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		//JLabel
		jlbTituloF = new JLabel();
		jlbTituloF.setFont(new java.awt.Font("Roboto", 1, 16));
		jlbTituloF.setForeground(new java.awt.Color(30, 30, 30));
		jlbTituloF.setText("Filtrar por");

		jlbNomApp = new JLabel();
		jlbNomApp.setFont(new java.awt.Font("Roboto Flex", 1, 16));
		jlbNomApp.setForeground(new java.awt.Color(255, 255, 255));
		jlbNomApp.setText("SecurePass Manager");

		jlbLogo = new JLabel();
		jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img6.png")));

		jlbImg1 = new JLabel();
		jlbImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img5.png")));

		//JButton
		bRespaldo = new JButton();
		bRespaldo.setBackground(new java.awt.Color(31, 74, 125));
		bRespaldo.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bRespaldo.setForeground(new java.awt.Color(255, 255, 255));
		bRespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/respaldo.png")));
		bRespaldo.setText(" Respaldo");
		bRespaldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bRespaldo.setEnabled(false);
		bRespaldo.setPreferredSize(new java.awt.Dimension(145, 70));

		bCerrar = new JButton();
		bCerrar.setBackground(new java.awt.Color(31, 74, 125));
		bCerrar.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bCerrar.setForeground(new java.awt.Color(255, 255, 255));
		bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir.png")));
		bCerrar.setText(" Cerrar sesión");
		bCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bCerrar.setPreferredSize(new java.awt.Dimension(145, 70));

		bHistorial = new JButton();
		bHistorial.setBackground(new java.awt.Color(31, 74, 125));
		bHistorial.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bHistorial.setForeground(new java.awt.Color(255, 255, 255));
		bHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/historial.png")));
		bHistorial.setText(" Historial");
		bHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bHistorial.setEnabled(false);
		bHistorial.setPreferredSize(new java.awt.Dimension(145, 70));

		bCredencial = new JButton();
		bCredencial.setBackground(new java.awt.Color(31, 74, 125));
		bCredencial.setFont(new java.awt.Font("Roboto Mono", 0, 16));
		bCredencial.setForeground(new java.awt.Color(255, 255, 255));
		bCredencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png")));
		bCredencial.setText(" Credenciales");
		bCredencial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
		bCredencial.setPreferredSize(new java.awt.Dimension(145, 70));

		//JTextFiedl
		txtBuscar = new JTextField();
		txtBuscar.setFont(new java.awt.Font("Roboto Mono", 0, 15));
		txtBuscar.setPreferredSize(new java.awt.Dimension(338, 40));

		//JTable
		jTLista = new JTable();
		jTLista.setBackground(new java.awt.Color(249, 247, 247));
		jTLista.setFont(new java.awt.Font("Roboto", 0, 16));
		jTLista.setFont(new java.awt.Font("Roboto", 0, 16));
		jTLista.setRowHeight(40);
		jTLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTLista.setTableHeader(null);
		jTLista.setShowVerticalLines(false);
		jTLista.setShowHorizontalLines(false);

		//JScrollPane
		jspTabla = new JScrollPane();
		jspTabla.setBorder(null);
		jspTabla.setViewportView(jTLista);

		//JComboBox
		jcbPlataforma = new JComboBox();
		jcbPlataforma.setBackground(new java.awt.Color(222, 225, 232));
		jcbPlataforma.setFont(new java.awt.Font("Roboto", 0, 15));
		jcbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Plataforma"}));
		jcbPlataforma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jcbBanco = new JComboBox();
		jcbBanco.setBackground(new java.awt.Color(222, 225, 232));
		jcbBanco.setFont(new java.awt.Font("Roboto", 0, 15));
		jcbBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Banco"}));
		jcbBanco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jcbCorreo = new JComboBox();
		jcbCorreo.setBackground(new java.awt.Color(222, 225, 232));
		jcbCorreo.setFont(new java.awt.Font("Roboto", 0, 15));
		jcbCorreo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Correo electrónico"}));
		jcbCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		//Diseño
		PanelPrincipal.add(jspTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 450, 520));
		PanelFiltro.add(jlbTituloF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
		PanelFiltro.add(jcbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 210, 50));
		PanelFiltro.add(jcbPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 50));
		PanelFiltro.add(jcbBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, 50));
		PanelPrincipal.add(PanelFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 230, 250));
		PanelMenu.add(jlbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));
		PanelMenu.add(jlbNomApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
		PanelMenu.add(bRespaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 230, 60));
		PanelMenu.add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 230, 60));
		PanelMenu.add(bHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 60));
		PanelMenu.add(bCredencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 60));
		PanelPrincipal.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));
		PanelPrincipal.add(jlbImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);

		add(PanelPrincipal);

		pack();

		setLocationRelativeTo(null);

		UIManager.setLookAndFeel(new FlatLightLaf());

		jcbBanco.putClientProperty("Component.arc", 0);
		jcbCorreo.putClientProperty("Component.arc", 0);
		jcbPlataforma.putClientProperty("Component.arc", 0);

		UIManager.put("Component.arrowType", "triangle");

		SwingUtilities.updateComponentTreeUI(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
