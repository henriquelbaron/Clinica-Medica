/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Funcao;
import br.com.clinica.domain.Sala;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Henrique Baron
 */
public class SalaDaoImplTest {

    private SalaDaoImpl dao;
    private static Funcao funcao;

    public SalaDaoImplTest() {
        dao = new SalaDaoImpl();
    }

    @BeforeClass
    public static void setUpClass() {
        funcao = new Funcao("Teste");
        new FuncaoDaoImpl().salvar(funcao);
    }

    @Before
    public void setUp() {
    }

    @Test
//    @Ignore
    public void testSomeMethod() {
        dao.salvar(new Sala("1", funcao));
        dao.salvar(new Sala("2",  funcao));
        dao.salvar(new Sala("3", funcao));
        dao.salvar(new Sala("4", funcao));
        dao.salvar(new Sala("5", funcao));
        dao.salvar(new Sala("5", funcao));
        dao.salvar(new Sala("7", funcao));
        dao.salvar(new Sala("8", funcao));
        dao.salvar(new Sala("9", funcao));
        dao.salvar(new Sala("10", funcao));
    }

}
