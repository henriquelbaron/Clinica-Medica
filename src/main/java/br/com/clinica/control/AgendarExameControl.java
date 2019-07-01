/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.ExameDaoImpl;
import br.com.clinica.dao.banco.impl.ExamePacienteDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Exame;
import br.com.clinica.domain.ExamePaciente;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sala;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.util.Utils;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.AgendamentoExamesDialog;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Henrique Baron
 */
public class AgendarExameControl {

    private final AgendamentoExamesDialog dlg;
    private final Paciente paciente;
    private ExamePaciente examePaciente;
    private DefaultComboBoxModel cbModel;

    public AgendarExameControl(AgendamentoExamesDialog aThis, Paciente p) {
        this.dlg = aThis;
        this.paciente = p;
        loadConfig();
    }

    private void loadConfig() {
        dlg.lblAtendente.setText(UserLogado.getATENDENTE().getNome());
        dlg.lblPaciente.setText(paciente.getNome());
        cbModel = new DefaultComboBoxModel();
        for (Medico medico : new MedicoDaoImpl().listar()) {
            cbModel.addElement(medico);
        }
        for (Enfermeiro enfermeiro : new EnfermeiroDaoImpl().listar()) {
            cbModel.addElement(enfermeiro);
        }
        dlg.cbResponsavel.setModel(cbModel);
        dlg.cbSala.setModel(new DefaultComboBoxModel(new SalaDaoImpl().listar().toArray()));
        dlg.cbExame.setModel(new DefaultComboBoxModel(new ExameDaoImpl().listar().toArray()));

    }

    public void confirmarExameAction() {
        if (Validator.stringValidator(dlg.tfHora.getText())) {
            examePaciente = new ExamePaciente();
            examePaciente.setAtendente(UserLogado.getATENDENTE());
            if (dlg.cbResponsavel.getSelectedItem() instanceof Medico) {
                examePaciente.setMedico((Medico) dlg.cbResponsavel.getSelectedItem());
            }
            if (dlg.cbResponsavel.getSelectedItem() instanceof Enfermeiro) {
                examePaciente.setEnfermeiro((Enfermeiro) dlg.cbResponsavel.getSelectedItem());
            }
            examePaciente.setSala((Sala) dlg.cbSala.getSelectedItem());
            examePaciente.setExame((Exame) dlg.cbExame.getSelectedItem());
            examePaciente.setDataAgendamento(new Date(System.currentTimeMillis()));
            examePaciente.setData(Utils.stringToDate(dlg.tfData.getDate(), dlg.tfHora.getText()));
            examePaciente.setPaciente(paciente);
            if (new ExamePacienteDaoImpl().salvar(examePaciente)) {
                SendMessenger.success("Exame Agendada Com Sucesso!");
                close();
            } else {
                SendMessenger.error("Erro ao salvar!");
            }
        } else {
            SendMessenger.error("Complete os campos Corretamente!");
        }
    }

    public void cancelarExameAction() {
        close();
    }

    private void close() {
        dlg.dispose();
    }

}
