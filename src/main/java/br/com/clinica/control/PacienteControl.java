/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.DoencaDaoImpl;
import br.com.clinica.dao.banco.impl.VacinaDaoImpl;
import br.com.clinica.dao.server.EnderecoDaoServer;
import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sexo;
import br.com.clinica.domain.Telefone;
import br.com.clinica.domain.Vacina;
import br.com.clinica.domain.tables.TelefoneTable;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.InternalFrameCadastroPaciente;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author henrique
 */
public class PacienteControl {

    private JFrame frame;
    private final InternalFrameCadastroPaciente iFrame;
    private Telefone telefone;
    private Endereco endereco;
    private TelefoneTable table;
    private List<Telefone> telefones;
    private List<Doenca> doencas;
    private List<Vacina> vacinas;

    public PacienteControl(InternalFrameCadastroPaciente iFrame) {
        this.iFrame = iFrame;
        loadConfig();
    }

    private void loadConfig() {
        table = new TelefoneTable();
        iFrame.tabelaTelefones.setModel(table);
        iFrame.cbDoencas.setModel(new DefaultComboBoxModel(new DoencaDaoImpl().listar().toArray()));
        iFrame.cbVacina.setModel(new DefaultComboBoxModel(new VacinaDaoImpl().listar().toArray()));
        iFrame.cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
    }

    public void keyReleasedCep() {
        if (iFrame.tfCep.getText().trim().length() == 9) {
            endereco = EnderecoDaoServer.getEndereco(iFrame.tfCep.getText());
            iFrame.tfLogradouro.setText(endereco.getLogradouro());
            iFrame.tfBairro.setText(endereco.getBairro());
            iFrame.tfCidade.setText(endereco.getLocalidade());
            iFrame.tfEstado.setText(endereco.getUF());
            iFrame.tfLogradouro.setText(endereco.getLogradouro());
        }
    }

    public void addTelefoneAction() {
        String telefoneTela = iFrame.tfTelefone.getText();
        if (Validator.stringLenghtValidator(telefoneTela, 8)) {
            telefone = new Telefone();
            telefone.setNumero(telefoneTela);
            telefone.setTipo(iFrame.cbTipoTelefone.getSelectedItem().toString());
            table.addRow(telefone);
        }
    }

    public void removeTelefoneAction() {
        int rowTable = iFrame.tabelaTelefones.getSelectedRow();
        if (rowTable >= 0) {
            table.removeRow(rowTable);
        }
    }

    public void addDoencaAction() {

    }
}
