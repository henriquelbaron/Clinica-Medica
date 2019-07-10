/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Telefone;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class TelefoneDaoImplTest {

    private TelefoneDaoImpl dao;

    public TelefoneDaoImplTest() {
        dao = new TelefoneDaoImpl();
    }

    /**
     * Test of getTelefonesPaciente method, of class TelefoneDaoImpl.
     */
    @Test
    @Ignore
    public void testGetTelefonesPaciente() {
        PacienteDaoImpl pacienteDaoImpl = new PacienteDaoImpl();
        for (Telefone t : dao.getTelefonesPaciente(37)) {
            System.out.println(t.getNome());
        }
    }

    @Test
    @Ignore
    public void listar() {
        for (Telefone telefone : dao.listar()) {
            System.out.println(telefone.getPaciente().getNome());
        }
    }
}
