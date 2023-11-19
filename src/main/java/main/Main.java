package main;

import views.ViewLogin;
import controllers.ControlLogin;
import controllers.ControlRegistro;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewPrincipal;
import views.ViewRegistro;
import controllers.ControlPrincipal;
import views.ViewTipoCreden;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        
        ViewLogin viewLogin = new ViewLogin();
        ViewTipoCreden viewTipoCreden = new ViewTipoCreden();
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        ViewRegistro viewRegistro = new ViewRegistro();
        
        ControlLogin controlLogin = new ControlLogin(viewLogin, null,null);
        ControlRegistro controlRegistro = new ControlRegistro(viewRegistro, controlLogin,null);
        ControlPrincipal controlPrincipal = new ControlPrincipal(viewPrincipal,controlLogin,controlRegistro,viewTipoCreden);
        
        controlLogin.setControlRegistro(controlRegistro);
        controlLogin.setControlPrincipal(controlPrincipal);
        controlRegistro.setControlPrincipal(controlPrincipal);
        
        controlLogin.iniciarVistaLogin();
        
    }

}
