package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CredencialTableModel extends AbstractTableModel {

	private final List<ICredencial> originalCredencial;
	private final String[] columnNames = {"Lugar", "Correo"};
	private List<ICredencial> credenciales;

	public CredencialTableModel(List<ICredencial> credenciales) {
		originalCredencial = credenciales;
		this.credenciales = credenciales;
	}

	@Override
	public int getRowCount() {
		return credenciales.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		var credencial = credenciales.get(rowIndex);
		return credencial.show()[columnIndex];
	}

	public void setCredenciales(List<ICredencial> credenciales) {
		this.credenciales = credenciales;
		this.fireTableDataChanged();
	}

	public void clear() {
		this.credenciales = originalCredencial;
		this.fireTableDataChanged();
	}

	public List<ICredencial> getOriginal() {
		return originalCredencial;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// Hacer que todas las celdas sean no editables
		return false;
	}

	public ICredencial getCredencialAt(int rowIndex) {

		if (rowIndex >= 0 && rowIndex < credenciales.size()) {

			var localCredencial = credenciales.get(rowIndex);

			return originalCredencial.stream()
							.filter(originalCredential
											-> originalCredential.getClass().equals(localCredencial.getClass())
							&& originalCredential.getId() == localCredencial.getId())
							.findFirst()
							.orElse(null);
		}

		return null;
	}

}
