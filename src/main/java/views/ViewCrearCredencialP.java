/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author laura
 */
public class ViewCrearCredencialP extends JFrame{
    
    private JPanel PanelPrincipal,PanelMenu;
    private JLabel jlbLogo,jlbNomApp,jlbImg1,jlbIcoP,jlbTitulo2,jlbPassword,jlbPlataforma,jlbUsuario,jlbURL,jlbDatos;
    public JTextField txtUsuario,txtPassword,txtPlataforma,txtURL,txtDatos;
    public JButton bRespaldo,bCerrar,bHistorial,bCredencial,bGuardar,bRegresar;
    
    public ViewCrearCredencialP(){
        PanelPrincipal = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        jlbLogo = new javax.swing.JLabel();
        jlbNomApp = new javax.swing.JLabel();
        bRespaldo = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        bHistorial = new javax.swing.JButton();
        bCredencial = new javax.swing.JButton();
        jlbImg1 = new javax.swing.JLabel();
        jlbIcoP = new javax.swing.JLabel();
        jlbTitulo2 = new javax.swing.JLabel();
        jlbPassword = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jlbPlataforma = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jlbUsuario = new javax.swing.JLabel();
        txtPlataforma = new javax.swing.JTextField();
        jlbURL = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jlbDatos = new javax.swing.JLabel();
        txtDatos = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        bRegresar = new javax.swing.JButton();
        
        //JPanel
        PanelPrincipal.setBackground(new java.awt.Color(228, 233, 242));
        PanelPrincipal.setMinimumSize(new java.awt.Dimension(1024, 640));
        PanelPrincipal.setPreferredSize(new java.awt.Dimension(1024, 640));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        PanelMenu.setBackground(new java.awt.Color(31, 74, 125));
        PanelMenu.setPreferredSize(new java.awt.Dimension(230, 640));
        PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //JLabel
        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img6.png")));
        
        jlbNomApp.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
        jlbNomApp.setForeground(new java.awt.Color(255, 255, 255));
        jlbNomApp.setText("SecurePass Manager");
        
        jlbImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img5.png")));
        
        jlbIcoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ico1.png")));
        
        jlbTitulo2.setBackground(new java.awt.Color(51, 51, 51));
        jlbTitulo2.setFont(new java.awt.Font("Roboto Flex", 1, 16)); // NOI18N
        jlbTitulo2.setText("PLATAFORMA");
        
        jlbPassword.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlbPassword.setText("Contraseña :");
        
        jlbPlataforma.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlbPlataforma.setText("Nombre de la Plataforma:");
        
        jlbUsuario.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlbUsuario.setText("Nombre de usuario o Correo electrónico :");
        
        jlbURL.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlbURL.setText("URL :");
        
        jlbDatos.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlbDatos.setText("Datos extra :");
        
        //JTextField
        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 15));
        
        txtPassword.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        
        txtPlataforma.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        
        txtURL.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        
        txtDatos.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        
        //JButton
        bRespaldo.setBackground(new java.awt.Color(31, 74, 125));
        bRespaldo.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        bRespaldo.setForeground(new java.awt.Color(255, 255, 255));
        bRespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/respaldo.png"))); // NOI18N
        bRespaldo.setText(" Respaldo");
        bRespaldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
        bRespaldo.setEnabled(false);
        bRespaldo.setPreferredSize(new java.awt.Dimension(145, 70));
        
        bCerrar.setBackground(new java.awt.Color(31, 74, 125));
        bCerrar.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        bCerrar.setForeground(new java.awt.Color(255, 255, 255));
        bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir.png"))); // NOI18N
        bCerrar.setText(" Cerrar sesión");
        bCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
        bCerrar.setPreferredSize(new java.awt.Dimension(145, 70));
        
        bHistorial.setBackground(new java.awt.Color(31, 74, 125));
        bHistorial.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        bHistorial.setForeground(new java.awt.Color(255, 255, 255));
        bHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/historial.png"))); // NOI18N
        bHistorial.setText(" Historial");
        bHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
        bHistorial.setEnabled(false);
        bHistorial.setPreferredSize(new java.awt.Dimension(145, 70));
        
        bCredencial.setBackground(new java.awt.Color(31, 74, 125));
        bCredencial.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        bCredencial.setForeground(new java.awt.Color(255, 255, 255));
        bCredencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        bCredencial.setText(" Credenciales");
        bCredencial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 114, 175)));
        bCredencial.setPreferredSize(new java.awt.Dimension(145, 70));
        
        bGuardar.setBackground(new java.awt.Color(164, 187, 230));
        bGuardar.setFont(new java.awt.Font("Roboto Mono", 1, 16)); // NOI18N
        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardar.png"))); // NOI18N
        bGuardar.setText(" GUARDAR");
        
        bRegresar.setBackground(new java.awt.Color(164, 187, 230));
        bRegresar.setFont(new java.awt.Font("Roboto Mono", 1, 16)); // NOI18N
        bRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/regresar.png"))); // NOI18N
        bRegresar.setText(" REGRESAR");
        
        //Diseño
        PanelMenu.add(jlbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));
        PanelMenu.add(jlbNomApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        PanelMenu.add(bRespaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 230, 60));
        PanelMenu.add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 230, 60));
        PanelMenu.add(bHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 60));
        PanelMenu.add(bCredencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 60));
        PanelPrincipal.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));
        PanelPrincipal.add(jlbImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));
        PanelPrincipal.add(jlbIcoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));
        PanelPrincipal.add(jlbTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));
        PanelPrincipal.add(jlbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));
        PanelPrincipal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 410, 30));
        PanelPrincipal.add(jlbPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));
        PanelPrincipal.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 240, 30));
        PanelPrincipal.add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));
        PanelPrincipal.add(txtPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 240, 30));
        PanelPrincipal.add(jlbURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));
        PanelPrincipal.add(txtURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 410, 30));
        PanelPrincipal.add(jlbDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, -1, -1));
        PanelPrincipal.add(txtDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 410, 30));
        PanelPrincipal.add(bGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 150, 50));
        PanelPrincipal.add(bRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 150, 50));
        
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
    }
    
}
