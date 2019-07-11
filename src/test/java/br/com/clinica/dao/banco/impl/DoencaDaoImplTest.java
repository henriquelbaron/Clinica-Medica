/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Paciente;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
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
    @Ignore
    public void testSomeMethod() {
        dao.salvar(new Doenca("Pressão Alta"));
        dao.salvar(new Doenca("Diabete"));
        dao.salvar(new Doenca("Hipertenção"));
        dao.salvar(new Doenca("Fibromialgia"));
    }

}
