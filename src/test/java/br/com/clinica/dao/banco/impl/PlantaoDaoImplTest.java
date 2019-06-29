/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import br.com.clinica.util.Utils;
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
        medicos.add(new MedicoDaoImpl().buscar(2));
        plantao.setMedicos(medicos);
        dao.salvar(plantao);
    }

    @Test
//    @Ignore
    public void plantaoDoDia() {
//        List<Medico> medicos = dao.getPlantoesDia(new Date(System.currentTimeMillis()));
        List<Medico> medicos = dao.getPlantoesMedicos();
        for (Medico medico : medicos) {

            System.out.println(medicos.get(0).getNome());
        }

    }
}
