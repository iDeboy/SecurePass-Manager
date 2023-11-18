/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
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
    private JLabel jlbImg1,jlbImgLog,jlbNomApp,jlbEslogan,jlbTitulo,jlbIco1,jlbIco2,jlbPregunta;
    public JLabel jlbIco3,jlbRegistro;
    public JTextField txtNomUsuario;
    public JPasswordField pfPassword;
    public JButton bEntrar;
    
    public ViewLogin() {
        
        //JPanel
        PanelPrincipal = new JPanel();
        PanelPrincipal.setBackground(new Color(31,74,125));
        PanelPrincipal.setPreferredSize(new Dimension(1024, 640));
        PanelPrincipal.setLayout(new AbsoluteLayout());
        
        //JLabel
        jlbImg1 = new JLabel();
        jlbImg1.setIcon(new ImageIcon(getClass().getResource("/images/img1.png")));
        
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
        jlbTitulo.setText("INICIAR SESIÓN");
        jlbTitulo.setFont(new Font("Roboto", 1, 20));
        jlbTitulo.setForeground(new Color(255, 255, 255));
        
        jlbIco1 = new JLabel();
        jlbIco1.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));
        
        jlbIco2 = new JLabel();
        jlbIco2.setIcon(new ImageIcon(getClass().getResource("/icons/look.png")));
        
        jlbIco3 = new JLabel();
        jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOFF.png")));
        
        jlbPregunta = new JLabel();
        jlbPregunta.setText("¿No tienes cuenta?");
        jlbPregunta.setFont(new Font("Roboto", 0, 16));
        jlbPregunta.setForeground(new Color(255, 255, 255));
        
        jlbRegistro = new JLabel();
        jlbRegistro.setText("Regístrate");
        jlbRegistro.setFont(new Font("Roboto", 0, 16));
        jlbRegistro.setForeground(new Color(255, 255, 255));
        jlbRegistro.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        
        Font fuenteActual = jlbRegistro.getFont();
        Map<TextAttribute, Object> atributos = new HashMap<>(fuenteActual.getAttributes());
        atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        Font fuenteSubrayada = fuenteActual.deriveFont(atributos);
        jlbRegistro.setFont(fuenteSubrayada);
        
        //JTextField
        txtNomUsuario = new JTextField();
        txtNomUsuario.setText("Usuario");
        txtNomUsuario.setFont(new Font("Roboto Mono", 0, 15));
        txtNomUsuario.setForeground(new Color(102, 102, 102));
        txtNomUsuario.setPreferredSize(new Dimension(300, 44));
        
        //JPasswordField
        pfPassword = new JPasswordField();
        pfPassword.setText("Contraseña");
        pfPassword.setFont(new Font("Roboto Mono", 0, 15));
        pfPassword.setForeground(new Color(102, 102, 102));
        pfPassword.setPreferredSize(new Dimension(300, 44));
        
        //JButton
        bEntrar = new JButton();
        bEntrar.setText("ENTRAR");
        bEntrar.setFont(new Font("Roboto Mono Medium", 0, 16));
        bEntrar.setForeground(new Color(51, 51, 51));
        bEntrar.setBackground(new Color(141, 174, 236));
        bEntrar.setBorder(null);
        bEntrar.setPreferredSize(new Dimension(227, 44));
        bEntrar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        //Diseño
        PanelPrincipal.add(jlbImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, -1));
        PanelPrincipal.add(jlbImgLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));
        PanelPrincipal.add(jlbNomApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));
        PanelPrincipal.add(jlbEslogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));
        PanelPrincipal.add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));
        PanelPrincipal.add(jlbIco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));
        PanelPrincipal.add(jlbIco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));
        PanelPrincipal.add(jlbIco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));
        PanelPrincipal.add(jlbPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, -1, -1));
        PanelPrincipal.add(jlbRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, -1, -1));
        PanelPrincipal.add(txtNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));
        PanelPrincipal.add(pfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));
        PanelPrincipal.add(bEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

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
        
    }
    
}
