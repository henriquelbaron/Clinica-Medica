/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.view.TelaLogin;
import br.com.clinica.view.TelaPrincipal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author henrique
 */
public class LoginControl {

    private JFrame frame;
    Boolean loginIsValido = true;//Trocar por retorno do método de conferência de login
    MainControl telaPrincipal;
    TelaLogin telaLogin;

    public LoginControl() {
        telaPrincipal = null;
    }

    public void loginAction() {

    }

    public void forgotPasswordAction() {

    }

    public void abreTelaPrincipal() {
        if (!loginIsValido) {
            JOptionPane.showMessageDialog(null, "Login Inválido!");
        } else {
            if (telaPrincipal != null) {
                telaPrincipal.chamarTelaPrincipal();
            } else {
                telaPrincipal = new MainControl();
                telaPrincipal.chamarTelaPrincipal();
            }
            telaLogin.dispose();
        }

    }
}
