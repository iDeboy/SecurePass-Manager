package main;

import views.ViewLogin;
import controllers.ControlLogin;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException{
               
        ViewLogin viewLogin = new  ViewLogin();
        
        ControlLogin controlLogin = new ControlLogin(viewLogin);
        controlLogin.iniciarVistaLogin();
        
    }

}
