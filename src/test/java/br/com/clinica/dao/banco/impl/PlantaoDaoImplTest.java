/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique Baron
 */
public class PlantaoDaoImplTest {

    private Plantao plantao;
    private PlantaoDaoImpl dao;

    public PlantaoDaoImplTest() {
        dao = new PlantaoDaoImpl();
        plantao = new Plantao();
    }

    @Test
    public void save() {
    }

}
