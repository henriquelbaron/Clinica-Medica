package br.com.clinica.domain.tables;

import br.com.clinica.domain.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteTable extends TableTemplate<Paciente> {

    private List<Paciente> pacientes;

    public PacienteTable() {
        pacientes = new ArrayList();
    }

    public PacienteTable(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public void clearTable() {
        pacientes = new ArrayList();
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
                return pacientes.get(rowIndex).getNome();
            case Constantes.NASCIMENTO:
                return pacientes.get(rowIndex).getDataNascimento();
            case Constantes.SEXO:
                return pacientes.get(rowIndex).getSexo();
            case Constantes.TELEFONE:
                return pacientes.get(rowIndex).getTelefone();
            case Constantes.CPF:
                return pacientes.get(rowIndex).getCpf();
            default:
                return null;
        }
    }

    @Override
    public Paciente getRow(int row) {
        return row >= 0 ? pacientes.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Paciente obj) {
        pacientes.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        pacientes.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Paciente obj, int row) {
        pacientes.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

}
