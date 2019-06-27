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

/**
 *
 * @author Henrique Baron
 */
public class TelefoneDaoImplTest {
    
    public TelefoneDaoImplTest() {
    }

    /**
     * Test of getTelefonesPaciente method, of class TelefoneDaoImpl.
     */
    @Test
    public void testGetTelefonesPaciente() {
        System.out.println("getTelefonesPaciente");
        int id = 0;
        TelefoneDaoImpl instance = new TelefoneDaoImpl();
        List<Telefone> expResult = null;
        List<Telefone> result = instance.getTelefonesPaciente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
