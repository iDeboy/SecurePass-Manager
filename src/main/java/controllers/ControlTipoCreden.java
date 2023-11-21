package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import models.CredencialTableModel;
import models.ICredencial;
import models.Usuario;
import views.ViewCrearCredencialB;
import views.ViewCrearCredencialP;
import views.ViewTipoCreden;

public class ControlTipoCreden implements ActionListener {

	private final ViewTipoCreden viewTipoCrede;
	private final Usuario usuario;
	private final CredencialTableModel credenciales;

	public ControlTipoCreden(ViewTipoCreden viewTipoCrede, Usuario usuario, CredencialTableModel credenciales) {
		this.viewTipoCrede = viewTipoCrede;
		this.usuario = usuario;
		this.credenciales = credenciales;

		this.viewTipoCrede.bPlataforma.addActionListener(this);
		this.viewTipoCrede.bBanco.addActionListener(this);
	}

	public void iniciarView() {
		viewTipoCrede.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (viewTipoCrede.bPlataforma == e.getSource()) {

			try {
				ControlCrearCredencial cCrearC = new ControlCrearCredencial(new ViewCrearCredencialP(), usuario, credenciales);
				cCrearC.iniciarVistaCrear();

			} catch (UnsupportedLookAndFeelException ex) {

			}

		}

		if (viewTipoCrede.bBanco == e.getSource()) {

			try {
				ControlCrearCredencial cCrearC = new ControlCrearCredencial(new ViewCrearCredencialB(), usuario, credenciales);
				cCrearC.iniciarVistaCrear();

			} catch (UnsupportedLookAndFeelException ex) {

			}
		}

		viewTipoCrede.dispose();

	}

	public ViewTipoCreden getView() {
		return viewTipoCrede;
	}
}
