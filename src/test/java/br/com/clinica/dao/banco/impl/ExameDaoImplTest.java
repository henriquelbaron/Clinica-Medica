/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Exame;
import org.junit.Ignore;
import org.junit.Test;

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
    @Ignore
    public void testSomeMethod() {
        dao.salvar(new Exame("Sangue", ""));
        dao.salvar(new Exame("Raio X", ""));
        dao.salvar(new Exame("Tomografia", ""));
        dao.salvar(new Exame("Ressônancia Magnética", ""));
        dao.salvar(new Exame("Sangue", ""));
        dao.salvar(new Exame("Ultra-sonografia", ""));
        dao.salvar(new Exame("Hemograma", ""));
        dao.salvar(new Exame("Urina", ""));
        dao.salvar(new Exame("Fezes", ""));
        dao.salvar(new Exame("HIV", ""));
        dao.salvar(new Exame("Sífilis", ""));
        dao.salvar(new Exame("Glicemia em Jejum", ""));
    }

}
