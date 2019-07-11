/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Funcao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique Baron
 */
public class FuncaoDaoImplTest {

    private FuncaoDaoImpl dao;

    public FuncaoDaoImplTest() {
        dao = new FuncaoDaoImpl();
    }

    @Test
    public void testSomeMethod() {
        dao.salvar(new Funcao("Consultório"));
        dao.salvar(new Funcao("Aplicação de Vacinas"));
        dao.salvar(new Funcao("Cirurgica"));
        dao.salvar(new Funcao("Triagem"));
    }

}
