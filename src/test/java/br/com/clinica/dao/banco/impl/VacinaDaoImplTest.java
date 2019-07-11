/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Vacina;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class VacinaDaoImplTest {

    private VacinaDaoImpl dao;

    public VacinaDaoImplTest() {
        dao = new VacinaDaoImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    @Ignore
    public void testSomeMethod() {
        dao.salvar(new Vacina("Tetano", ""));
        dao.salvar(new Vacina("Difteria", ""));
        dao.salvar(new Vacina("Triplice-viral", ""));
        dao.salvar(new Vacina("Hepatite-B", ""));
        dao.salvar(new Vacina("Pneumonia", ""));
        dao.salvar(new Vacina("Febre Amarela", ""));
        dao.salvar(new Vacina("Gripe", ""));
        dao.salvar(new Vacina("HPV", ""));
        dao.salvar(new Vacina("Herpes Zóster", ""));
    }
}
