/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.AtendenteDaoImp;
import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.tables.FuncionarioTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.view.FuncionarioCRUDDialog;
import br.com.clinica.view.FuncionariosInternalFrame;
import javax.swing.JFrame;

/**
 *
 * @author Henrique Baron
 */
public class FuncionariosControl {

    private final JFrame frame;
    private FuncionariosInternalFrame iFrame;
    private int rowTable;
    private FuncionarioTable funcionarioTable;
    private Atendente atendente;
    private Medico medico;
    private Enfermeiro enfermeiro;
    private int flag;

    public FuncionariosControl(FuncionariosInternalFrame iFrame, JFrame pai) {
        this.frame = pai;
        this.iFrame = iFrame;
        loadTables();
    }

    public void adicionarNovoAction() {
        if (iFrame.groupB.getSelection() != null) {
            cadastrar();
        } else {
            SendMessenger.error("Selecione o tipo de Funcionario que Cadastrar");
        }
    }

    public void selectRadioButton() {
        if (iFrame.rbEnfermeira.isSelected()) {
            flag = 1;
        }
        if (iFrame.rbMedico.isSelected()) {
            flag = 2;
        }
        if (iFrame.rbAtendente.isSelected()) {
            flag = 3;
        }
    }

    public void mouseListenerTable() {
        rowTable = iFrame.tabelaFuncionario.getSelectedRow();
        if (rowTable >= 0) {
            iFrame.lblFuncionario.setText(funcionarioTable.getRow(rowTable).getNome());
        }
    }

    public void sendKeysTfListener() {
        loadTablesTermo();
    }

    public void deleteAction() {
        rowTable = iFrame.tabelaFuncionario.getSelectedRow();
        if (rowTable >= 0) {
            delete();
        } else {
            SendMessenger.error("Selecione na tabela quem deseja Excluir");
        }
    }

    public void editAction() {
        rowTable = iFrame.tabelaFuncionario.getSelectedRow();
        if (rowTable >= 0) {
            chamaCRUD(funcionarioTable.getRow(rowTable));
        } else {
            SendMessenger.error("Selecione o Funcionário que deseja Editar!");
        }
    }

    private void chamaCRUD(Pessoa obj) {
        FuncionarioCRUDDialog dlg = new FuncionarioCRUDDialog(frame, true, obj);
        dlg.setVisible(true);
        atendente = null;
        medico = null;
        enfermeiro = null;
        loadTables();
    }

    private void loadTables() {
        funcionarioTable = new FuncionarioTable();
        for (Enfermeiro object : new EnfermeiroDaoImpl().listar()) {
            funcionarioTable.addRow(object);
        }
        for (Medico object : new MedicoDaoImpl().listar()) {
            funcionarioTable.addRow(object);
        }
        for (Atendente object : new AtendenteDaoImp().listar()) {
            funcionarioTable.addRow(object);
        }
        iFrame.tabelaFuncionario.setModel(funcionarioTable);
    }

    private void loadTablesTermo() {
        funcionarioTable.clearTable();
        for (Enfermeiro obj : new EnfermeiroDaoImpl().findPaciente(iFrame.tfPesquisar.getText())) {
            funcionarioTable.addRow(obj);
        }
        for (Medico obj : new MedicoDaoImpl().findPaciente(iFrame.tfPesquisar.getText())) {
            funcionarioTable.addRow(obj);
        }
        for (Atendente obj : new AtendenteDaoImp().findPaciente(iFrame.tfPesquisar.getText())) {
            funcionarioTable.addRow(obj);
        }
    }

    private void delete() {
        switch (flag) {
            case 1:
                enfermeiro = (Enfermeiro) funcionarioTable.getRow(rowTable);
                new EnfermeiroDaoImpl().excluir(enfermeiro);
                break;
            case 2:
                medico = (Medico) funcionarioTable.getRow(rowTable);
                new MedicoDaoImpl().excluir(medico);
                break;
            case 3:
                atendente = (Atendente) funcionarioTable.getRow(rowTable);
                new AtendenteDaoImp().excluir(atendente);
                break;
        }
        funcionarioTable.removeRow(rowTable);
    }

    private void cadastrar() {
        switch (flag) {
            case 1:
                chamaCRUD(new Enfermeiro());
                break;
            case 2:
                chamaCRUD(new Medico());
                break;
            case 3:
                chamaCRUD(new Atendente());
                break;
        }
    }
}
