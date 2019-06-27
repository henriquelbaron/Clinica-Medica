/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.DoencaDaoImpl;
import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Telefone;
import br.com.clinica.domain.Vacina;
import br.com.clinica.domain.tables.TelefoneTable;
import br.com.clinica.view.InternalFrameCadastroPaciente;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author henrique
 */
public class PacienteControl {

    private JFrame frame;
    private InternalFrameCadastroPaciente iFrame;
    private Paciente paciente;
    private Vacina vacina;
    private Telefone telefone;
    private Doenca doenca;
    private Endereco endereco;

    public PacienteControl(InternalFrameCadastroPaciente iFrame) {
        this.iFrame = iFrame;
    }

    private void loadConfig() {
        TelefoneTable table = new TelefoneTable();
        iFrame.TabelaTelefones.setModel(table);
        iFrame.cbDoencas.setModel(new DefaultComboBoxModel(new DoencaDaoImpl().listar().toArray()));
        
    }

    public void clickComboBoxSexoListener() {

    }

    public void clickComboBoTipoSanguineoListener() {

    }

    public void clickComboBoxVacinaListener() {

    }

    public void clickComboBoxDoencaListener() {

    }

    public void clickComboBoxTipoTelefoneListener() {

    }

    public void addTelefoneAction() {

    }

    public void addVacinaAction() {

    }

    public void saveAction() {

    }

    public void cancelAction() {

    }

    public void addContatoEmergenciaAction() {

    }

    public void addDoencaAction() {

    }

    public void loadTable() {

    }

}
