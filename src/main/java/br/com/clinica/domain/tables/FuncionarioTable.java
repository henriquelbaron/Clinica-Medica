/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.domain.tables;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.util.DataUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique Baron
 */
public class FuncionarioTable extends TableTemplate<Pessoa> {

    private List<Pessoa> pessoa;

    public FuncionarioTable() {
        pessoa = new ArrayList();
    }

    public FuncionarioTable(List<Pessoa> pessoas) {
        this.pessoa = pessoas;
    }

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
        if (pessoa.get(rowIndex) instanceof Medico) {
            funcao = "Médico";
            identificador = ((Medico) pessoa.get(rowIndex)).getCrm();
        }
        if (pessoa.get(rowIndex) instanceof Enfermeiro) {
            funcao = "Enfermeiro";
            identificador = ((Enfermeiro) pessoa.get(rowIndex)).getCorenCofen();
        }
        if (pessoa.get(rowIndex) instanceof Atendente) {
            funcao = "Atendente";
            identificador = pessoa.get(rowIndex).getCpf();
        }
        switch (columnIndex) {
            case Constantes.NOME:
                return pessoa.get(rowIndex).getNome();
            case Constantes.NASCIMENTO:
                return DataUtils.dateToString(pessoa.get(rowIndex).getDataNascimento());
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
