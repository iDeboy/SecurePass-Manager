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
import views.ViewCrearCredencialB;
import views.ViewCrearCredencialP;

/**
 *
 * @author laura
 */
public class ControlCrearCredencial {
    
    private ViewCrearCredencialP viewCrearCredencialP;
    private ViewCrearCredencialB viewCrearCredencialB;
    private ControlPrincipal controlPrincipal;

    public ControlCrearCredencial(ViewCrearCredencialP viewCrearCredencialP,ControlPrincipal controlPrincipal,ViewCrearCredencialB viewCrearCredencialB) {
        this.viewCrearCredencialP = viewCrearCredencialP;
        this.viewCrearCredencialB = viewCrearCredencialB;
        this.controlPrincipal = controlPrincipal;
    }
    
    public void iniciarVistaCrearP() throws UnsupportedLookAndFeelException{
        viewCrearCredencialP.setTitle("SecurePass Manager");
        viewCrearCredencialP.pack();
        viewCrearCredencialP.setLocation(250, 90);
        viewCrearCredencialP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCrearCredencialP.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        UIManager.put( "TextComponent.arc", 999 );
        
        SwingUtilities.updateComponentTreeUI(viewCrearCredencialP);
        viewCrearCredencialP.setVisible(true);
    }
    
    public void iniciarVistaCrearB() throws UnsupportedLookAndFeelException{
        viewCrearCredencialB.setTitle("SecurePass Manager");
        viewCrearCredencialB.pack();
        viewCrearCredencialB.setLocation(250, 90);
        viewCrearCredencialB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCrearCredencialB.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        UIManager.put( "TextComponent.arc", 999 );
        
        SwingUtilities.updateComponentTreeUI(viewCrearCredencialB);
        viewCrearCredencialB.setVisible(true);
    }
    
}
