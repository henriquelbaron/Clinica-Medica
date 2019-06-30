package br.com.clinica.domain.tables;

import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Paciente;
import br.com.clinica.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class ConsultaTable extends TableTemplate<Consulta> {

    private List<Consulta> consultas;

    public ConsultaTable(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public ConsultaTable() {
        consultas = new ArrayList();
    }

    @Override
    public void clearTable() {
        consultas = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Paciente", "Sala", "Data", "Data do Agendamento", "Contato"};
        private static final int PACIENTE = 0;
        private static final int SALA = 1;
        private static final int DATA = 2;
        private static final int AGENDAMENTO = 3;
        private static final int CONTATO = 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente paciente = consultas.get(rowIndex).getPaciente();
        switch (columnIndex) {
            case Constantes.PACIENTE:
                return paciente.getNome();
            case Constantes.SALA:
                return consultas.get(rowIndex).getSala().getNumero();
            case Constantes.DATA:
                return Utils.dateToString(consultas.get(rowIndex).getData());
            case Constantes.AGENDAMENTO:
                return Utils.dateToString(consultas.get(rowIndex).getDataAgendamento());
            case Constantes.CONTATO:
                return paciente.getTelefones().size() > 0 ? paciente.getTelefones().get(0) : "";
            default:
                return null;
        }
    }

    @Override
    public Consulta getRow(int row) {
        return row >= 0 ? consultas.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Consulta obj) {
        consultas.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        consultas.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(Consulta obj, int row) {
        consultas.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return consultas.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }
}
