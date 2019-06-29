package br.com.clinica.domain.tables;

import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.Plantao;
import java.util.ArrayList;
import java.util.List;

public class PessoaTable extends TableTemplate<Plantao> {

    private List<Medico> medicos;

    private List<Enfermeiro> enfermeiros;

    private List<Plantao> plantaos;

    public PessoaTable() {
        plantaos = new ArrayList();
    }

    public PessoaTable(List<Plantao> plantaos) {
        this.plantaos = plantaos;
    }

    @Override
    public void clearTable() {
        plantaos = new ArrayList();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Nome", "Especialidade", "Data"};
        private static final int NOME = 0;
        private static final int ESPECIALIDADE = 1;
        private static final int DATA = 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
//            case Constantes.NOME:
//                return plantaos.get(rowIndex).getNome();
//            case Constantes.NASCIMENTO:
//                return plantaos.get(rowIndex).getDataNascimento();
//            case Constantes.SEXO:
//                return plantaos.get(rowIndex).getSexo();
//            case Constantes.TELEFONE:
//                return plantaos.get(rowIndex).getTelefones().get(0);
//            case Constantes.CPF:
//                return plantaos.get(rowIndex).getCpf();
            default:
                return null;
        }
    }

    private Object getMedico(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {
//            case Constantes.NOME:
//                return plantaos.get(rowIndex).getMedicos()();
//            case Constantes.ESPECIALIDADE:
//                return plantaos.get(rowIndex).getEspecialidade();
//            case Constantes.DATA:
//                return plantaos.get(rowIndex).getPlantaos().get(rowIndex);
//            case Constantes.TELEFONE:
//                return plantaos.get(rowIndex).getTelefones().get(0);
//            case Constantes.CPF:
//                return plantaos.get(rowIndex).getCpf();
            default:
                return null;
        }
    }

    @Override
    public Plantao getRow(int row) {
        return row >= 0 ? plantaos.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Plantao obj) {
        plantaos.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        plantaos.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Plantao obj, int row) {
        plantaos.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return plantaos.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }
}
