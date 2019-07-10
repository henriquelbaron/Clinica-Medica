/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.dao.banco.impl.ConsultaDaoImpl;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.PacienteFactory;
import br.com.clinica.util.Relatorio;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Luiza Mistro
 */
public class TesteMetodoPrincipal {
    
    public static void main(String[] args) {
        ConsultaDaoImpl consultaDaoImpl = new ConsultaDaoImpl();
        List<Consulta> consultas =  consultaDaoImpl.listar();// isso tem no banco ?
        System.out.println(consultas);
        
        PacienteFactory.populaOjetosNoRelatório(consultas);
        ControlRelatorio controlRelatorio = new ControlRelatorio();
        controlRelatorio.chamarRelatorioDestinatario(consultas);
        
    }
    
}

