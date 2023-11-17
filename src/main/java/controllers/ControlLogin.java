/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javax.swing.JFrame;
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
    
    public void iniciarVistaLogin(){
        viewLogin.setTitle("SecurePass Manager");
        viewLogin.pack();
        viewLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewLogin.setLocation(250, 90);
        viewLogin.setVisible(true);
        viewLogin.setResizable(false);
    }
    
}
