package main;

import views.ViewLogin;
import controllers.ControlLogin;

public class Main {

    public static void main(String[] args) {
        
        ViewLogin viewLogin = new  ViewLogin();
        
        ControlLogin controlLogin = new ControlLogin(viewLogin);
        controlLogin.iniciarVistaLogin();
        
    }

}
