/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ConsultaDaoImpl;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.tables.ConsultaTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.view.ConsultasDialog;
import br.com.clinica.view.EfeturarConsulta;
import java.awt.Frame;

/**
 *
 * @author Henrique Baron
 */
public class ConsultaControl {

    private Frame frame;
    private ConsultasDialog dlg;
    private ConsultaTable table;
    private Consulta consulta;
    private Medico medico;

    public ConsultaControl(Frame parent, ConsultasDialog aThis) {
        this.dlg = aThis;
        this.frame = parent;
        medico = UserLogado.getMEDICO();
        loadConfig();
    }

    public void tableClickListener() {
    }

    public void sendKeysTfListener() {

    }

    public void realizarConsulta() {
        int rowTable = dlg.tableConsulta.getSelectedRow();
        if (rowTable >= 0) {
            consulta = table.getRow(rowTable);
            EfeturarConsulta dialog = new EfeturarConsulta(frame, true, consulta);
            dialog.setVisible(true);
        } else {
            SendMessenger.error("Selecione uma Consulta");
        }
    }

    private void loadConfig() {
        table = new ConsultaTable();
        for (Consulta object : new ConsultaDaoImpl().consultaDoMedico(medico.getId())) {
            table.addRow(object);
        }
        dlg.tableConsulta.setModel(table);
        dlg.lblMedico.setText(medico.getNome());
    }

}
