package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UnsupportedLookAndFeelException;
import models.CredencialBancaria;
import models.CredencialInternet;
import models.CredencialTableModel;
import models.ICredencial;
import models.Usuario;
import repositories.*;
import views.ViewCredencialB;
import views.ViewCredencialP;
import views.ViewLogin;
import views.ViewPrincipal;
import views.ViewTipoCreden;

public class ControlPrincipal extends MouseAdapter implements ActionListener, ItemListener {

	private ViewPrincipal viewPrincipal;

	private final Usuario usuario;
	private final List<ICredencial> credenciales;
	private final CredencialTableModel tableModel;

	public ControlPrincipal(ViewPrincipal viewPrincipal, Usuario usuario) {
		this.viewPrincipal = viewPrincipal;
		this.usuario = usuario;

		credenciales = RepositorioCredencial.getCredenciales(usuario);

		tableModel = new CredencialTableModel(credenciales);
		this.viewPrincipal.jTLista.setModel(tableModel);

		this.viewPrincipal.jTLista.addMouseListener(this);

		this.viewPrincipal.bCredencial.addActionListener(this);
		this.viewPrincipal.bCerrar.addActionListener(this);

		this.viewPrincipal.jcbPlataforma.addItemListener(this);
		this.viewPrincipal.jcbBanco.addItemListener(this);
		this.viewPrincipal.jcbCorreo.addItemListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() != viewPrincipal.jTLista) {
			return;
		}

		var jTabla = viewPrincipal.jTLista;

		if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {

			var index = jTabla.getSelectedRow();

			if (index != -1) {

				var credencial = tableModel.getCredencialAt(index);
				
				// Mostrar credencial
				try {
					if (credencial instanceof CredencialInternet cInternet) {

						ViewCredencialP viewCredencial = new ViewCredencialP();

						ControlCredencial cCredencial = new ControlCredencial(viewCredencial, cInternet, tableModel);
						cCredencial.iniciarVista(viewPrincipal);

					}

					if (credencial instanceof CredencialBancaria cBancaria) {

						ViewCredencialB viewCredencial = new ViewCredencialB();

						ControlCredencial cCredencial = new ControlCredencial(viewCredencial, cBancaria, tableModel);
						cCredencial.iniciarVista(viewPrincipal);

					}
				} catch (Exception ex) {
				}

			}

		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getStateChange() == ItemEvent.DESELECTED) {
			return;
		}

		var cbPlat = viewPrincipal.jcbPlataforma;
		var cbBanco = viewPrincipal.jcbBanco;
		var cbCorreo = viewPrincipal.jcbCorreo;

		var selected = (String) e.getItem();

		if (e.getSource() == cbPlat) {

			if (!selected.equals(cbPlat.getItemAt(0))) {

				cbBanco.setSelectedIndex(0);
				cbCorreo.setSelectedIndex(0);

				var filtered = credenciales.stream()
								.filter(c -> c instanceof CredencialInternet cInternet
								&& cInternet.getNombrePlataforma().equals(selected))
								.toList();

				tableModel.setCredenciales(filtered);

			} else {

				if (cbBanco.getSelectedIndex() == 0
								&& cbCorreo.getSelectedIndex() == 0) {

					tableModel.clear();

				}

			}

		}

		if (e.getSource() == cbBanco) {

			if (!selected.equals(cbBanco.getItemAt(0))) {

				cbPlat.setSelectedIndex(0);
				cbCorreo.setSelectedIndex(0);

				var filtered = credenciales.stream()
								.filter(c -> c instanceof CredencialBancaria cBancaria
								&& cBancaria.getNombreBanco().equals(selected))
								.toList();

				tableModel.setCredenciales(filtered);

			} else {

				if (cbPlat.getSelectedIndex() == 0
								&& cbCorreo.getSelectedIndex() == 0) {

					tableModel.clear();

				}

			}

		}

		if (e.getSource() == cbCorreo) {

			if (!selected.equals(cbCorreo.getItemAt(0))) {

				cbPlat.setSelectedIndex(0);
				cbBanco.setSelectedIndex(0);

				var filtered = credenciales.stream()
								.filter(c -> c instanceof CredencialInternet cInternet
								&& cInternet.getUsuarioWeb().equals(selected))
								.toList();

				tableModel.setCredenciales(filtered);

			} else {

				if (cbPlat.getSelectedIndex() == 0
								&& cbBanco.getSelectedIndex() == 0) {

					tableModel.clear();

				}

			}

		}

	}

	public void iniciarVistaPrincipal() throws UnsupportedLookAndFeelException {

		DefaultComboBoxModel pModel = (DefaultComboBoxModel) viewPrincipal.jcbPlataforma.getModel();
		pModel.addAll(RepositorioCredencial.getPlataformas(usuario));

		DefaultComboBoxModel bModel = (DefaultComboBoxModel) viewPrincipal.jcbBanco.getModel();
		bModel.addAll(RepositorioCredencial.getBancos(usuario));

		DefaultComboBoxModel cModel = (DefaultComboBoxModel) viewPrincipal.jcbCorreo.getModel();
		cModel.addAll(RepositorioCredencial.getuUsuariosWeb(usuario));

		viewPrincipal.setVisible(true);
	}

	public void iniciarVistaSelección() throws UnsupportedLookAndFeelException {

		ViewTipoCreden viewTipoCrede = new ViewTipoCreden();
		viewTipoCrede.setLocationRelativeTo(viewPrincipal);

		ControlTipoCreden cTipoC = new ControlTipoCreden(viewTipoCrede, usuario, tableModel);
		cTipoC.iniciarView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewPrincipal.bCredencial == e.getSource()) {
			try {
				iniciarVistaSelección();
			} catch (UnsupportedLookAndFeelException ex) {
			}
		}
		if (viewPrincipal.bCerrar == e.getSource()) {
			try {

				ViewLogin login = new ViewLogin();
				ControlLogin cLogin = new ControlLogin(login);
				cLogin.iniciarVistaLogin();
				viewPrincipal.dispose();

			} catch (UnsupportedLookAndFeelException ex) {
			}

		}
	}

	public ViewPrincipal getView() {
		return viewPrincipal;
	}

}
