/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.AtendenteDaoImp;
import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.banco.impl.UsuarioDaoImpl;
import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.Usuario;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.TelaLogin;
import br.com.clinica.view.TelaPrincipal;
import java.awt.Frame;

/**
 *
 * @author henrique
 */
public class LoginControl {

    Boolean loginIsValido = true;//Trocar por retorno do método de conferência de login
    private TelaLogin frame;

    public LoginControl(TelaLogin frame) {
        this.frame = frame;
        this.frame.labelAlerta.setVisible(false);

    }

    public void loginAction() {
        String email = frame.tfEmail.getText();
        String senha = String.valueOf(frame.tfSenha.getPassword());
        if (Validator.emailValidator(email) && Validator.stringLenghtValidator(senha, 2)) {
            Usuario usuarioLogado = new UsuarioDaoImpl().logarUsuario(email, senha);
            if (usuarioLogado != null) {
                abreTelaPrincipal(usuarioLogado.getMedico() != null ? usuarioLogado.getMedico() : 
                        (usuarioLogado.getAtendente() != null ? usuarioLogado.getAtendente() : usuarioLogado.getEnfermeiro()));
            } else {
                frame.labelAlerta.setText("Email ou Senha incorreta!");
                frame.labelAlerta.setVisible(true);
                frame.tfEmail.setText("");
                frame.tfSenha.setText("");
            }
        } else {
            frame.labelAlerta.setText("Preencha os campos corretamente!");
            frame.labelAlerta.setVisible(true);

        }
    }

    public void forgotPasswordAction() {

    }

    public void abreTelaPrincipal(Pessoa usuario) {
        TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
        telaPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
        telaPrincipal.setLocationRelativeTo(null);
        telaPrincipal.setVisible(true);
        frame.dispose();

    }
}
