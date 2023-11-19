/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewLogin;

/**
 *
 * @author laura
 */
public class ControlLogin implements MouseListener,ActionListener{ //implements ActionListener, MouseListener

    private ViewLogin viewLogin;
    private ControlRegistro controlRegistro;
    private boolean bandera = true;

    public ControlLogin(ViewLogin viewLogin, ControlRegistro controlRegistro) {
        this.viewLogin = viewLogin;
        this.controlRegistro = controlRegistro;
        
        this.viewLogin.txtNomUsuario.addMouseListener(this);
        this.viewLogin.pfPassword.addMouseListener(this);
        this.viewLogin.jlbIco3.addMouseListener(this);
        
        this.viewLogin.bEntrar.addActionListener(this);
    }

    public void iniciarVistaLogin() throws UnsupportedLookAndFeelException{
        viewLogin.setTitle("SecurePass Manager");
        viewLogin.pack();
        viewLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewLogin.setLocation(250, 90);
        viewLogin.setResizable(false);
              
        viewLogin.pfPassword.setEchoChar((char) 0);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        viewLogin.bEntrar.putClientProperty("JButton.buttonType", "roundRect");
        viewLogin.txtNomUsuario.putClientProperty("JComponent.roundRect", true);
        viewLogin.pfPassword.putClientProperty("JComponent.roundRect", true);
        
        SwingUtilities.updateComponentTreeUI(viewLogin);
        viewLogin.setVisible(true);
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
        if(viewLogin.txtNomUsuario == e.getSource()){
            
            if(viewLogin.txtNomUsuario.getText().equals("Usuario")){
                viewLogin.txtNomUsuario.setText("");
                viewLogin.txtNomUsuario.setForeground(Color.black);
                Vpassword();
            }
            if(String.valueOf(viewLogin.pfPassword.getPassword()).isEmpty()){
                viewLogin.pfPassword.setText("Contraseña");
                viewLogin.pfPassword.setForeground(new Color(102, 102, 102));
                Vpassword();
            }
            
        }
        if(viewLogin.pfPassword == e.getSource()){
            
            if(String.valueOf(viewLogin.pfPassword.getPassword()).equals("Contraseña")){
                viewLogin.pfPassword.setText("");
                viewLogin.pfPassword.setForeground(Color.black);
                Vpassword();
            }
            if(viewLogin.txtNomUsuario.getText().isEmpty()){
                viewLogin.txtNomUsuario.setText("Usuario");
                viewLogin.txtNomUsuario.setForeground(new Color(102, 102, 102));
                Vpassword();
            }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(viewLogin.jlbIco3 == e.getSource()){
            
            bandera = !bandera;
            
            if(bandera){
                viewLogin.jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeOFF.png")));
                Vpassword();
            }
            else{
                viewLogin.jlbIco3.setIcon(new ImageIcon(getClass().getResource("/icons/eyeON.png")));
                Vpassword();
            }
        }
    }
    
    public void Vpassword(){ //Metodo para la visualisación de la contraseña
       
        if ((String.valueOf(viewLogin.pfPassword.getPassword()).isEmpty()) && (bandera == true)){
           viewLogin.pfPassword.setEchoChar('\u2022');
        }else if((String.valueOf(viewLogin.pfPassword.getPassword()).isEmpty()) && (bandera == false)){
                viewLogin.pfPassword.setEchoChar((char) 0);
            }else if(String.valueOf(viewLogin.pfPassword.getPassword()).equals("Contraseña")){
                    viewLogin.pfPassword.setEchoChar((char) 0);
                }else if(bandera == true){
                        viewLogin.pfPassword.setEchoChar('\u2022');
                    }else{
                            viewLogin.pfPassword.setEchoChar((char) 0);
                        }
                    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(viewLogin.bEntrar == e.getSource()){
            try {
                controlRegistro.iniciarVistaRegistro();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewLogin.dispose();
        }
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
