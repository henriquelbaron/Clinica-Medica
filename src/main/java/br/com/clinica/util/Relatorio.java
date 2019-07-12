/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Luiza Mistro
 */
public class Relatorio {

    public static void chamarRelatorio(InputStream enderecoArq, HashMap parametros, List<Object> objetos) {
        JasperPrint jasperPrint = null;
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(objetos);
        try {
            jasperPrint = JasperFillManager.fillReport(enderecoArq, parametros, dataSource);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório /n " + e);
            e.printStackTrace();

        }
        JasperViewer.viewReport(jasperPrint, false); // false para não fechar a aplicação quando fechar o relatório.

    }
}
