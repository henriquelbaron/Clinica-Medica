package br.com.clinica.domain.tables;

import br.com.clinica.domain.Sala;
import br.com.clinica.domain.Sala;
import java.util.ArrayList;
import java.util.List;

public class SalaTable extends TableTemplate<Sala> {

    private List<Sala> salas;

    public SalaTable() {
        salas = new ArrayList();
    }

    public SalaTable(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public void clearTable() {
        salas = new ArrayList();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Nome", "Descrição", "Função", "Prioridade"};
        private static final int SALA = 0;
        private static final int DESCRICAO = 1;
        private static final int FUNCAO = 2;
        private static final int PRIORIDADE = 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case Constantes.SALA:
                return salas.get(rowIndex).getNumero();
            case Constantes.DESCRICAO:
                return salas.get(rowIndex).getDescrição();
            case Constantes.FUNCAO:
                return salas.get(rowIndex).getFuncao();
            case Constantes.PRIORIDADE:
                return salas.get(rowIndex).getPrioridade();
            default:
                return null;
        }
    }

    @Override
    public Sala getRow(int row) {
        return row >= 0 ? salas.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Sala obj) {
        salas.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        salas.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Sala obj, int row) {
        salas.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return salas.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

}
