/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Set<Medico> medicos = new HashSet();
        medicos.add(new MedicoDaoImpl().buscar(3));
        plantao.setMedicos(medicos);
        dao.salvar(plantao);
    }

    @Test
//    @Ignore
    public void plantaoDoDia() {
//        List<Medico> medicos = dao.getPlantoesDia(new Date(System.currentTimeMillis()));
        List<Medico> medicos = dao.getPlantoesMedicoDia(new Date(System.currentTimeMillis()));
        for (Medico medico : medicos) {

            System.out.println(medicos.get(0).getPlantaos().size());
        }

    }
}
