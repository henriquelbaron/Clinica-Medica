/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.VacinaAplicadaDaoImpl;
import br.com.clinica.domain.VacinaAplicada;
import br.com.clinica.domain.tables.VacinaTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.view.AgendamentoVacinaDialog;
import br.com.clinica.view.InternalFrameListagemVacina;
import javax.swing.JFrame;

/**
 *
 * @author Henrique Baron
 */
public class VacinaControl {

    private JFrame frame;
    private InternalFrameListagemVacina iFrame;
    private VacinaTable table;
    private int rowTable;
    private VacinaAplicada vacinaAplicada;

    public VacinaControl(InternalFrameListagemVacina aThis, JFrame frame) {
        this.iFrame = aThis;
        this.frame = frame;
        loadConfig();
    }

    public void aplicarVacina() {
        rowTable = iFrame.tableVacina.getSelectedRow();
        if (rowTable >= 0) {
            vacinaAplicada = table.getRow(rowTable);
            AgendamentoVacinaDialog dlg = new AgendamentoVacinaDialog(frame, true, vacinaAplicada);
            dlg.setVisible(true);
        } else {
            SendMessenger.error("Selecione a Vacina que deseja aplicar!");
        }
    }

    public void pesquisarData() {
        
    }

    public void excluirAplicacao() {
        rowTable = iFrame.tableVacina.getSelectedRow();
        if (rowTable >= 0) {
            vacinaAplicada = table.getRow(rowTable);
            vacinaAplicada.setAplicada(true);
            if (new VacinaAplicadaDaoImpl().editar(vacinaAplicada)) {
                SendMessenger.success("Excluido!");
                table.removeRow(rowTable);
            }
        } else {
            SendMessenger.error("Selecio a Vacina que deseja aplicar!");
        }
    }

    private void loadConfig() {
        table = new VacinaTable();
        for (VacinaAplicada naoAplicada : new VacinaAplicadaDaoImpl().listar()) {
            table.addRow(naoAplicada);
        }
        iFrame.tableVacina.setModel(table);
    }

}
