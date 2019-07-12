/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Especialidade;
import org.junit.Ignore;
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
    @Ignore
    public void save() {
        dao.salvar(new Especialidade("Cirurgia Geral", "Faz Cirurgia"));
        dao.salvar(new Especialidade("Obstétrica", ""));
        dao.salvar(new Especialidade("Oncológica", " "));
        dao.salvar(new Especialidade("Nefrologia", " "));
        dao.salvar(new Especialidade("Clínica Médica", " "));
        dao.salvar(new Especialidade("Dermatologia", " "));
        dao.salvar(new Especialidade("Endoscopia", " "));
        dao.salvar(new Especialidade("Infectologia", " "));
        dao.salvar(new Especialidade("Endoscopia", " "));
        dao.salvar(new Especialidade("Oftalmologia", " "));
        dao.salvar(new Especialidade("Ortopedia", " "));
        dao.salvar(new Especialidade("Traumatologia", " "));
        dao.salvar(new Especialidade("Psiquiatria", " "));
    }

}
