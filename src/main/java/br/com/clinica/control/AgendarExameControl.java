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
import br.com.clinica.dao.banco.impl.OcupacaoSalaDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Exame;
import br.com.clinica.domain.ExamePaciente;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.OcupacaoSala;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sala;
import br.com.clinica.util.DataUtils;
import br.com.clinica.util.SendMessenger;
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
    private OcupacaoSala ocupacaoSala;

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
        if (verificaOcupacaoSala()) {
            examePaciente = new ExamePaciente();
            examePaciente.setAtendente(UserLogado.getATENDENTE());
            if (dlg.cbResponsavel.getSelectedItem() instanceof Medico) {
                examePaciente.setMedico((Medico) dlg.cbResponsavel.getSelectedItem());
            }
            if (dlg.cbResponsavel.getSelectedItem() instanceof Enfermeiro) {
                examePaciente.setEnfermeiro((Enfermeiro) dlg.cbResponsavel.getSelectedItem());
            }
            examePaciente.setExame((Exame) dlg.cbExame.getSelectedItem());
            examePaciente.setDataAgendamento(DataUtils.dataAtual());
            ocupacaoSala.setExame(examePaciente);
            examePaciente.setSala(ocupacaoSala);
            examePaciente.setPaciente(paciente);
            if (new ExamePacienteDaoImpl().salvar(examePaciente)) {
                SendMessenger.success("Exame Agendada Com Sucesso!");
                close();
            } else {
                SendMessenger.error("Erro ao salvar!");
            }
        }
    }

    public void cancelarExameAction() {
        close();
    }

    private void close() {
        dlg.dispose();
    }

    private boolean verificaOcupacaoSala() {
        if (dlg.tfData.getDate() != null && Validator.validarHora(dlg.tfHora.getText())) {
            Sala sala = (Sala) dlg.cbSala.getSelectedItem();
            Date data = DataUtils.stringToDate(dlg.tfData.getDate(), dlg.tfHora.getText());
            if (new OcupacaoSalaDaoImpl().getOcupacaoSala(sala, data)) {
                ocupacaoSala = new OcupacaoSala();
                ocupacaoSala.setData(data);
                ocupacaoSala.setSala(sala);
                return true;
            } else {
                SendMessenger.error("Sala ocupada neste horario!");
            }
        }
        return false;
    }
}
