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
import views.ViewCredencialB;
import views.ViewCredencialP;

/**
 *
 * @author laura
 */
public class ControlCredencial {
    
    private ViewCredencialP viewCredencialP;
    private ControlPrincipal controlPrincipal;
    private ViewCredencialB viewCredencialB;

    public ControlCredencial(ViewCredencialP viewCredencialP, ControlPrincipal controlPrincipal, ViewCredencialB viewCredencialB) {
        this.viewCredencialP = viewCredencialP;
        this.controlPrincipal = controlPrincipal;
        this.viewCredencialB = viewCredencialB;
    }

    public void iniciarVistaCredencialP() throws UnsupportedLookAndFeelException{
        viewCredencialP.setTitle("SecurePass Manager");
        viewCredencialP.pack();
        viewCredencialP.setLocation(250, 90);
        viewCredencialP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCredencialP.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        SwingUtilities.updateComponentTreeUI(viewCredencialP);
        viewCredencialP.setVisible(true);
    }
    
    public void iniciarVistaCredencialB() throws UnsupportedLookAndFeelException{
        viewCredencialB.setTitle("SecurePass Manager");
        viewCredencialB.pack();
        viewCredencialB.setLocation(250, 90);
        viewCredencialB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCredencialB.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        SwingUtilities.updateComponentTreeUI(viewCredencialB);
        viewCredencialB.setVisible(true);
    }
    
}
