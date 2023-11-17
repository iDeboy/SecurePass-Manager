/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author laura
 */
public class ViewLogin extends JFrame{
    
    private JPanel PanelPrincipal;
    private JLabel jlbImg1,jlbImgLog,jlbNomApp,jlbEslogan,jlbTitulo,jlbIco1,jlbIco2,jlbIco3,jlbPregunta;
    public JLabel jlbRegistro;
    public JTextField txtNomUsuario;
    public JPasswordField pfPassword;
    public JButton bEntrar;
    
    public ViewLogin() {
        
        //JPanel
        PanelPrincipal = new JPanel();
        PanelPrincipal.setBackground(new java.awt.Color(31,74,125));
        PanelPrincipal.setPreferredSize(new Dimension(1024, 640));
        PanelPrincipal.setLayout(new AbsoluteLayout());
        
        //JLabel
        jlbImg1 = new JLabel();
        jlbImg1.setIcon(new ImageIcon(getClass().getResource("/images/img1.png")));
        
        //Diseño
        PanelPrincipal.add(jlbImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, -1));

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
        
    }
    
}
