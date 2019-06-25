/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Especialidade;
import org.junit.Test;

/**
 *
 * @author Henrique Baron
 */
public class EspecialidadeDaoImplTest {

    private EspecialidadeDaoImpl dao;

    public EspecialidadeDaoImplTest() {
        dao = new EspecialidadeDaoImpl();
    }

    @Test
    public void save() {
       Especialidade especialidade = new Especialidade("Cirurgião","Faz Cirurgia");
       dao.salvar(especialidade);
    }

}
