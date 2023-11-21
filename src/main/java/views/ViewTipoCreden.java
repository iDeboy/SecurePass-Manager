package views;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewTipoCreden extends JFrame {

	private JPanel PanelPrincipal;
	private JLabel jlbTitulo;
	public JButton bPlataforma, bBanco;

	public ViewTipoCreden() throws UnsupportedLookAndFeelException {

		this.setTitle("SecurePass Manager");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		//JPanel
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new java.awt.Color(238, 238, 238));
		PanelPrincipal.setPreferredSize(new java.awt.Dimension(541, 361));
		PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		//JLabel
		jlbTitulo = new JLabel();
		jlbTitulo.setFont(new java.awt.Font("Roboto Flex", 0, 20));
		jlbTitulo.setText("¿Qué tipo de credencial deseas guardar?");

		//JButton
		bPlataforma = new JButton();
		bPlataforma.setBackground(new java.awt.Color(141, 174, 236));
		bPlataforma.setFont(new java.awt.Font("Roboto Flex", 1, 16));
		bPlataforma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plat1.png")));
		bPlataforma.setPreferredSize(new java.awt.Dimension(170, 170));
		bPlataforma.setText("PLATAFORMA");
		bPlataforma.setName("bPlataforma");

		bBanco = new JButton();
		bBanco.setBackground(new java.awt.Color(141, 174, 236));
		bBanco.setFont(new java.awt.Font("Roboto Flex", 1, 16));
		bBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ban1.png")));
		bBanco.setPreferredSize(new java.awt.Dimension(170, 170));
		bBanco.setText("BANCO");
		bBanco.setName("bBanco");

		bPlataforma.setVerticalTextPosition(SwingConstants.BOTTOM);
		bPlataforma.setHorizontalTextPosition(SwingConstants.CENTER);
		bPlataforma.setVerticalAlignment(SwingConstants.CENTER);
		bPlataforma.setHorizontalAlignment(SwingConstants.CENTER);

		bBanco.setVerticalTextPosition(SwingConstants.BOTTOM);
		bBanco.setHorizontalTextPosition(SwingConstants.CENTER);
		bBanco.setVerticalAlignment(SwingConstants.CENTER);
		bBanco.setHorizontalAlignment(SwingConstants.CENTER);

		//Diseño
		PanelPrincipal.add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 380, -1));
		PanelPrincipal.add(bBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));
		PanelPrincipal.add(bPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
														.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
														.addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0, Short.MAX_VALUE))
		);

		add(PanelPrincipal);

		this.pack();

		UIManager.setLookAndFeel(new FlatLightLaf());
		SwingUtilities.updateComponentTreeUI(this);
	}

}
