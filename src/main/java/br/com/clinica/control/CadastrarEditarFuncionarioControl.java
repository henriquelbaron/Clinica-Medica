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
import br.com.clinica.domain.Usuario;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.FuncionarioCRUDDialog;
import java.awt.Color;
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
    private Usuario usuario;
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
            if (enfermeiro.getId() != null) {
                loadEnfermeiro();
                usuario = enfermeiro.getUsuario();
            }
        }
        if (obj instanceof Medico) {
            flag = 2;
            medico = (Medico) obj;
            dlg.lblCorenCRM.setText("CRM");
            if (medico.getId() != null) {
                loadMedico();
                usuario = medico.getUsuario();
            }
        }
        if (obj instanceof Atendente) {
            flag = 3;
            atendente = (Atendente) obj;
            setViseble(false);
            if (atendente.getId() != null) {
                loadAtendente();
                usuario = atendente.getUsuario();
            }
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
                    EnfermeiroDaoImpl enfermeiroDao = new EnfermeiroDaoImpl();
                    salvo = enfermeiro.getId() == null ? new EnfermeiroDaoImpl().salvar(populateEnfermeiro()) : enfermeiroDao.editar(populateEnfermeiro());
                    break;
                case 2:
                    MedicoDaoImpl medicoDao = new MedicoDaoImpl();
                    salvo = medico.getId() == null ? medicoDao.salvar(populateMedico()) : medicoDao.editar(populateMedico());
                    break;
                case 3:
                    AtendenteDaoImp atendenteDao = new AtendenteDaoImp();
                    salvo = atendente.getId() == null ? atendenteDao.salvar(populateAtendente()) : atendenteDao.editar(populateAtendente());
                    break;
            }
            if (salvo) {
                SendMessenger.success("Salvo com Sucesso!");
                close();
            } else {
                SendMessenger.error("Erro ao Salvar!");
            }
        } else {
            SendMessenger.error("Preencha corretamente os Campos!");
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
        enfermeiro.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        enfermeiro.setNome(dlg.tfNome.getText());
        enfermeiro.setDataNascimento(dlg.jDateChooser1.getDate());
        enfermeiro.setTelefone(dlg.tfTelefone.getText());
        enfermeiro.setCpf(dlg.tfCPF.getText());
        enfermeiro.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        if (enfermeiro.getUsuario() == null) {
            enfermeiro.setUsuario(new Usuario());
        }
        enfermeiro.getUsuario().setLogin(dlg.tfEmail.getText());
        enfermeiro.getUsuario().setSenha(String.valueOf(dlg.tfSenha.getPassword()));
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
        medico.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        medico.setNome(dlg.tfNome.getText());
        medico.setDataNascimento(dlg.jDateChooser1.getDate());
        medico.setTelefone(dlg.tfTelefone.getText());
        medico.setCpf(dlg.tfCPF.getText());
        medico.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        if (medico.getUsuario() == null) {
            medico.setUsuario(new Usuario());
        }
        medico.getUsuario().setSenha(String.valueOf(dlg.tfSenha.getPassword()));
        medico.getUsuario().setLogin(dlg.tfEmail.getText());
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
        atendente.setTipoSanguineo(dlg.cbSangue.getSelectedItem().toString());
        atendente.setNome(dlg.tfNome.getText());
        atendente.setDataNascimento(dlg.jDateChooser1.getDate());
        atendente.setTelefone(dlg.tfTelefone.getText());
        atendente.setCpf(dlg.tfCPF.getText());
        atendente.setSexo((Sexo) dlg.cbSexo.getSelectedItem());
        if (atendente.getUsuario() == null) {
            atendente.setUsuario(new Usuario());
        }
        atendente.getUsuario().setLogin(dlg.tfEmail.getText());
        atendente.getUsuario().setSenha(String.valueOf(dlg.tfSenha.getPassword()));
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

    private void loadEnfermeiro() {
        dlg.tfNome.setText(enfermeiro.getNome());
        dlg.jDateChooser1.setDate(enfermeiro.getDataNascimento());
        dlg.cbSangue.setSelectedItem(enfermeiro.getTipoSanguineo());
        dlg.cbSexo.setSelectedItem(enfermeiro.getSexo());
        dlg.tfTelefone.setText(enfermeiro.getTelefone());
        dlg.tfCPF.setText(enfermeiro.getCpf());
        dlg.tfEmail.setText(enfermeiro.getUsuario().getLogin());
        dlg.tfSenha.setText(enfermeiro.getUsuario().getSenha());
        dlg.cbEspecialidade.setSelectedItem(enfermeiro.getEspecialidade());
        dlg.tfCRMCorenCofen.setText(enfermeiro.getCorenCofen());
        dlg.tfCep.setText(enfermeiro.getEndereco().getCep());
        dlg.tfLogradouro.setText(enfermeiro.getEndereco().getLogradouro());
        dlg.tfBairro.setText(enfermeiro.getEndereco().getBairro());
        dlg.tfCidade.setText(enfermeiro.getEndereco().getLocalidade());
        dlg.tfEstado.setText(enfermeiro.getEndereco().getUF());
        dlg.tfNumero.setText(enfermeiro.getEndereco().getNumero());
        dlg.tfComplemento.setText(enfermeiro.getEndereco().getComplemento());

    }

    private void loadMedico() {
        dlg.tfNome.setText(medico.getNome());
        dlg.jDateChooser1.setDate(medico.getDataNascimento());
        dlg.cbSangue.setSelectedItem(medico.getTipoSanguineo());
        dlg.cbSexo.setSelectedItem(medico.getSexo());
        dlg.tfTelefone.setText(medico.getTelefone());
        dlg.tfCPF.setText(medico.getCpf());
        dlg.tfEmail.setText(medico.getUsuario().getLogin());
        dlg.tfSenha.setText(medico.getUsuario().getSenha());
        dlg.cbEspecialidade.setSelectedItem(medico.getEspecialidade());
        dlg.tfCRMCorenCofen.setText(medico.getCrm());
        dlg.tfCep.setText(medico.getEndereco().getCep());
        dlg.tfLogradouro.setText(medico.getEndereco().getLogradouro());
        dlg.tfBairro.setText(medico.getEndereco().getBairro());
        dlg.tfCidade.setText(medico.getEndereco().getLocalidade());
        dlg.tfEstado.setText(medico.getEndereco().getUF());
        dlg.tfNumero.setText(medico.getEndereco().getNumero());
        dlg.tfComplemento.setText(medico.getEndereco().getComplemento());
    }

    private void loadAtendente() {
        dlg.tfNome.setText(atendente.getNome());
        dlg.jDateChooser1.setDate(atendente.getDataNascimento());
        dlg.cbSangue.setSelectedItem(atendente.getTipoSanguineo());
        dlg.cbSexo.setSelectedItem(atendente.getSexo());
        dlg.tfTelefone.setText(atendente.getTelefone());
        dlg.tfCPF.setText(atendente.getCpf());
        dlg.tfEmail.setText(atendente.getUsuario().getLogin());
        dlg.tfSenha.setText(atendente.getUsuario().getSenha());
        dlg.tfCep.setText(atendente.getEndereco().getCep());
        dlg.tfLogradouro.setText(atendente.getEndereco().getLogradouro());
        dlg.tfBairro.setText(atendente.getEndereco().getBairro());
        dlg.tfCidade.setText(atendente.getEndereco().getLocalidade());
        dlg.tfEstado.setText(atendente.getEndereco().getUF());
        dlg.tfNumero.setText(atendente.getEndereco().getNumero());
        dlg.tfComplemento.setText(atendente.getEndereco().getComplemento());
    }

    public void confirmSenhaFocusLost() {
        if (!String.valueOf(dlg.tfSenha.getPassword()).equals(String.valueOf(dlg.tfConfirmarSenha.getPassword()))) {
            dlg.tfConfirmarSenha.setBackground(Color.red);
            dlg.tfSenha.setBackground(Color.red);
        } else {
            dlg.tfConfirmarSenha.setBackground(Color.WHITE);
            dlg.tfSenha.setBackground(Color.WHITE);
        }
    }
}
