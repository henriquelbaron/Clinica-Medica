/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Exame;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class ExameDaoImplTest {

    private ExameDaoImpl dao;

    public ExameDaoImplTest() {
        dao = new ExameDaoImpl();
    }

    @Test
//    @Ignore
    public void testSomeMethod() {
        dao.salvar(new Exame("Sangue", ""));
    }

}
