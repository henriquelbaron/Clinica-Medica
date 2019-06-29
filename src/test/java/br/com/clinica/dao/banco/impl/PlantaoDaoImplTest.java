/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Henrique Baron
 */
public class PlantaoDaoImplTest {

    private Plantao plantao;
    private PlantaoDaoImpl dao;

    public PlantaoDaoImplTest() {
        dao = new PlantaoDaoImpl();
    }

    @Test
    @Ignore
    public void save() {
        plantao = new Plantao();
        plantao.setData(new Date(System.currentTimeMillis()));
        List<Medico> medicos = new ArrayList();
        medicos.add(new MedicoDaoImpl().buscar(50));
        plantao.setMedicos(medicos);
        dao.salvar(plantao);
    }

    @Test
    public void plantaoDoDia() {
        List<Medico> plantaos = dao.getPlantoesDia(new Date(System.currentTimeMillis()));
        System.out.println(plantaos.size());
        System.out.println(plantaos.size());
        System.out.println(plantaos.size());
        System.out.println(plantaos.size());
        System.out.println(plantaos.size());
        System.out.println(plantaos.size());
        System.out.println(plantaos.size());
    }
}
