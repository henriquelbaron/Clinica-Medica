/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.FuncaoDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.domain.Funcao;
import br.com.clinica.domain.Sala;
import br.com.clinica.domain.tables.SalaTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.InternalFrameSala;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Henrique Baron
 */
public class SalaControl {

    private InternalFrameSala iFrame;
    private SalaTable table;
    private Sala sala;
    private int rowTable;

    public SalaControl(InternalFrameSala iFrame) {
        this.iFrame = iFrame;
        loadConfig();
    }

    private void loadConfig() {
        table = new SalaTable();
        for (Sala sala1 : new SalaDaoImpl().listar()) {
            table.addRow(sala1);
        }
        iFrame.tableSala.setModel(table);
        iFrame.cbFuncao.setModel(new DefaultComboBoxModel(new FuncaoDaoImpl().listar().toArray()));
    }

    public void saveAction() {
        String tfSala = iFrame.tfNome.getText();
        if (Validator.stringValidator(tfSala)) {
            if (sala == null) {
                sala = new Sala();
            }
            sala.setNumero(tfSala);
            sala.setDescrição(iFrame.tfDescricao.getText());
            sala.setFuncao((Funcao) iFrame.cbFuncao.getSelectedItem());
            if (sala.getId() == null) {
                salvar();
            } else {
                alterar();
            }
        } else {
            SendMessenger.error("O campo Sala é obrigatorio!");
        }
    }

    private void salvar() {
        if (new SalaDaoImpl().salvar(sala)) {
            table.addRow(sala);
            iFrame.tfDescricao.setText("");
            iFrame.tfNome.setText("");
            SendMessenger.success("Salvo com sucesso!");
            sala = null;
        }
    }

    private void alterar() {
        if (new SalaDaoImpl().editar(sala)) {
            table.updateRow(sala, rowTable);
            iFrame.tfDescricao.setText("");
            iFrame.tfNome.setText("");
            SendMessenger.success("Alterado com sucesso!");
            sala = null;
        }
    }

    public void deleteAction() {
        rowTable = iFrame.tableSala.getSelectedRow();
        if (rowTable >= 0) {
            sala = table.getRow(rowTable);
            if (sala.getId() != null) {
                new SalaDaoImpl().excluir(sala);
            }
            table.removeRow(rowTable);
        }
    }

    public void editAction() {
        rowTable = iFrame.tableSala.getSelectedRow();
        if (rowTable >= 0) {
            sala = table.getRow(rowTable);
            iFrame.tfDescricao.setText(sala.getDescrição());
            iFrame.tfNome.setText(sala.getNumero());
            iFrame.cbFuncao.setSelectedItem(sala.getFuncao());
        }
    }
}
