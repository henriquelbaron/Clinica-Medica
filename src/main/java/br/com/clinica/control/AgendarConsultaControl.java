/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ConsultaDaoImpl;
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
import br.com.clinica.util.SendMessenger;
import br.com.clinica.util.Utils;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.AgendamentoConsultaDialog;
import br.com.clinica.view.TelaPrincipal;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author henrique
 */
public class AgendarConsultaControl {

    private final AgendamentoConsultaDialog dlg;
    private final Paciente paciente;
    private Consulta consulta;

    public AgendarConsultaControl(AgendamentoConsultaDialog frame, Paciente paciente) {
        this.dlg = frame;
        this.paciente = paciente;
        loadConfig();
    }

    private void loadConfig() {
        dlg.lblAtendente.setText(UserLogado.getATENDENTE().getNome());
        dlg.lblPaciente.setText(paciente.getNome());
        dlg.cbMedico.setModel(new DefaultComboBoxModel(new MedicoDaoImpl().listar().toArray()));
        dlg.cbSala.setModel(new DefaultComboBoxModel(new SalaDaoImpl().listar().toArray()));
        dlg.cbEspecialidade.setModel(new DefaultComboBoxModel(new EspecialidadeDaoImpl().listar().toArray()));

    }

    public void confirmarConsultaAction() {
        if (Validator.stringValidator(dlg.tfHora.getText())) {
            consulta = new Consulta();
            consulta.setMedico((Medico) dlg.cbMedico.getSelectedItem());
            consulta.setSala((Sala) dlg.cbSala.getSelectedItem());
            consulta.setEspecialidade((Especialidade) dlg.cbEspecialidade.getSelectedItem());
            consulta.setDataAgendamento(new Date(System.currentTimeMillis()));
            consulta.setData(Utils.stringToDate(dlg.tfData.getDate(), dlg.tfHora.getText()));
            consulta.setAtendente(UserLogado.getATENDENTE());
            consulta.setPaciente(paciente);
            if (new ConsultaDaoImpl().salvar(consulta)) {
                SendMessenger.success("Consulta Agendada Com Sucesso!");
                close();
            } else {
                SendMessenger.error("Erro ao salvar!");
            }
        } else {
            SendMessenger.error("Complete os campos Corretamente!");
        }
    }

    public void cancelarConsultaAction() {
        close();
    }

    private void close() {
        dlg.dispose();
    }
}
