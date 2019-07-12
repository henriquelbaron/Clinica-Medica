
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.validation;

import br.com.clinica.util.DataUtils;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.util.Utils;
import br.com.clinica.view.FuncionarioCRUDDialog;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author henrique
 */
public class Validator {

    public static boolean objectValidator(Object obj) {
        return obj == null;
    }

    public static boolean stringValidator(String str) {
        return !str.trim().isEmpty();
    }

    public static boolean emailValidator(String str) {
        return true;
    }

    public static boolean stringLenghtValidator(String str, int lenght) {
        if (str.trim().length() < lenght) {
            return false;
        }
        return true;
    }

    public static boolean isValidNome(String nome) {
        if (!stringValidator(nome)) {
            return false;
        }
        if (!nome.matches("^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$")) {
            return false;
        }
        return true;
    }

    public static boolean validarHora(String hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        try {
            sdf.parse(hora);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidCPF(String cpf) {
        if (!cpf.isEmpty()) {
            if (cpf.matches("[0-9]{11}") || cpf.matches("([0-9]{3}+[\\.]{1}+[0-9]{3}+[\\.]{1}+[0-9]{3}+[\\-]{1}+[0-9]{2})")) {
                cpf = cpf.replaceAll("[^0-9]", "");
                String primeiroCaractere = cpf.substring(0, 1);
                String removerRepeticoes = cpf.replaceAll(primeiroCaractere, "");
                if (removerRepeticoes.length() > 0) {
                    int somatorio1 = 0, somatorio2 = 0, peso1 = 10, peso2 = 11, numero;
                    String[] vetorCPF = cpf.split("");
                    for (int i = 0; i < 10; i++) {
                        numero = Integer.parseInt(vetorCPF[i]);
                        somatorio1 = (i < 9) ? somatorio1 + (numero * peso1) : somatorio1;
                        somatorio2 = somatorio2 + (numero * peso2);
                        peso1--;
                        peso2--;
                    }
                    int valor1 = 11 - (somatorio1 % 11);
                    int valor2 = 11 - (somatorio2 % 11);
                    int digitoVerificador1 = (valor1 > 9) ? 0 : valor1;
                    int digitoVerificador2 = (valor2 > 9) ? 0 : valor2;
                    if (Integer.parseInt(vetorCPF[9]) == digitoVerificador1 && Integer.parseInt(vetorCPF[10]) == digitoVerificador2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        if (email != null && email.length() > 10) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidCep(String cep) {
        if (cep != null && cep.matches("\\d{5}-\\d{3}")) {
            return true;
        }
        return false;
    }

    public static boolean isValidFields(JFormattedTextField cpf, JFormattedTextField cep, JTextField nome, JTextField email, JDateChooser nascimento) {
        boolean valido = true;
        Utils.colorirTf(email, true);
        Utils.colorirTf(cep, true);
        Utils.colorirTf(nome, true);
        Utils.colorirTf(cpf, true);
        List<String> campos = new ArrayList<>();
        if (!isValidCPF(cpf.getText())) {
            campos.add(cpf.getName());
            valido = false;
            Utils.colorirTf(cpf, false);
        }
        if (!isValidCep(cep.getText())) {
            campos.add(cep.getName());
            valido = false;
            Utils.colorirTf(cep, false);
        }
        if (!isValidNome(nome.getText())) {
            campos.add(nome.getName() + " Completo!");
            valido = false;
            Utils.colorirTf(nome, false);
        }
        if (!isValidEmail(email.getText())) {
            campos.add(email.getName());
            valido = false;
            Utils.colorirTf(email, false);
        }
        if (nascimento.getDate() == null) {
            campos.add(nascimento.getName());
            valido = false;
        }
        if (!valido) {
            String mensagem = "Campos Inválidos: \n";
            for (String campo : campos) {
                mensagem += campo + "\n";
            }
            SendMessenger.error(mensagem);
        }
        return valido;
    }

    public static boolean isValidConfirmarSenha(JPasswordField senha, JPasswordField confirmar) {
        if (String.valueOf(senha.getPassword()).equals(String.valueOf(confirmar.getPassword()))) {
            senha.setBackground(Color.WHITE);
            confirmar.setBackground(Color.WHITE);
            return true;
        }
        senha.setBackground(Color.red);
        confirmar.setBackground(Color.red);
        SendMessenger.error("Senhas Não Conferem!");
        return false;
    }
}
