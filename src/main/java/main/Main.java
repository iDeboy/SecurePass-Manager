package main;

import controllers.ControlCrearCredencial;
import controllers.ControlCredencial;
import views.ViewLogin;
import controllers.ControlLogin;
import controllers.ControlRegistro;
import javax.swing.UnsupportedLookAndFeelException;
import views.ViewPrincipal;
import views.ViewRegistro;
import controllers.ControlPrincipal;
import views.ViewCrearCredencialB;
import views.ViewCrearCredencialP;
import views.ViewCredencialB;
import views.ViewCredencialP;
import views.ViewTipoCreden;

public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {

		ControlLogin controlLogin = new ControlLogin(new ViewLogin());
		controlLogin.iniciarVistaLogin();

//        ViewLogin viewLogin = new ViewLogin();
//        ViewTipoCreden viewTipoCreden = new ViewTipoCreden();
//        ViewPrincipal viewPrincipal = new ViewPrincipal();
//        ViewRegistro viewRegistro = new ViewRegistro();
////        ViewCredencialP viewCredencialP  = new ViewCredencialP();
////        ViewCredencialB viewCredencialB = new ViewCredencialB();
//        ViewCrearCredencialP viewCrearP = new ViewCrearCredencialP();
//        ViewCrearCredencialB viewCrearB = new ViewCrearCredencialB();
//
//        ControlLogin controlLogin = new ControlLogin(viewLogin, null,null);
//        ControlRegistro controlRegistro = new ControlRegistro(viewRegistro, controlLogin,null);
//        ControlPrincipal controlPrincipal = new ControlPrincipal(viewPrincipal,controlLogin,controlRegistro,viewTipoCreden,null,viewCrearP,viewCrearB);
//        ControlCrearCredencial controlCrearCredencial = new ControlCrearCredencial(viewCrearP,controlPrincipal,viewCrearB,controlLogin,viewTipoCreden);
////        ControlCredencial controlCredencial = new ControlCredencial(viewCredencialP,controlPrincipal,viewCredencialB);
//        
//        controlLogin.setControlRegistro(controlRegistro);
//        controlLogin.setControlPrincipal(controlPrincipal);
//        controlRegistro.setControlPrincipal(controlPrincipal);
////        controlPrincipal.setControlCrearCred(controlCrearCredencial);
//        
//        controlLogin.iniciarVistaLogin();
	}

}
