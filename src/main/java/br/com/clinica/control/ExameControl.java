/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ExamePacienteDaoImpl;
import br.com.clinica.domain.ExamePaciente;
import br.com.clinica.domain.tables.ExameTable;
import br.com.clinica.view.PacienteExameDialog;
import br.com.clinica.view.InternalFrameExames;
import javax.swing.JFrame;

/**
 *
 * @author Henrique Baron
 */
public class ExameControl {

    private JFrame frame;
    private InternalFrameExames iFrame;
    private ExameTable table;

    public ExameControl(JFrame frame, InternalFrameExames aThis) {
        this.iFrame = aThis;
        this.frame = frame;
        loadConfig();

    }

    private void loadConfig() {
        table = new ExameTable();
        for (ExamePaciente ep : new ExamePacienteDaoImpl().listar()) {
            table.addRow(ep);
        }
        iFrame.tableExame.setModel(table);
    }

    public void resultadoExame() {
        int rowTable = iFrame.tableExame.getSelectedRow();
        if (rowTable >= 0) {
            ExamePaciente exame =table.getRow(rowTable);
            PacienteExameDialog dlg = new PacienteExameDialog(frame, true,exame);
            dlg.setVisible(true);
            table.updateRow(exame, rowTable);
        }
    }

}
