/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ExamePacienteDaoImpl;
import br.com.clinica.domain.ExamePaciente;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.util.Utils;
import br.com.clinica.view.PacienteExameDialog;

/**
 *
 * @author Henrique Baron
 */
public class ExamePacienteControl {

    private PacienteExameDialog dlg;
    private ExamePaciente ep;

    public ExamePacienteControl(PacienteExameDialog aThis, ExamePaciente ep) {
        this.dlg = aThis;
        this.ep = ep;
        loadConfig();
    }

    public void save() {
        ep.setResultado(dlg.tfResultado.getText());
        if (new ExamePacienteDaoImpl().editar(ep)) {
            SendMessenger.success("Salvo com Sucesso");
            dlg.dispose();
        }
    }

    private void loadConfig() {
        dlg.lblExame.setText("Exame de " + ep.getExame().getNome());
        dlg.lblData.setText(Utils.dateHoraToString(ep.getData()));
        dlg.lblAgendado.setText(Utils.dateHoraToString(ep.getDataAgendamento()));
        dlg.lblPaciente.setText(ep.getPaciente().getNome());
        dlg.lblSala.setText(ep.getSala().getNumero());
        if (ep.getMedico() != null) {
            dlg.lblResponsavel.setText("Dr(a). " + ep.getMedico().getNome());
        }
        if (ep.getEnfermeiro() != null) {
            dlg.lblResponsavel.setText("Enfermeiro(a) " + ep.getEnfermeiro().getNome());
        }
    }

}
