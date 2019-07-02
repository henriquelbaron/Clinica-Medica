package br.com.clinica.domain.tables;

import br.com.clinica.domain.Exame;
import br.com.clinica.domain.ExamePaciente;
import java.util.ArrayList;
import java.util.List;

public class ExameTable extends TableTemplate<ExamePaciente> {

    private List<ExamePaciente> exames;

    public ExameTable() {
        exames = new ArrayList();
    }

    @Override
    public void clearTable() {
        exames = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Paciente", "Exame", "Sala", "Responsavel", "Resultado"};
        private static final int PACIENTE = 0;
        private static final int EXAME = 1;
        private static final int SALA = 2;
        private static final int RESPONSAVEL = 3;
        private static final int RESULTADO = 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case Constantes.PACIENTE:
                return exames.get(rowIndex).getPaciente().getNome();
            case Constantes.EXAME:
                return exames.get(rowIndex).getExame().getNome();
            case Constantes.SALA:
                return exames.get(rowIndex).getSala().getNumero();
            case Constantes.RESPONSAVEL:
                return exames.get(rowIndex).getMedico() != null ? exames.get(rowIndex).getMedico().getNome()
                        : exames.get(rowIndex).getEnfermeiro().getNome();
            case Constantes.RESULTADO:
                return exames.get(rowIndex).getResultado() != null ? "Sim" : "Não";
            default:
                return null;
        }
    }

    @Override
    public ExamePaciente getRow(int row) {
        return row >= 0 ? exames.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(ExamePaciente obj) {
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
    public void updateRow(ExamePaciente obj, int row) {
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
