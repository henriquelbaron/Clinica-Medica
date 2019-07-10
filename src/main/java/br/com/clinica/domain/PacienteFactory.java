/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiza Mistro
 */
public class PacienteFactory {

    private static List<Consulta> paciente = new ArrayList<>();

    public static java.util.Collection geraColecao() {
        return paciente;
    }

    public static void populaOjetosNoRelatório(List<Consulta> consultaList) {
        paciente = consultaList;
    }

}
