/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.domain.Consulta;
import br.com.clinica.util.Relatorio;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Luiza Mistro
 */
public class ControlRelatorio {

    public void chamarRelatorioDestinatario(List<Consulta> destinatarios) {
        InputStream jasperFile = getClass().getResourceAsStream("/relatorios/newReport.jasper");
        List<Object> objects = (List<Object>) (Object) destinatarios;
        Relatorio.chamarRelatorio(jasperFile, null, objects);
    }

}
