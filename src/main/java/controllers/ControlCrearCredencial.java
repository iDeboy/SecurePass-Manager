/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewCrearCredencialB;
import views.ViewCrearCredencialP;
import views.ViewTipoCreden;

/**
 *
 * @author laura
 */
public class ControlCrearCredencial implements ActionListener{
    
    private ViewCrearCredencialP viewCrearCredencialP;
    private ViewCrearCredencialB viewCrearCredencialB;
    private ControlPrincipal controlPrincipal;
    private ControlLogin controlLogin;
    private ViewTipoCreden viewTipoCrede;

    public ControlCrearCredencial(ViewCrearCredencialP viewCrearCredencialP,ControlPrincipal controlPrincipal,ViewCrearCredencialB viewCrearCredencialB,ControlLogin controlLogin,ViewTipoCreden viewTipoCrede) {
        this.viewCrearCredencialP = viewCrearCredencialP;
        this.viewCrearCredencialB = viewCrearCredencialB;
        this.controlPrincipal = controlPrincipal;
        this.controlLogin = controlLogin;
        this.viewTipoCrede = viewTipoCrede;
        
        this.viewCrearCredencialB.bCredencial.addActionListener(this);
        this.viewCrearCredencialB.bCerrar.addActionListener(this);
        this.viewCrearCredencialB.bRegresar.addActionListener(this);
        
        this.viewCrearCredencialP.bCredencial.addActionListener(this);
        this.viewCrearCredencialP.bCerrar.addActionListener(this);
        this.viewCrearCredencialP.bRegresar.addActionListener(this);
    }
    
    public void iniciarVistaCrearP() throws UnsupportedLookAndFeelException{
        viewCrearCredencialP.setTitle("SecurePass Manager");
        viewCrearCredencialP.pack();
        viewCrearCredencialP.setLocationRelativeTo(null);
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
        viewCrearCredencialB.setLocationRelativeTo(null);
        viewCrearCredencialB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCrearCredencialB.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        UIManager.put( "TextComponent.arc", 999 );
        
        SwingUtilities.updateComponentTreeUI(viewCrearCredencialB);
        viewCrearCredencialB.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /**
	 * Componentes de la clase ViewCrearCredencialP
         * 
         * ViewCrearCredencialP es la vista para crear nuevas credenciales por plataforma.
	 */
        if(viewCrearCredencialP.bCredencial == e.getSource()){
            try {
                controlPrincipal.iniciarVistaSelección();
            } catch (UnsupportedLookAndFeelException ex) {}
        }
        if(viewCrearCredencialP.bCerrar == e.getSource()){
            try {
                controlLogin.iniciarVistaLogin();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewCrearCredencialP);
            viewCrearCredencialP.dispose();
            viewTipoCrede.dispose();
        }
        if(viewCrearCredencialP.bRegresar == e.getSource()){
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewCrearCredencialP);
            viewCrearCredencialP.dispose();
            viewTipoCrede.dispose();
        }
        if(viewCrearCredencialP.bGuardar == e.getSource()){
            controlLogin.limpiarTextFields(viewCrearCredencialP); //Consulta para guardar credenciales por plataforma, luego se limpian los TextField si sale todo bien.
        }
        
        
        /**
	 * Componentes de la clase ViewCrearCredencialB
         * 
         * ViewCrearCredencialB es la vista para crear nuevas credenciales por banco.
	 */
        if(viewCrearCredencialB.bCredencial == e.getSource()){
            try {
                controlPrincipal.iniciarVistaSelección();
            } catch (UnsupportedLookAndFeelException ex) {}
        }
        if(viewCrearCredencialB.bCerrar == e.getSource()){
            try {
                controlLogin.iniciarVistaLogin();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewCrearCredencialB);
            viewCrearCredencialB.dispose();
            viewTipoCrede.dispose();
        }
        if(viewCrearCredencialB.bRegresar == e.getSource()){
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewCrearCredencialB);
            viewCrearCredencialB.dispose();
            viewTipoCrede.dispose();
        }
        if(viewCrearCredencialB.bGuardar == e.getSource()){
            controlLogin.limpiarTextFields(viewCrearCredencialB); //Consulta para guardar credenciales por banco, luego se limpian los TextField si sale todo bien.
        }
        
    }
    
}
