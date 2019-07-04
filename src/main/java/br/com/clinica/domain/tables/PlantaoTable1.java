package br.com.clinica.domain.tables;

import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import br.com.clinica.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class PlantaoTable1 extends TableTemplate<Plantao> {

    private List<Plantao> pessoa;

    @Override
    public void clearTable() {
        pessoa = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Nome", "Data Nacimento", "Telefone", "Identificador", "Função", "Dia"};
        private static final int NOME = 0;
        private static final int NASCIMENTO = 1;
        private static final int TELEFONE = 2;
        private static final int IDENTIFICADOR = 3;
        private static final int FUNCAO = 4;
        private static final int DIA = 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String funcao = "";
        String identificador = "";
        String horarioPlantao = "";
//        switch (columnIndex) {
//            case Constantes.NOME:
//                return pessoa.get(rowIndex).getNome();
//            case Constantes.NASCIMENTO:
//                return Utils.dateToString(pessoa.get(rowIndex).getDataNascimento());
//            case Constantes.TELEFONE:
//                return pessoa.get(rowIndex).getTelefone();
//            case Constantes.IDENTIFICADOR:
//                return identificador;
//            case Constantes.FUNCAO:
//                return funcao;
//            case Constantes.DIA:
//                return funcao;
//            default:
//                return null;
//        }
        return null;
    }

    @Override
    public Plantao getRow(int row) {
        return row >= 0 ? pessoa.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Plantao obj) {
        pessoa.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        pessoa.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Plantao obj, int row) {
        pessoa.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return pessoa.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

}
