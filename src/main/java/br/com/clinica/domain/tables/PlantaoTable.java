package br.com.clinica.domain.tables;

import br.com.clinica.domain.PlantaoEnfermeiro;
import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class PlantaoTable extends TableTemplate<Object> {

    private List<Object> plantaos;
    private PlantaoMedico pm;
    private PlantaoEnfermeiro pe;
    private String nome;
    private String identificar;
    private String data;
    private String funcao;

    public PlantaoTable() {
        plantaos = new ArrayList();
    }

    @Override
    public void clearTable() {
        plantaos = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Nome", "Data", "Identificador", "Função"};
        private static final int NOME = 0;
        private static final int DATA = 1;
        private static final int IDENTIFICADOR = 2;
        private static final int FUNCAO = 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (plantaos.get(rowIndex) instanceof PlantaoMedico) {
            pm = (PlantaoMedico) plantaos.get(rowIndex);
            nome = pm.getMedico().getNome();
            identificar = pm.getMedico().getCrm();
            data = Utils.dateHoraToString(pm.getPlantao().getData());
            funcao = "Médico";
        }
        if (plantaos.get(rowIndex) instanceof PlantaoEnfermeiro) {
            pe = (PlantaoEnfermeiro) plantaos.get(rowIndex);
            nome = pe.getEnfermeiro().getNome();
            identificar = pe.getEnfermeiro().getCorenCofen();
            data = Utils.dateHoraToString(pe.getPlantao().getData());
            funcao = "Enfermeiro";
        }
        switch (columnIndex) {
            case Constantes.NOME:
                return nome;
            case Constantes.FUNCAO:
                return funcao;
            case Constantes.IDENTIFICADOR:
                return identificar;
            case Constantes.DATA:
                return data;
            default:
                return null;
        }
    }

    @Override
    public Object getRow(int row) {
        return row >= 0 ? plantaos.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Object obj) {
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
    public void updateRow(Object obj, int row) {
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
