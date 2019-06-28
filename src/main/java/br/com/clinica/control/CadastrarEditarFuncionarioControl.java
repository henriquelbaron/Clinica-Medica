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
import br.com.clinica.view.CadastroDeFuncionadoInternalFrame;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author henrique
 */
public class CadastrarEditarFuncionarioControl {

    private CadastroDeFuncionadoInternalFrame iFrame;
    private Pessoa pessoa;
    private Atendente atendente;
    private Medico medico;
    private Enfermeiro enfermeiro;
    private Especialidade especialidade;
    private Endereco endereco;
    private Integer keysReleased;

    public CadastrarEditarFuncionarioControl(CadastroDeFuncionadoInternalFrame frame) {
        this.iFrame = frame;
        loadConfig();
    }

    private void loadConfig() {
        iFrame.cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
        setEnabled(false);
    }

    public void keyReleasedCep() {
        if (iFrame.tfCep.getText().trim().length() == 9) {
            endereco = EnderecoDaoServer.getEndereco(iFrame.tfCep.getText());
            iFrame.tfLogradouro.setText(endereco.getLogradouro());
            iFrame.tfBairro.setText(endereco.getBairro());
            iFrame.tfCidade.setText(endereco.getLocalidade());
            iFrame.tfEstado.setText(endereco.getUF());
        }
    }

    public void selectRadioButton() {
        iFrame.buttonGroup1.getSelection();
        if (iFrame.rbEnfermeira.isSelected() || iFrame.rbMedico.isSelected()) {
            iFrame.cbEspecialidade.setModel(new DefaultComboBoxModel(new EspecialidadeDaoImpl().listar().toArray()));
            setEnabled(true);
        } else if (iFrame.rbAtendente.isSelected()) {
            setEnabled(false);
        }
    }

    public void saveAction() {
        boolean salvo = false;
        if (Validator.validSaveFuncionario(iFrame)) {
            if (iFrame.rbEnfermeira.isSelected()) {
                salvo = new EnfermeiroDaoImpl().salvar(populateEnfermeiro());
            }
            if (iFrame.rbMedico.isSelected()) {
                salvo = new MedicoDaoImpl().salvar(populateMedico());
            }
            if (iFrame.rbAtendente.isSelected()) {
                salvo = new AtendenteDaoImp().salvar(populateAtendente());
            }
            if (salvo) {
                SendMessenger.success("Cadastrado Com Sucesso");
            }
        }
    }

    private void setEnabled(boolean b) {
        iFrame.cbEspecialidade.setEnabled(b);
        iFrame.tfCRMCorenCofen.setEnabled(b);
    }

    private Enfermeiro populateEnfermeiro() {
        enfermeiro = new Enfermeiro();
        enfermeiro.setCorenCofen(iFrame.tfCRMCorenCofen.getText());
        enfermeiro.setEspecialidade((Especialidade) iFrame.cbEspecialidade.getSelectedItem());
        enfermeiro.setSenha(String.valueOf(iFrame.tfSenha.getPassword()));
        enfermeiro.setTipoSanguineo(iFrame.cbSangue.getSelectedItem().toString());
        enfermeiro.setNome(iFrame.tfNome.getText());
        enfermeiro.setDataNascimento(iFrame.jDateChooser1.getDate());
        enfermeiro.setTelefone(iFrame.tfTelefone.getText());
        enfermeiro.setCpf(iFrame.tfCPF.getText());
        enfermeiro.setEmail(iFrame.tfEmail.getText());
        enfermeiro.setSexo((Sexo) iFrame.cbSexo.getSelectedItem());
        endereco.setNumero(iFrame.tfNumero.getText());
        endereco.setComplemento(iFrame.tfComplemento.getText());
        enfermeiro.setEndereco(endereco);
        return enfermeiro;
    }

    private Medico populateMedico() {
        medico = new Medico();
        medico.setCrm(iFrame.tfCRMCorenCofen.getText());
        medico.setEspecialidade((Especialidade) iFrame.cbEspecialidade.getSelectedItem());
        medico.setSenha(String.valueOf(iFrame.tfSenha.getPassword()));
        medico.setTipoSanguineo(iFrame.cbSangue.getSelectedItem().toString());
        medico.setNome(iFrame.tfNome.getText());
        medico.setDataNascimento(iFrame.jDateChooser1.getDate());
        medico.setTelefone(iFrame.tfTelefone.getText());
        medico.setCpf(iFrame.tfCPF.getText());
        medico.setEmail(iFrame.tfEmail.getText());
        medico.setSexo((Sexo) iFrame.cbSexo.getSelectedItem());
        endereco.setNumero(iFrame.tfNumero.getText());
        endereco.setComplemento(iFrame.tfComplemento.getText());
        medico.setEndereco(endereco);
        return medico;
    }

    private Atendente populateAtendente() {
        atendente = new Atendente();
        atendente.setSenha(String.valueOf(iFrame.tfSenha.getPassword()));
        atendente.setTipoSanguineo(iFrame.cbSangue.getSelectedItem().toString());
        atendente.setNome(iFrame.tfNome.getText());
        atendente.setDataNascimento(iFrame.jDateChooser1.getDate());
        atendente.setTelefone(iFrame.tfTelefone.getText());
        atendente.setCpf(iFrame.tfCPF.getText());
        atendente.setEmail(iFrame.tfEmail.getText());
        atendente.setSexo((Sexo) iFrame.cbSexo.getSelectedItem());
        endereco.setNumero(iFrame.tfNumero.getText());
        endereco.setComplemento(iFrame.tfComplemento.getText());
        atendente.setEndereco(endereco);
        return atendente;
    }

    public void close() {
        iFrame.dispose();
    }
}
