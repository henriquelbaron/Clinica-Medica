/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.AtendenteDaoImp;
import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.EspecialidadeDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.server.EnderecoDaoServer;
import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Especialidade;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.Sexo;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.FuncionarioCRUDDialog;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author henrique
 */
public class CadastrarEditarFuncionarioControl {

    private FuncionarioCRUDDialog dlg;
    private Atendente atendente;
    private Medico medico;
    private Enfermeiro enfermeiro;
    private Endereco endereco;
    private int flag;

    public CadastrarEditarFuncionarioControl(FuncionarioCRUDDialog dlg, Pessoa obj) {
        this.dlg = dlg;
        loadConfig(obj);
    }

    private void loadConfig(Pessoa obj) {
        dlg.cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
        dlg.cbEspecialidade.setModel(new DefaultComboBoxModel(new EspecialidadeDaoImpl().listar().toArray()));
        if (obj instanceof Enfermeiro) {
            flag = 1;
            enfermeiro = (Enfermeiro) obj;
            dlg.lblCorenCRM.setText("Coren/Cofen");
        }
        if (obj instanceof Medico) {
            flag = 2;
            medico = (Medico) obj;
            dlg.lblCorenCRM.setText("CRM");
        }
        if (obj instanceof Atendente) {
            flag = 3;
            atendente = (Atendente) obj;
            setViseble(false);
        }
    }

    public void keyReleasedCep() {
        if (dlg.tfCep.getText().trim().length() == 9) {
            endereco = EnderecoDaoServer.getEndereco(dlg.tfCep.getText());
            dlg.tfLogradouro.setText(endereco.getLogradouro());
            dlg.tfBairro.setText(endereco.getBairro());
            dlg.tfCidade.setText(endereco.getLocalidade());
            dlg.tfEstado.setText(endereco.getUF());
        }
    }

    public void saveAction() {
        boolean salvo = false;
        if (Validator.validSaveFuncionario(dlg)) {
            switch (flag) {
                case 1:
                    if (enfermeiro.getId() == null) {
                        salvo = new EnfermeiroDaoImpl().salvar(populateEnfermeiro());
                    } else {
                        salvo = new EnfermeiroDaoImpl().editar(populateEnfermeiro());
                    }
                    break;
                case 2:
                    if (medico.getId() == null) {
                        salvo = new MedicoDaoImpl().salvar(populateMedico());
                    } else {
                        salvo = new MedicoDaoImpl().editar(populateMedico());
                    }
                    break;
                case 3:
                    if (atendente.getId() == null) {
                        salvo = new AtendenteDaoImp().salvar(populateAtendente());
                    } else {
                        salvo = new AtendenteDaoImp().editar(populateAtendente());
                    }
                    break;
            }
        } else {
            SendMessenger.error("Preencha corretamente os Campos!");
        }
        if (salvo) {
            SendMessenger.success("Salvo com Sucesso!");
            close();
        } else {
            SendMessenger.error("Erro ao Salvar!");
        }
    }

    private void setViseble(boolean b) {
        dlg.cbEspecialidade.setVisible(b);
        dlg.tfCRMCorenCofen.setVisible(b);
        dlg.lblCorenCRM.setVisible(b);
        dlg.lblEspecialidade.setVisible(b);
    }

    private Enfermeiro populateEnfermeiro() {
        enfermeiro.setCorenCofen(dlg.tfCRMCorenCofen.getText());
        enfermeiro.setEspecialidade((Especialidade) dlg.cbEspecialidade.getSelectedItem());
        enfermeiro.setSenha(String.valueOf(dlg.tfSenha.getPassword()));
        enfermeiro.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        enfermeiro.setNome(dlg.tfNome.getText());
        enfermeiro.setDataNascimento(dlg.jDateChooser1.getDate());
        enfermeiro.setTelefone(dlg.tfTelefone.getText());
        enfermeiro.setCpf(dlg.tfCPF.getText());
        enfermeiro.setEmail(dlg.tfEmail.getText());
        enfermeiro.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        if (enfermeiro.getEndereco() == null) {
            enfermeiro.setEndereco(new Endereco());
        }
        enfermeiro.getEndereco().setNumero(dlg.tfNumero.getText());
        enfermeiro.getEndereco().setComplemento(dlg.tfComplemento.getText());
        enfermeiro.getEndereco().setCep(dlg.tfCep.getText());
        enfermeiro.getEndereco().setLogradouro(dlg.tfLogradouro.getText());
        enfermeiro.getEndereco().setBairro(dlg.tfBairro.getText());
        enfermeiro.getEndereco().setLocalidade(dlg.tfCidade.getText());
        enfermeiro.getEndereco().setUF(dlg.tfEstado.getText());

        return enfermeiro;
    }

    private Medico populateMedico() {
        medico.setCrm(dlg.tfCRMCorenCofen.getText());
        medico.setEspecialidade((Especialidade) dlg.cbEspecialidade.getSelectedItem());
        medico.setSenha(String.valueOf(dlg.tfSenha.getPassword()));
        medico.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        medico.setNome(dlg.tfNome.getText());
        medico.setDataNascimento(dlg.jDateChooser1.getDate());
        medico.setTelefone(dlg.tfTelefone.getText());
        medico.setCpf(dlg.tfCPF.getText());
        medico.setEmail(dlg.tfEmail.getText());
        medico.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        if (medico.getEndereco() == null) {
            medico.setEndereco(new Endereco());
        }
        medico.getEndereco().setNumero(dlg.tfNumero.getText());
        medico.getEndereco().setComplemento(dlg.tfComplemento.getText());
        medico.getEndereco().setCep(dlg.tfCep.getText());
        medico.getEndereco().setLogradouro(dlg.tfLogradouro.getText());
        medico.getEndereco().setBairro(dlg.tfBairro.getText());
        medico.getEndereco().setLocalidade(dlg.tfCidade.getText());
        medico.getEndereco().setUF(dlg.tfEstado.getText());
        return medico;
    }

    private Atendente populateAtendente() {
        atendente.setSenha(String.valueOf(dlg.tfSenha.getPassword()));
        atendente.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        atendente.setNome(dlg.tfNome.getText());
        atendente.setDataNascimento(dlg.jDateChooser1.getDate());
        atendente.setTelefone(dlg.tfTelefone.getText());
        atendente.setCpf(dlg.tfCPF.getText());
        atendente.setEmail(dlg.tfEmail.getText());
        atendente.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        if (atendente.getEndereco() == null) {
            atendente.setEndereco(new Endereco());
        }
        atendente.getEndereco().setNumero(dlg.tfNumero.getText());
        atendente.getEndereco().setComplemento(dlg.tfComplemento.getText());
        atendente.getEndereco().setCep(dlg.tfCep.getText());
        atendente.getEndereco().setLogradouro(dlg.tfLogradouro.getText());
        atendente.getEndereco().setBairro(dlg.tfBairro.getText());
        atendente.getEndereco().setLocalidade(dlg.tfCidade.getText());
        atendente.getEndereco().setUF(dlg.tfEstado.getText());
        return atendente;
    }

    public void close() {
        dlg.dispose();
    }
}
