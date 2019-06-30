/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.dao.banco.impl.VacinaAplicadaDaoImpl;
import br.com.clinica.dao.banco.impl.VacinaDaoImpl;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sala;
import br.com.clinica.domain.Vacina;
import br.com.clinica.domain.VacinaAplicada;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.util.Utils;
import br.com.clinica.view.AgendamentoVacinaDialog;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Henrique Baron
 */
public class AgendamentoVacinaControl {

    private AgendamentoVacinaDialog dlg;
    private VacinaAplicada vacinaAplicada;
    private Paciente paciente;

    public AgendamentoVacinaControl(AgendamentoVacinaDialog aThis, Paciente p) {
        this.dlg = aThis;
        this.paciente = p;
        loadConfig();
    }

    public void cancelarAction() {
        close();
    }

    public void salvarAction() {
        vacinaAplicada = new VacinaAplicada();
        vacinaAplicada.setAtendente(UserLogado.getATENDENTE());
        vacinaAplicada.setEnfermeiro((Enfermeiro) dlg.cbEnfermeiro.getSelectedItem());
        vacinaAplicada.setVacina((Vacina) dlg.cbVacina.getSelectedItem());
        vacinaAplicada.setSala((Sala) dlg.cbSala.getSelectedItem());
        vacinaAplicada.setDataAgendamento(new Date(System.currentTimeMillis()));
        vacinaAplicada.setData(Utils.stringToDate(dlg.jDateChooser1.getDate(), dlg.tfHora.getText()));
        vacinaAplicada.setAplicada(dlg.checkBox.isSelected());
        vacinaAplicada.setPaciente(paciente);
        if (new VacinaAplicadaDaoImpl().salvar(vacinaAplicada)) {
            SendMessenger.success(dlg.checkBox.isSelected() ? "Vacina Aplicada!" : "Vacina Agendada!");
            close();
        } else {
            SendMessenger.error("Verifique os campos!");
        }
    }

    public void aplicarAgoraAction() {
        if (dlg.checkBox.isSelected()) {
            dlg.tfHora.setText(Utils.horaAtual());
            dlg.jDateChooser1.setDate(new Date(System.currentTimeMillis()));
        }
    }

    private void close() {
        dlg.dispose();
    }

    private void loadConfig() {
        dlg.cbEnfermeiro.setModel(new DefaultComboBoxModel(new EnfermeiroDaoImpl().listar().toArray()));
        dlg.cbSala.setModel(new DefaultComboBoxModel(new SalaDaoImpl().listar().toArray()));
        dlg.cbVacina.setModel(new DefaultComboBoxModel(new VacinaDaoImpl().listar().toArray()));
    }
}
