/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewRegistro;

/**
 *
 * @author laura
 */
public class ControlRegistro implements MouseListener,ActionListener{
    
    private ViewRegistro viewRegistro;
    private ControlLogin controlLogin;
    private boolean bandera = true;
    private ControlPrincipal controlPrincipal;

    public ControlRegistro(ViewRegistro viewRegistro, ControlLogin controlLogin, ControlPrincipal controlPrincipal) {
        this.viewRegistro = viewRegistro;
        this.controlLogin = controlLogin;
        this.controlPrincipal = controlPrincipal;
        
        this.viewRegistro.bRegresar.addActionListener(this);
        this.viewRegistro.jlbIco1.addMouseListener(this);
        this.viewRegistro.bEntrar.addActionListener(this);
    }

    public void setControlPrincipal(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }
    
    public void iniciarVistaRegistro() throws UnsupportedLookAndFeelException{
        viewRegistro.setTitle("SecurePass Manager");
        viewRegistro.pack();
        viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewRegistro.setLocation(250, 90);
        viewRegistro.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        viewRegistro.bEntrar.putClientProperty("JButton.buttonType", "roundRect");
        UIManager.put( "TextComponent.arc", 5 );
        
        SwingUtilities.updateComponentTreeUI(viewRegistro);
        viewRegistro.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (viewRegistro.bRegresar == e.getSource()){
            try {
                controlLogin.iniciarVistaLogin();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewRegistro.dispose();
        }
        if(viewRegistro.bEntrar == e.getSource()){
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewRegistro.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (viewRegistro.jlbIco1 == e.getSource()){
            
            if(bandera){
                viewRegistro.jlbIco1.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON.png")));
                viewRegistro.pfPassword.setEchoChar((char) 0);
            }
            else{
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
 
}
