/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Paciente;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Henrique Baron
 */
public class DoencaDaoImplTest {

    private DoencaDaoImpl dao;

    public DoencaDaoImplTest() {
        dao = new DoencaDaoImpl();

    }

    @Test
    public void testSomeMethod() {
        Paciente paciente = new Paciente();
        Set<Doenca> doencas = new HashSet();
        for (Doenca doenca : doencas) {
            doencas.add(dao.buscar(1));
        }
        paciente.setDoencas(doencas);
        new PacienteDaoImpl().salvar(paciente);
    }

}
