/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewLogin;

/**
 *
 * @author laura
 */
public class ControlLogin{ //implements ActionListener, MouseListener

    private ViewLogin viewLogin;

    public ControlLogin(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
    }
    
    public void iniciarVistaLogin() throws UnsupportedLookAndFeelException{
        viewLogin.setTitle("SecurePass Manager");
        viewLogin.pack();
        viewLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewLogin.setLocation(250, 90);
        viewLogin.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        viewLogin.bEntrar.putClientProperty("JButton.buttonType", "roundRect");
        viewLogin.txtNomUsuario.putClientProperty("JComponent.roundRect", true);
        viewLogin.pfPassword.putClientProperty("JComponent.roundRect", true);
        
        SwingUtilities.updateComponentTreeUI(viewLogin);
        viewLogin.setVisible(true);
    }
    
}
