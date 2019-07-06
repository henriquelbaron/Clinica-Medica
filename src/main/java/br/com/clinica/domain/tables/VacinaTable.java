/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.domain.tables;

import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.VacinaAplicada;
import br.com.clinica.util.DataUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique Baron
 */
public class VacinaTable extends TableTemplate<VacinaAplicada> {

    private List<VacinaAplicada> vacinaAplicadas;

    public VacinaTable(List<VacinaAplicada> vacinaAplicadas) {
        this.vacinaAplicadas = vacinaAplicadas;
    }

    public VacinaTable() {
        vacinaAplicadas = new ArrayList();
    }

    @Override
    public void clearTable() {
        vacinaAplicadas = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Paciente", "Vacina", "Sala", "Data", "Aplicada"};
        private static final int PACIENTE = 0;
        private static final int VACINA = 1;
        private static final int SALA = 2;
        private static final int DATA = 3;
        private static final int APLICADA = 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case Constantes.PACIENTE:
                return vacinaAplicadas.get(rowIndex).getPaciente().getNome();
            case Constantes.VACINA:
                return vacinaAplicadas.get(rowIndex).getVacina().getNome();
            case Constantes.SALA:
                return vacinaAplicadas.get(rowIndex).getSala().getSala().getNumero();
            case Constantes.DATA:
                return DataUtils.dateToString(vacinaAplicadas.get(rowIndex).getSala().getData());
            case Constantes.APLICADA:
                return vacinaAplicadas.get(rowIndex).isAplicada() ? "Sim" : "Não";
            default:
                return null;
        }
    }

    @Override
    public VacinaAplicada getRow(int row) {
        return row >= 0 ? vacinaAplicadas.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(VacinaAplicada obj) {
        vacinaAplicadas.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public void removeRow(int row) {
        vacinaAplicadas.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public void updateRow(VacinaAplicada obj, int row) {
        vacinaAplicadas.set(row, obj);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return vacinaAplicadas.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }
}
