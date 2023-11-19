package main;

import views.ViewLogin;
import controllers.ControlLogin;
import controllers.ControlRegistro;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewRegistro;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        
        ControlRegistro controlRegistro = new ControlRegistro(new ViewRegistro());
        ControlLogin controlLogin = new ControlLogin(new ViewLogin(), controlRegistro);
        
        controlLogin.iniciarVistaLogin();
        
    }

}
