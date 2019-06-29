/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.DoencaDaoImpl;
import br.com.clinica.dao.banco.impl.PacienteDaoImpl;
import br.com.clinica.dao.banco.impl.VacinaDaoImpl;
import br.com.clinica.dao.server.EnderecoDaoServer;
import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sexo;
import br.com.clinica.domain.Telefone;
import br.com.clinica.domain.Vacina;
import br.com.clinica.domain.VacinaAplicada;
import br.com.clinica.domain.tables.TelefoneTable;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.PacienteCRUDDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author henrique
 */
public class CadastrarEditarPaciente {

    private Paciente paciente;
    private final PacienteCRUDDialog iFrame;
    private Telefone telefone;
    private Endereco endereco;
    private TelefoneTable table;
    private DefaultListModel<Doenca> doencasList;
    private DefaultListModel<Vacina> vacinasList;

    public CadastrarEditarPaciente(PacienteCRUDDialog dialog, Paciente paciente) {
        this.iFrame = dialog;
        loadConfig(paciente);
    }

    private void loadPaciente(Paciente p) {
        for (VacinaAplicada vacina : p.getVacinaAplicada()) {
            vacinasList.addElement(vacina.getVacina());
        }
        for (Telefone telefone1 : p.getTelefones()) {
            table.addRow(telefone1);
        }
        for (Doenca doenca : p.getDoencas()) {
            doencasList.addElement(doenca);
        }
        iFrame.jDateChooser1.setDate(p.getDataNascimento());
        iFrame.tfNome.setText(p.getNome());
        iFrame.tfCPF.setText(p.getCpf());
        iFrame.tfEmail.setText(p.getEmail());

        iFrame.tfRua.setText(p.getEndereco().getLogradouro());
        iFrame.tfCep.setText(p.getEndereco().getCep());
        iFrame.tfNumero.setText(p.getEndereco().getNumero());
        iFrame.tfBairro.setText(p.getEndereco().getBairro());
        iFrame.tfCidade.setText(p.getEndereco().getLocalidade());
        iFrame.tfEstado.setText(p.getEndereco().getUF());
        iFrame.tfComplemento.setText(p.getEndereco().getComplemento());
        iFrame.cbSexo.setSelectedItem(p.getSexo());
        iFrame.cbTipoTelefone.setSelectedItem(p.getTipoSanguineo());

    }

    private void loadConfig(Paciente p) {
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
        if (p != null) {
            iFrame.setTitle("Editar Cadastro de " + p.getNome());
            paciente = p;
            loadPaciente(p);
        } else {
            iFrame.setTitle("Cadastrar Novo Paciente");
            paciente = new Paciente();
        }
    }

    public void salvarAction() {
        if (paciente.getId() != null) {
            alterar();
        } else {
            salvar();
        }
    }

    private void salvar() {
        if (new PacienteDaoImpl().salvar(popularAtributos(paciente))) {
            SendMessenger.success("Paciente Cadastrado com Sucesso!");
            close();
        } else {
            SendMessenger.error("Erro!");
        }
    }

    private void alterar() {
        if (new PacienteDaoImpl().editar(popularAtributos(paciente))) {
            SendMessenger.success("Paciente Alterado com Sucesso!");
            close();
        } else {
            SendMessenger.error("Erro!");
        }
    }

    private Paciente popularAtributos(Paciente p) {
        p.setNome(iFrame.tfNome.getText());
        p.setCpf(iFrame.tfCPF.getText());
        p.setEmail(iFrame.tfEmail.getText());
        p.setDataNascimento(iFrame.jDateChooser1.getDate());
        p.setSexo((Sexo) iFrame.cbSexo.getSelectedItem());
        p.setTipoSanguineo(iFrame.cbSangue.getSelectedItem().toString());
        p.getEndereco().setNumero(iFrame.tfNumero.getText());
        p.getEndereco().setComplemento(iFrame.tfComplemento.getText());
        p.getEndereco().setLogradouro(iFrame.tfRua.getText());
        p.getEndereco().setBairro(iFrame.tfBairro.getText());
        p.getEndereco().setLocalidade(iFrame.tfCidade.getText());
        p.getEndereco().setUF(iFrame.tfEstado.getText());
        p.getEndereco().setCep(iFrame.tfCep.getText());
        Set<Doenca> doencas = new HashSet();
        for (int i = 0; i < doencasList.size(); i++) {
            doencas.add(doencasList.getElementAt(i));
        }
        p.setDoencas(doencas);
        Set<VacinaAplicada> vacinas = new HashSet();
        for (int i = 0; i < vacinasList.size(); i++) {
            VacinaAplicada va = new VacinaAplicada();
            va.setVacina(vacinasList.getElementAt(i));
            va.setPaciente(paciente);
            vacinas.add(va);
        }
        p.setVacinaAplicada(vacinas);
        p.setTelefones(table.getTelefones());
        return p;
    }

    public void keyReleasedCep() {
        if (iFrame.tfCep.getText().trim().length() == 9) {
            endereco = EnderecoDaoServer.getEndereco(iFrame.tfCep.getText());
            iFrame.tfRua.setText(endereco.getLogradouro());
            iFrame.tfBairro.setText(endereco.getBairro());
            iFrame.tfCidade.setText(endereco.getLocalidade());
            iFrame.tfEstado.setText(endereco.getUF());
            iFrame.tfRua.setText(endereco.getLogradouro());
            paciente.setEndereco(endereco);
        }
    }

    public void addTelefoneAction() {
        String telefoneTela = iFrame.tfTelefone.getText();
        if (Validator.stringLenghtValidator(telefoneTela, 8)) {
            telefone = new Telefone();
            telefone.setPaciente(paciente);
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
        } else {
            SendMessenger.error("Preencha Corretamente o Telefone");
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
        } else {
            setVisible(false);
        }
    }

    private void setVisible(boolean b) {
        iFrame.tfNomeTelefone.setVisible(b);
        iFrame.cbParentesco.setVisible(b);
        iFrame.lblParentesco.setVisible(b);
        iFrame.lblNomeTelefone.setVisible(b);
    }

    public void close() {
        iFrame.dispose();
    }

}
