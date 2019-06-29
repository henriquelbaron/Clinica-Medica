/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.validation;

import br.com.clinica.util.Utils;
import br.com.clinica.view.CadastroDeFuncionadoInternalFrame;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

    public static boolean cpfValidator(String str) {
        return false;
    }

    public static boolean cepValidator(String str) {
        return false;
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

    public static boolean dateIsBefore(Date data) {
        LocalDate date = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return date.isBefore(LocalDate.now());
    }

//    public static boolean consultaValidator(){
//        
//    }
    public static boolean validSaveFuncionario(CadastroDeFuncionadoInternalFrame iFrame) {
        if (stringValidator(iFrame.tfNome.getText())) {
            return false;
        }
        if (stringLenghtValidator(iFrame.tfEmail.getText(), 10)) {

        }
        return true;
    }
}
