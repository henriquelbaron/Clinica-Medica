package br.com.clinica.domain.tables;

import br.com.clinica.domain.Telefone;
import java.util.ArrayList;
import java.util.List;

public class TelefoneTable extends TableTemplate<Telefone> {

    private List<Telefone> telefones;

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public TelefoneTable() {
        telefones = new ArrayList();
    }

    public TelefoneTable(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public void clearTable() {
        telefones = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Número", "Tipo", "Emergência"};
        private static final int NUMERO = 0;
        private static final int TIPO = 1;
        private static final int EMERGENCIA = 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case Constantes.NUMERO:
                return telefones.get(rowIndex).getNumero();
            case Constantes.TIPO:
                return telefones.get(rowIndex).getTipo();
            case Constantes.EMERGENCIA:
                return telefones.get(rowIndex).isEmergencia() ? "Sim" : "Não";
            default:
                return null;
        }
    }

    @Override
    public Telefone getRow(int row) {
        return row >= 0 ? telefones.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Telefone obj) {
        telefones.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        telefones.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Telefone obj, int row) {
        telefones.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return telefones.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

}
