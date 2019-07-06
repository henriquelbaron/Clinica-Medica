/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.util;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 *
 * @author Henrique Baron
 */
public class Utils {

    public static void campoPesquisa(JTextField tf) {
        tf.setEditable(true);
        tf.setText("");
        tf.setForeground(Color.BLACK);
    }

    public static void centralizarInternalFrame(JInternalFrame frame, JDesktopPane desktopPane) {
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

}
