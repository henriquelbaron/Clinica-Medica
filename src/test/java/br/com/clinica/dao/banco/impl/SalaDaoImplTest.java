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
        dao.salvar(new Sala("201", new FuncaoDaoImpl().buscar(245)));
        dao.salvar(new Sala("202", new FuncaoDaoImpl().buscar(246)));
        dao.salvar(new Sala("203", new FuncaoDaoImpl().buscar(247)));
        dao.salvar(new Sala("204", new FuncaoDaoImpl().buscar(244)));
        dao.salvar(new Sala("205", new FuncaoDaoImpl().buscar(247)));
        dao.salvar(new Sala("206", new FuncaoDaoImpl().buscar(246)));
        dao.salvar(new Sala("207", new FuncaoDaoImpl().buscar(245)));
        dao.salvar(new Sala("208", new FuncaoDaoImpl().buscar(244)));
        dao.salvar(new Sala("209", new FuncaoDaoImpl().buscar(247)));
        dao.salvar(new Sala("210", new FuncaoDaoImpl().buscar(245)));
    }

}
