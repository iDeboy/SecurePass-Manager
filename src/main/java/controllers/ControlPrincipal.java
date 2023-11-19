/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

    public ControlPrincipal(ViewPrincipal viewPrincipal, ControlLogin controlLogin, ControlRegistro controlRegistro,ViewTipoCreden viewTipoCrede) {
        this.viewPrincipal = viewPrincipal;
        this.controlLogin = controlLogin;
        this.controlRegistro = controlRegistro;
        this.viewTipoCrede = viewTipoCrede;
        this.viewLogin = viewLogin;
        
        this.viewPrincipal.bCredencial.addActionListener(this);
        this.viewPrincipal.bCerrar.addActionListener(this);
    }

    public void iniciarVistaPrincipal() throws UnsupportedLookAndFeelException{
        viewPrincipal.setTitle("SecurePass Manager");
        viewPrincipal.pack();
        viewPrincipal.setLocation(250, 90);
        viewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPrincipal.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        viewPrincipal.txtBuscar.putClientProperty("JComponent.roundRect", true);
        
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
        viewTipoCrede.setLocation(250, 90);
        viewTipoCrede.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewTipoCrede.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        UIManager.put( "Component.arrowType", "triangle" );
        
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
            viewPrincipal.dispose();
        }
    }
    
    
}
