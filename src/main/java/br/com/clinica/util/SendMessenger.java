/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Henrique Baron
 */
public class SendMessenger {

    public static void messenge(String str) {
    }

    public static void error(String str) {
        JOptionPane.showMessageDialog(null, str, "Atenção", JOptionPane.ERROR_MESSAGE);
    }

    public static void success(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    public static int confirmAction(String str) {
        return JOptionPane.showConfirmDialog(null, str, "ATENÇÃO", JOptionPane.YES_NO_OPTION);
    }

    public static String input(String str) {
        return null;
    }
}
