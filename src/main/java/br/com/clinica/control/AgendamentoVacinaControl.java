/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.OcupacaoSalaDaoImpl;
import br.com.clinica.dao.banco.impl.SalaDaoImpl;
import br.com.clinica.dao.banco.impl.VacinaAplicadaDaoImpl;
import br.com.clinica.dao.banco.impl.VacinaDaoImpl;
import br.com.clinica.domain.OcupacaoSala;
import br.com.clinica.domain.Sala;
import br.com.clinica.domain.Vacina;
import br.com.clinica.domain.VacinaAplicada;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.util.DataUtils;
import br.com.clinica.validation.Validator;
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
    private OcupacaoSala ocupacaoSala;

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
        if (verificaOcupacaoSala()) {
            vacinaAplicada.setVacina((Vacina) dlg.cbVacina.getSelectedItem());
            vacinaAplicada.setDataAgendamento(DataUtils.dataAtual());
            vacinaAplicada.setAplicada(dlg.checkBox.isSelected());
            ocupacaoSala.setVacina(vacinaAplicada);
            vacinaAplicada.setSala(ocupacaoSala);
            vacinaAplicada.setAplicada(true);
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
        }
    }

    public void aplicarAgoraAction() {
        dlg.tfHora.setText(DataUtils.horaAtualString());
        dlg.jDateChooser1.setDate(new Date(System.currentTimeMillis()));
    }

    private void close() {
        dlg.dispose();
    }

    private boolean verificaOcupacaoSala() {
        if (dlg.jDateChooser1.getDate() != null && Validator.validarHora(dlg.tfHora.getText())) {
            Sala sala = (Sala) dlg.cbSala.getSelectedItem();
            Date data = DataUtils.stringToDate(dlg.jDateChooser1.getDate(), dlg.tfHora.getText());
            if (new OcupacaoSalaDaoImpl().getOcupacaoSala(sala, data)) {
                ocupacaoSala = new OcupacaoSala();
                ocupacaoSala.setData(data);
                ocupacaoSala.setSala(sala);
                return true;
            } else {
                SendMessenger.error("Sala ocupada neste horario!");
            }
        } else {
            SendMessenger.error("Preencha os campos corretamente!");
        }
        return false;
    }

    private void loadConfig() {
        dlg.cbSala.setModel(new DefaultComboBoxModel(new SalaDaoImpl().listar().toArray()));
        dlg.cbVacina.setModel(new DefaultComboBoxModel(new VacinaDaoImpl().listar().toArray()));
        if (vacinaAplicada.getId() != null) {
            dlg.cbSala.setSelectedItem(vacinaAplicada.getSala());
            dlg.cbVacina.setSelectedItem(vacinaAplicada.getVacina());
            aplicarAgoraAction();
        }
        if (UserLogado.getENFERMEIRO() == null) {
            dlg.lblIcon.setVisible(false);
            dlg.checkBox.setVisible(false);
        }
    }
}
