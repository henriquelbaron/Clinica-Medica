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
import javax.swing.DefaultListModel;
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
    private DefaultListModel<Doenca> doencasList;
    private DefaultListModel<Vacina> vacinasList;
    private DefaultListModel<Telefone> telefoneList;

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
        doencasList = new DefaultListModel();
        iFrame.listaDoenca.setModel(doencasList);
        vacinasList = new DefaultListModel();
        iFrame.listaVacinas.setModel(vacinasList);
        setVisible(false);
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
            if (telefone.getTipo().equals("Emergência")) {
                String nomeEmergencia = iFrame.tfNomeTelefone.getText();
                if (Validator.stringLenghtValidator(nomeEmergencia, 2)) {
                    telefone.setIsEmergencia(true);
                    telefone.setNome(nomeEmergencia);
                    telefone.setParentesco(iFrame.cbParentesco.getSelectedItem().toString());
                }
            }
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
        Doenca doenca = (Doenca) iFrame.cbDoencas.getSelectedItem();
        if (!doencasList.contains(doenca)) {
            doencasList.addElement(doenca);
        }
    }

    public void removeDoencaAction() {
        int index = iFrame.listaDoenca.getSelectedIndex();
        if (index >= 0) {
            doencasList.remove(index);
        }
    }

    public void addVacinasAction() {
        Vacina vacina = (Vacina) iFrame.cbVacina.getSelectedItem();
        if (!vacinasList.contains(vacina)) {
            vacinasList.addElement(vacina);
        }
    }

    public void removeVacinasAction() {
        int index = iFrame.listaVacinas.getSelectedIndex();
        if (index >= 0) {
            vacinasList.remove(index);
        }
    }

    public void cbTipoTelefoneAction() {
        if (iFrame.cbTipoTelefone.getSelectedItem().equals("Emergência")) {
            setVisible(true);
        }else{
            setVisible(false);
        }
    }

    private void setVisible(boolean b) {
        iFrame.tfNomeTelefone.setVisible(b);
        iFrame.cbParentesco.setVisible(b);
        iFrame.lblParentesco.setVisible(b);
        iFrame.lblNomeTelefone.setVisible(b);
    }
}
