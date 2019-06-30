/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.PacienteDaoImpl;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.tables.PacienteTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.view.AgendamentoConsultaDialog;
import br.com.clinica.view.AgendamentoExamesDialog;
import br.com.clinica.view.AgendamentoVacinaDialog;
import br.com.clinica.view.PacienteCRUDDialog;
import br.com.clinica.view.PacientesInternalFrame;
import javax.swing.JFrame;

/**
 *
 * @author Henrique Baron
 */
public class PacienteControl {

    private PacientesInternalFrame iFrame;
    private Paciente paciente;
    private int rowTable;
    private PacienteTable table;
    private JFrame frame;

    public PacienteControl(PacientesInternalFrame aThis, JFrame frame) {
        this.iFrame = aThis;
        this.frame = frame;
        loadConfig();
    }

    public void mouseListenerTable() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            iFrame.lblPaciente.setText(paciente.getNome());
        }
    }

    public void sendKeysTfListener() {
        table.clearTable();
        for (Paciente paciente : new PacienteDaoImpl().findPaciente(iFrame.tfPesquisar.getText())) {
            table.addRow(paciente);
        }
    }

    public void deleteAction() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            if (paciente.getId() != null) {
                new PacienteDaoImpl().excluir(paciente);
            }
            table.removeRow(rowTable);
        }
    }

    public void editAction() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            chamaTelaCadastro(paciente);
        } else {
            SendMessenger.error("Selecione o Paciente que deseja Editar!");
        }
    }

    public void chamaTelaCadastro() {
        chamaTelaCadastro(null);
    }

    public void chamaAgendamentoConsultaAction() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            AgendamentoConsultaDialog dlg = new AgendamentoConsultaDialog(frame, true, paciente);
            dlg.setVisible(true);
        } else {
            SendMessenger.error("Selecione o Paciente que deseja Marcar Consulta!");
        }
    }

    private void chamaTelaCadastro(Paciente p) {
        PacienteCRUDDialog dlg = new PacienteCRUDDialog(frame, true, p);
        dlg.setVisible(true);
        paciente = null;
        refreshTable();
    }

    public void chamaAgendamentoExameAction() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            AgendamentoExamesDialog dlg = new AgendamentoExamesDialog(frame, true, paciente);
            dlg.setVisible(true);
        } else {
            SendMessenger.error("Selecione o Paciente que deseja Marcar Exame!");
        }
    }

    public void chamaAgendamentoVacinaAction() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            AgendamentoVacinaDialog dlg = new AgendamentoVacinaDialog(frame, true, paciente);
            dlg.setVisible(true);
        } else {
            SendMessenger.error("Selecione o Paciente que deseja Marcar Vacina!");
        }
    }

    private void refreshTable() {
        for (Paciente paciente1 : new PacienteDaoImpl().listar()) {
            table.addRow(paciente1);
        }
    }

    private void loadConfig() {
        table = new PacienteTable();
        refreshTable();
        iFrame.tabelaPaciente.setModel(table);
    }

}
