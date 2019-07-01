package br.com.clinica.domain.tables;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.Plantao;
import br.com.clinica.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class PlantaoTable extends TableTemplate<Pessoa> {

    private List<Pessoa> pessoa;

    @Override
    public void clearTable() {
        pessoa = new ArrayList();
        this.fireTableDataChanged();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Nome", "Data Nacimento", "Telefone", "Identificador", "Função"};
        private static final int NOME = 0;
        private static final int NASCIMENTO = 1;
        private static final int TELEFONE = 2;
        private static final int IDENTIFICADOR = 3;
        private static final int FUNCAO = 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String funcao = "";
        String identificador = "";
        String horarioPlantao = "";
        if (pessoa.get(rowIndex) instanceof Medico) {
            funcao = "Médico";
            Medico m = (Medico) pessoa.get(rowIndex);
            identificador = m.getCrm();
            horarioPlantao = Utils.dateHoraToString(m.getPlantaos().get(0).getData());
        }
        if (pessoa.get(rowIndex) instanceof Enfermeiro) {
            funcao = "Enfermeiro";
            identificador = ((Enfermeiro) pessoa.get(rowIndex)).getCorenCofen();
        }
        switch (columnIndex) {
            case Constantes.NOME:
                return pessoa.get(rowIndex).getNome();
            case Constantes.NASCIMENTO:
                return Utils.dateToString(pessoa.get(rowIndex).getDataNascimento());
            case Constantes.TELEFONE:
                return pessoa.get(rowIndex).getTelefone();
            case Constantes.IDENTIFICADOR:
                return identificador;
            case Constantes.FUNCAO:
                return funcao;
            default:
                return null;
        }
    }

    @Override
    public Pessoa getRow(int row) {
        return row >= 0 ? pessoa.get(row) : null;
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    @Override
    public void addRow(Pessoa obj) {
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
    public void updateRow(Pessoa obj, int row) {
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
