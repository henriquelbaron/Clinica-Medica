/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.util;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.domain.Paciente;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.bouncycastle.jce.provider.symmetric.AESMappings;
import org.hibernate.Session;

/**
 *
 * @author Luiza Mistro
 */
public class Relatorio {


    public static void chamarRelatorio(InputStream enderecoArq, HashMap parametros) {
        JasperPrint jasperPrint = null;
        try {
//            jasperPrint = JasperFillManager.fillReport(enderecoArq, parametros, con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório /n " + e);

        }
        JasperViewer.viewReport(jasperPrint, false); // false para não fechar a aplicação quando fechar o relatório.

    }

    public HashMap criaHashmap(Paciente p) {
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idPaciente", p.getId());
        return parametros;
    }
}

//Endereço de arquivo >> 
// InputStream jasperFile = getClass().getResourceAsStream("/reports/destinatariosList.jasper");
