package br.com.clinica.domain.tables;

import br.com.clinica.domain.Exame;
import java.util.ArrayList;
import java.util.List;

public class ExameTable extends TableTemplate<Exame> {

    private List<Exame> exames;

    @Override
    public void clearTable() {
        exames = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Nome", "Data Nacimento", "Sexo", "Telefone", "CPF"};
        private static final int NOME = 0;
        private static final int NASCIMENTO = 1;
        private static final int SEXO = 2;
        private static final int TELEFONE = 3;
        private static final int CPF = 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case Constantes.NOME:
                return exames.get(rowIndex).getNome();
            default:
                return null;
        }
    }

    @Override
    public Exame getRow(int row) {
        return row >= 0 ? exames.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Exame obj) {
        exames.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        exames.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Exame obj, int row) {
        exames.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return exames.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

}
