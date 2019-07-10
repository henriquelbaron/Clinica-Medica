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
    private final PacienteCRUDDialog dlg;
    private Telefone telefone;
    private Endereco endereco;
    private TelefoneTable table;
    private DefaultListModel<Doenca> doencasList;
    private DefaultListModel<Vacina> vacinasList;

    public CadastrarEditarPaciente(PacienteCRUDDialog dialog, Paciente paciente) {
        this.dlg = dialog;
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
        dlg.jDateChooser1.setDate(p.getDataNascimento());
        dlg.tfNome.setText(p.getNome());
        dlg.tfCPF.setText(p.getCpf());
        dlg.tfEmail.setText(p.getEmail());

        dlg.tfRua.setText(p.getEndereco().getLogradouro());
        dlg.tfCep.setText(p.getEndereco().getCep());
        dlg.tfNumero.setText(p.getEndereco().getNumero());
        dlg.tfBairro.setText(p.getEndereco().getBairro());
        dlg.tfCidade.setText(p.getEndereco().getLocalidade());
        dlg.tfEstado.setText(p.getEndereco().getUF());
        dlg.tfComplemento.setText(p.getEndereco().getComplemento());
        dlg.cbSexo.setSelectedItem(p.getSexo());
        dlg.cbTipoTelefone.setSelectedItem(p.getTipoSanguineo());

    }

    private void loadConfig(Paciente p) {
        table = new TelefoneTable();
        dlg.tabelaTelefones.setModel(table);
        dlg.cbDoencas.setModel(new DefaultComboBoxModel(new DoencaDaoImpl().listar().toArray()));
        dlg.cbVacina.setModel(new DefaultComboBoxModel(new VacinaDaoImpl().listar().toArray()));
        dlg.cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
        doencasList = new DefaultListModel();
        dlg.listaDoenca.setModel(doencasList);
        vacinasList = new DefaultListModel();
        dlg.listaVacinas.setModel(vacinasList);
        setVisible(false);
        if (p != null) {
            dlg.setTitle("Editar Cadastro de " + p.getNome());
            paciente = p;
            loadPaciente(p);
        } else {
            dlg.setTitle("Cadastrar Novo Paciente");
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
        p.setNome(dlg.tfNome.getText());
        p.setCpf(dlg.tfCPF.getText());
        p.setEmail(dlg.tfEmail.getText());
        p.setDataNascimento(dlg.jDateChooser1.getDate());
        p.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        p.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        p.getEndereco().setNumero(dlg.tfNumero.getText());
        p.getEndereco().setComplemento(dlg.tfComplemento.getText());
        p.getEndereco().setLogradouro(dlg.tfRua.getText());
        p.getEndereco().setBairro(dlg.tfBairro.getText());
        p.getEndereco().setLocalidade(dlg.tfCidade.getText());
        p.getEndereco().setUF(dlg.tfEstado.getText());
        p.getEndereco().setCep(dlg.tfCep.getText());
        List<Doenca> doencas = new ArrayList();
        for (int i = 0; i < doencasList.size(); i++) {
            doencas.add(doencasList.getElementAt(i));
        }
        p.setDoencas(doencas);
        Set<VacinaAplicada> vacinas = new HashSet();
        for (int i = 0; i < vacinasList.size(); i++) {
            VacinaAplicada va = new VacinaAplicada();
            va.setVacina(vacinasList.getElementAt(i));
            va.setPaciente(paciente);
            p.setVacinaAplicada(va);
        }
        p.setTelefones(table.getTelefones());
        return p;
    }

    public void keyReleasedCep() {
        if (dlg.tfCep.getText().trim().length() == 9) {
            endereco = EnderecoDaoServer.getEndereco(dlg.tfCep.getText());
            dlg.tfRua.setText(endereco.getLogradouro());
            dlg.tfBairro.setText(endereco.getBairro());
            dlg.tfCidade.setText(endereco.getLocalidade());
            dlg.tfEstado.setText(endereco.getUF());
            dlg.tfRua.setText(endereco.getLogradouro());
            paciente.setEndereco(endereco);
        }
    }

    public void addTelefoneAction() {
        String telefoneTela = dlg.tfTelefone.getText();
        if (Validator.stringLenghtValidator(telefoneTela, 8)) {
            telefone = new Telefone();
            telefone.setPaciente(paciente);
            telefone.setNumero(telefoneTela);
            telefone.setTipo(dlg.cbTipoTelefone.getSelectedItem().toString());
            if (telefone.getTipo().equals("Emergência")) {
                String nomeEmergencia = dlg.tfNomeTelefone.getText();
                if (Validator.stringLenghtValidator(nomeEmergencia, 2)) {
                    telefone.setIsEmergencia(true);
                    telefone.setNome(nomeEmergencia);
                    telefone.setParentesco(dlg.cbParentesco.getSelectedItem().toString());
                }
            }
            table.addRow(telefone);
        } else {
            SendMessenger.error("Preencha Corretamente o Telefone");
        }
    }

    public void removeTelefoneAction() {
        int rowTable = dlg.tabelaTelefones.getSelectedRow();
        if (rowTable >= 0) {
            table.removeRow(rowTable);
        }
    }

    public void addDoencaAction() {
        Doenca doenca = (Doenca) dlg.cbDoencas.getSelectedItem();
        if (!doencasList.contains(doenca)) {
            doencasList.addElement(doenca);
        }
    }

    public void removeDoencaAction() {
        int index = dlg.listaDoenca.getSelectedIndex();
        if (index >= 0) {
            doencasList.remove(index);
        }
    }

    public void addVacinasAction() {
        Vacina vacina = (Vacina) dlg.cbVacina.getSelectedItem();
        if (!vacinasList.contains(vacina)) {
            vacinasList.addElement(vacina);
        }
    }

    public void removeVacinasAction() {
        int index = dlg.listaVacinas.getSelectedIndex();
        if (index >= 0) {
            vacinasList.remove(index);
        }
    }

    public void cbTipoTelefoneAction() {
        if (dlg.cbTipoTelefone.getSelectedItem().equals("Emergência")) {
            setVisible(true);
        } else {
            setVisible(false);
        }
    }

    private void setVisible(boolean b) {
        dlg.tfNomeTelefone.setVisible(b);
        dlg.cbParentesco.setVisible(b);
        dlg.lblParentesco.setVisible(b);
        dlg.lblNomeTelefone.setVisible(b);
    }

    public void close() {
        dlg.dispose();
    }

}
