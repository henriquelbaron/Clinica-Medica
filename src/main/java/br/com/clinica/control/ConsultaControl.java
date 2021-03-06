/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ConsultaDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.PacienteFactory;
import br.com.clinica.domain.tables.ConsultaTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.view.ConsultasDialog;
import br.com.clinica.view.EfeturarConsulta;
import br.com.clinica.view.InternalFrameEmergencia;
import java.awt.Frame;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

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
    private DefaultComboBoxModel cbFuncionario;
    ConsultaDaoImpl consultaDaoImpl;
    List<Consulta> consultas;

    public ConsultaControl(Frame parent, ConsultasDialog aThis) {
        this.dlg = aThis;
        this.frame = parent;
        medico = UserLogado.getMEDICO();
        loadConfig();
        consultaDaoImpl = new ConsultaDaoImpl();
        consultas = consultaDaoImpl.listar();
    }

    public void chamarRelatório() {
        PacienteFactory.populaOjetosNoRelatório(consultas);
        ControlRelatorio controlRelatorio = new ControlRelatorio();
        controlRelatorio.chamarRelatorioDestinatario(consultas);
    }

    public void tableClickListener() {
    }

    public void sendKeysTfListener() {
        table.clearTable();
        String tfNome = dlg.tfPesquisar.getText();
        for (Consulta object : new ConsultaDaoImpl().consultaDoMedicoNome(medico.getId(), tfNome)) {
            table.addRow(object);
        }
    }

    public void pesquisarPorDataAction() {
        table.clearTable();
        Date data = dlg.tfData.getDate();
        if (data != null) {
            for (Consulta object : new ConsultaDaoImpl().consultaDoMedicoData(medico.getId(), data)) {
                table.addRow(object);
            }
        }
    }

    public void realizarConsulta() {
        int rowTable = dlg.tableConsulta.getSelectedRow();
        if (rowTable >= 0) {
            consulta = table.getRow(rowTable);
            EfeturarConsulta dialog = new EfeturarConsulta(frame, true, consulta);
            dialog.setVisible(true);
            loadConfig();
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

    private void loadComboBox() {
        cbFuncionario = new DefaultComboBoxModel(new MedicoDaoImpl().listar().toArray());
        InternalFrameEmergencia.jComboBox2.setModel(cbFuncionario);
    }

}
