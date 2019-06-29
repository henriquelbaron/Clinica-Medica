/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.VacinaAplicada;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique Baron
 */
public class VacinaAplicadaDaoImplTest {

    VacinaAplicadaDaoImpl dao;

    public VacinaAplicadaDaoImplTest() {
        dao = new VacinaAplicadaDaoImpl();
    }

    @Test
    public void testSomeMethod() {
        VacinaAplicada vacina = new VacinaAplicada();
        vacina.setVacina(new VacinaDaoImpl().buscar(1));
        vacina.setPaciente(new PacienteDaoImpl().buscar(1));
        dao.salvar(vacina);
    }

}
