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

    public AgendamentoVacinaControl(AgendamentoVacinaDialog aThis, VacinaAplicada va) {
        this.dlg = aThis;
        this.vacinaAplicada = va;
        loadConfig();
    }

    public void cancelarAction() {
        close();
    }

    public void salvarAction() {
        if (UserLogado.getATENDENTE() != null) {
            vacinaAplicada.setAtendente(UserLogado.getATENDENTE());
        }
        if (UserLogado.getENFERMEIRO() != null) {
            vacinaAplicada.setEnfermeiro(UserLogado.getENFERMEIRO());
        }
        vacinaAplicada.setVacina((Vacina) dlg.cbVacina.getSelectedItem());
        vacinaAplicada.setSala((Sala) dlg.cbSala.getSelectedItem());
        vacinaAplicada.setDataAgendamento(new Date(System.currentTimeMillis()));
        vacinaAplicada.setData(Utils.stringToDate(dlg.jDateChooser1.getDate(), dlg.tfHora.getText()));
        vacinaAplicada.setAplicada(dlg.checkBox.isSelected());
        if (vacinaAplicada.getId() == null) {
            if (new VacinaAplicadaDaoImpl().salvar(vacinaAplicada)) {
                SendMessenger.success(dlg.checkBox.isSelected() ? "Vacina Aplicada!" : "Vacina Agendada!");
                close();
            }
        } else {
            if (new VacinaAplicadaDaoImpl().editar(vacinaAplicada)) {
                SendMessenger.success("Vacina aplicada!");
                close();
            }
        }

        SendMessenger.error("Verifique os campos!");
    }

    public void aplicarAgoraAction() {
        dlg.tfHora.setText(Utils.horaAtual());
        dlg.jDateChooser1.setDate(new Date(System.currentTimeMillis()));
    }

    private void close() {
        dlg.dispose();
    }

    private void loadConfig() {
        dlg.cbSala.setModel(new DefaultComboBoxModel(new SalaDaoImpl().listar().toArray()));
        dlg.cbVacina.setModel(new DefaultComboBoxModel(new VacinaDaoImpl().listar().toArray()));
        if (vacinaAplicada.getId() != null) {
            dlg.cbSala.setSelectedItem(vacinaAplicada.getSala());
            dlg.cbVacina.setSelectedItem(vacinaAplicada.getVacina());
            dlg.checkBox.setSelected(true);
            aplicarAgoraAction();
        }
        if (UserLogado.getENFERMEIRO() == null) {
            dlg.lblIcon.setVisible(false);
            dlg.checkBox.setVisible(false);
        }
    }
}
