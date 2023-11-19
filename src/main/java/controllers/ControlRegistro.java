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
import views.ViewRegistro;

/**
 *
 * @author laura
 */
public class ControlRegistro {
    
    private ViewRegistro viewRegistro;
    private ControlLogin controlLogin;
    private boolean bandera = true;

    public ControlRegistro(ViewRegistro viewRegistro, ControlLogin controlLogin) {
        this.viewRegistro = viewRegistro;
        this.controlLogin = controlLogin;
    }

    public ControlRegistro(ViewRegistro viewRegistro) {
        this.viewRegistro = viewRegistro;
    }
    
    public void iniciarVistaRegistro() throws UnsupportedLookAndFeelException{
        viewRegistro.setTitle("SecurePass Manager");
        viewRegistro.pack();
        viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewRegistro.setLocation(250, 90);
        viewRegistro.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        viewRegistro.bEntrar.putClientProperty("JButton.buttonType", "roundRect");
        
        SwingUtilities.updateComponentTreeUI(viewRegistro);
        viewRegistro.setVisible(true);
    }
    
}
