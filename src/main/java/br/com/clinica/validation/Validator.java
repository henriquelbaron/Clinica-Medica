
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.validation;

import br.com.clinica.view.FuncionarioCRUDDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (str.trim().length() <= lenght) {
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

    public static boolean validSaveFuncionario(FuncionarioCRUDDialog dlg) {
        if (!stringValidator(dlg.tfNome.getText())) {
            return false;
        }
        if (!stringLenghtValidator(dlg.tfEmail.getText(), 10)) {
            return false;
        }
        return true;
    }

    public boolean isValidCPF(String cpf) {
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
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
