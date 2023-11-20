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
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewCredencialB;
import views.ViewCredencialP;
import views.ViewTipoCreden;

/**
 *
 * @author laura
 */
public class ControlCredencial implements ActionListener,MouseListener{
    
    private ViewCredencialP viewCredencialP;
    private ControlPrincipal controlPrincipal;
    private ViewCredencialB viewCredencialB;
    private ControlLogin controlLogin;
    private ViewTipoCreden viewTipoCred;

    public ControlCredencial(ViewCredencialP viewCredencialP, ControlPrincipal controlPrincipal, ViewCredencialB viewCredencialB,ControlLogin controlLogin,ViewTipoCreden viewTipoCred) {
        this.viewCredencialP = viewCredencialP;
        this.controlPrincipal = controlPrincipal;
        this.viewCredencialB = viewCredencialB;
        this.controlLogin = controlLogin;
        this.viewTipoCred = viewTipoCred;
        
        this.viewCredencialB.bCredencial.addActionListener(this);
        this.viewCredencialB.bCerrar.addActionListener(this);
        this.viewCredencialB.bPrincipal.addActionListener(this);
        this.viewCredencialB.bEliminar.addActionListener(this);
        this.viewCredencialB.bGuardar.addActionListener(this);
        this.viewCredencialP.bCredencial.addActionListener(this);
        this.viewCredencialP.bCerrar.addActionListener(this);
        this.viewCredencialP.bPrincipal.addActionListener(this);
        this.viewCredencialP.bEliminar.addActionListener(this);
        this.viewCredencialP.bGuardar.addActionListener(this);
    }

    public void iniciarVistaCredencialP() throws UnsupportedLookAndFeelException{
        viewCredencialP.setTitle("SecurePass Manager");
        viewCredencialP.pack();
        viewCredencialP.setLocationRelativeTo(null);
        viewCredencialP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCredencialP.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        SwingUtilities.updateComponentTreeUI(viewCredencialP);
        viewCredencialP.setVisible(true);
    }
    
    public void iniciarVistaCredencialB() throws UnsupportedLookAndFeelException{
        viewCredencialB.setTitle("SecurePass Manager");
        viewCredencialB.pack();
        viewCredencialB.setLocationRelativeTo(null);
        viewCredencialB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewCredencialB.setResizable(false);
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        SwingUtilities.updateComponentTreeUI(viewCredencialB);
        viewCredencialB.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /**
	 * Componentes de la clase ViewCredencialP
         * 
         * ViewCredencialP es la vista de las credenciales por plataforma, es la ventana donde podremos visualizar y editar nuestra credencial.
	 */
        if(viewCredencialP.bCredencial == e.getSource()){
            try {
                controlPrincipal.iniciarVistaSelección();
            } catch (UnsupportedLookAndFeelException ex) {}
        }
        if(viewCredencialP.bCerrar == e.getSource()){
            try {
                controlLogin.iniciarVistaLogin();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewCredencialP.dispose();
            viewTipoCred.dispose();
        }
        if(viewCredencialP.bPrincipal == e.getSource()){
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewCredencialP.dispose();
            viewTipoCred.dispose();
        }
        if(viewCredencialP.bEliminar == e.getSource()){ //Aqui se encontrara la consulta para eliminar una credencial
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewCredencialP.dispose();
            viewTipoCred.dispose();
        }
        if(viewCredencialP.bGuardar == e.getSource()){
            viewCredencialP.txtDatos.setEditable(false); //Pasara a falso si se a guardado correctamente y mostrara el nuevo dato en el JTextField correspondiente
        }
        

        /**
	 * Componentes de la clase ViewCredencialB
         * 
         * ViewCredencialB es la vista de las credenciales por banco, es la ventana donde podremos visualizar y editar nuestra credencial.
	 */
        if(viewCredencialB.bCredencial == e.getSource()){
            try {
                controlPrincipal.iniciarVistaSelección();
            } catch (UnsupportedLookAndFeelException ex) {}
        }
        if(viewCredencialB.bCerrar == e.getSource()){
            try {
                controlLogin.iniciarVistaLogin();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewCredencialB.dispose();
            viewTipoCred.dispose();
        }
        if(viewCredencialB.bPrincipal == e.getSource()){
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewCredencialB.dispose();
            viewTipoCred.dispose();
        }
        if(viewCredencialB.bEliminar == e.getSource()){ //Aqui se encontrara la consulta para eliminar una credencial
            try {
                controlPrincipal.iniciarVistaPrincipal();
            } catch (UnsupportedLookAndFeelException ex) {}
            viewCredencialB.dispose();
            viewTipoCred.dispose();
        }
        if(viewCredencialB.bGuardar == e.getSource()){
            viewCredencialB.txtDatos.setEditable(false); //Pasara a falso si se a guardado correctamente y mostrara el nuevo dato en el JTextField correspondiente
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        /**
	 * Componentes de la clase ViewCredencialB
         * 
         * ViewCredencialB es la vista de las credenciales por banco, es la ventana donde podremos visualizar y editar nuestra credencial.
	 */
        if(viewCredencialB.jlbIco4 == e.getSource()){
            viewCredencialB.txtDatos.setEditable(true);
        }
        if(viewCredencialB.jlbIco1 == e.getSource()){ //cambiar visibilidad en donde los ultimos 3 numeros deben verse y los demas encriptados
            //txtNoTarjeta
        }
        if(viewCredencialB.jlbIco2 == e.getSource()){ //cambiar visibilidad
            //txtCVV
        }
        
        /**
	 * Componentes de la clase ViewCredencialP
         * 
         * ViewCredencialP es la vista de las credenciales por plataforma, es la ventana donde podremos visualizar y editar nuestra credencial.
	 */
        if(viewCredencialP.jlbIco4 == e.getSource()){
            viewCredencialP.txtDatos.setEditable(true);
        }
        if(viewCredencialP.jlbIco1 == e.getSource()){
            viewCredencialP.txtUsuario.setEditable(true);
        }
        if(viewCredencialP.jlbIco2 == e.getSource()){
            viewCredencialP.txtPassword.setEditable(true);
        }
        if(viewCredencialP.jlbIco3 == e.getSource()){ //cambiar visibilidad
            //txtPassword
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
