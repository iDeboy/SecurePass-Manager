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
import views.ViewLogin;
import views.ViewPrincipal;
import views.ViewTipoCreden;

/**
 *
 * @author laura
 */
public class ControlPrincipal implements ActionListener{
    
    private ViewPrincipal viewPrincipal;
    private ViewLogin viewLogin;
    private ControlLogin controlLogin;
    private ControlRegistro controlRegistro;
    private ViewTipoCreden viewTipoCrede;
    private ControlCrearCredencial controlCrearCred;
    private ViewCrearCredencialP viewCreaP;
    private ViewCrearCredencialB viewCreaB;

    public ControlPrincipal(ViewPrincipal viewPrincipal, ControlLogin controlLogin, ControlRegistro controlRegistro,ViewTipoCreden viewTipoCrede,ControlCrearCredencial controlCrearCred,ViewCrearCredencialP viewCreaP,ViewCrearCredencialB viewCreaB) {
        this.viewPrincipal = viewPrincipal;
        this.controlLogin = controlLogin;
        this.controlRegistro = controlRegistro;
        this.viewTipoCrede = viewTipoCrede;
        this.controlCrearCred = controlCrearCred;
        this.viewCreaP = viewCreaP;
        this.viewCreaB = viewCreaB;
        
        this.viewPrincipal.bCredencial.addActionListener(this);
        this.viewPrincipal.bCerrar.addActionListener(this);
        this.viewTipoCrede.bPlataforma.addActionListener(this);
        this.viewTipoCrede.bBanco.addActionListener(this);
        this.viewPrincipal.bBuscar.addActionListener(this);
    }

    public void setControlCrearCred(ControlCrearCredencial controlCrearCred) {
        this.controlCrearCred = controlCrearCred;
    }

    public void iniciarVistaPrincipal() throws UnsupportedLookAndFeelException{
        viewPrincipal.setTitle("SecurePass Manager");
        viewPrincipal.pack();
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPrincipal.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        viewPrincipal.jcbBanco.putClientProperty( "Component.arc", 0 );
        viewPrincipal.jcbCorreo.putClientProperty( "Component.arc", 0 );
        viewPrincipal.jcbPlataforma.putClientProperty( "Component.arc", 0 );
        
        UIManager.put( "Component.arrowType", "triangle" );
        
        SwingUtilities.updateComponentTreeUI(viewPrincipal);
        viewPrincipal.setVisible(true);
    }
    
    public void iniciarVistaSelección() throws UnsupportedLookAndFeelException{
        viewTipoCrede.setTitle("SecurePass Manager");
        viewTipoCrede.pack();
        viewTipoCrede.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewTipoCrede.setResizable(false);
        viewTipoCrede.setLocationRelativeTo(viewPrincipal);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        SwingUtilities.updateComponentTreeUI(viewTipoCrede);
        viewTipoCrede.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (viewPrincipal.bCredencial == e.getSource()){
            try {
                iniciarVistaSelección();
            } catch (UnsupportedLookAndFeelException ex) {}
        }
        if (viewPrincipal.bCerrar == e.getSource()){
            try {
                controlLogin.iniciarVistaLogin();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewPrincipal);
            viewPrincipal.dispose();
            viewTipoCrede.dispose();
        }
        if(viewPrincipal.bBuscar == e.getSource()){
            controlLogin.limpiarTextFields(viewPrincipal);
        }
        
        
        if(viewTipoCrede.bPlataforma == e.getSource()){
            try {
                controlCrearCred.iniciarVistaCrearP();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewCreaP);
            controlLogin.limpiarTextFields(viewPrincipal);
            viewCreaB.dispose();
            viewPrincipal.dispose();
            viewTipoCrede.dispose();
        }
        
        if(viewTipoCrede.bBanco == e.getSource()){
            try {
                controlCrearCred.iniciarVistaCrearB();
            } catch (UnsupportedLookAndFeelException ex) {}
            controlLogin.limpiarTextFields(viewCreaB);
            controlLogin.limpiarTextFields(viewPrincipal);
            viewCreaP.dispose();
            viewPrincipal.dispose();
            viewTipoCrede.dispose();
        }
        
    }  
    
}
