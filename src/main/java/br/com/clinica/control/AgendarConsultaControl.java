/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ConsultaDaoImpl;
import br.com.clinica.dao.banco.impl.EspecialidadeDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.banco.impl.OcupacaoSalaDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Especialidade;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.OcupacaoSala;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sala;
import br.com.clinica.util.DataUtils;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.AgendamentoConsultaDialog;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author henrique
 */
public class AgendarConsultaControl {

    private final AgendamentoConsultaDialog dlg;
    private final Paciente paciente;
    private Consulta consulta;
    private OcupacaoSala ocupacaoSala;

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
        if (verificaOcupacaoSala()) {
            consulta = new Consulta();
            consulta.setMedico((Medico) dlg.cbMedico.getSelectedItem());
            consulta.setEspecialidade((Especialidade) dlg.cbEspecialidade.getSelectedItem());
            consulta.setDataAgendamento(DataUtils.dataAtual());
            consulta.setAtendente(UserLogado.getATENDENTE());
            consulta.setSala(ocupacaoSala);
            ocupacaoSala.setConsulta(consulta);
            consulta.setPaciente(paciente);
            if (new ConsultaDaoImpl().salvar(consulta)) {
                SendMessenger.success("Consulta Agendada Com Sucesso!");
                close();
            } else {
                SendMessenger.error("Erro ao salvar!");
            }
        }
    }

    public void cancelarConsultaAction() {
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
