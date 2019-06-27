/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.EspecialidadeDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.banco.impl.PacienteDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Especialidade;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sala;
import br.com.clinica.domain.tables.PacienteTable;
import br.com.clinica.view.InternalFrameAgendamentoConsultas;
import br.com.clinica.view.TelaPrincipal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author henrique
 */
public class ConsultaControl {

    private InternalFrameAgendamentoConsultas iFrame;
    private TelaPrincipal frame;
    private Paciente paciente;
    private Consulta consulta;
    private List<Medico> medicos;
    private List<Sala> salas;
    private List<Especialidade> especialidades;
    private PacienteTable table;
    private Integer rowTable;

    public ConsultaControl(InternalFrameAgendamentoConsultas frame) {
        this.iFrame = frame;
        loadConfig();
    }

    private void loadConfig() {
        table = new PacienteTable();
        for (Paciente paciente1 : new PacienteDaoImpl().listar()) {
            table.addRow(paciente1);
        }
        iFrame.tabelaPaciente.setModel(table);
        iFrame.cbMedico.setModel(new DefaultComboBoxModel(new MedicoDaoImpl().listar().toArray()));
        iFrame.cbSala.setModel(new DefaultComboBoxModel(new SalaDaoImpl().listar().toArray()));
        iFrame.cbEspecialidade.setModel(new DefaultComboBoxModel(new EspecialidadeDaoImpl().listar().toArray()));

    }

    public void sendKeysTfListener() {
        table.clearTable();
        PacienteDaoImpl dao = new PacienteDaoImpl();
        for (Paciente paciente : dao.findPaciente(iFrame.tfPesquisar.getText())) {
            table.addRow(paciente);
        }
    }

    public void mouseListenerTable() {
        rowTable = iFrame.tabelaPaciente.getSelectedRow();
        if (rowTable >= 0) {
            paciente = table.getRow(rowTable);
            iFrame.lblPaciente.setText(paciente.getNome());
        }
    }

    public void addPacienteAction() {
        
    }

    public void confirmarConsultaAction() {
        
    }

    public void cancelarConsultaAction() {

    }
}
