/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import br.com.clinica.util.Utils;
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
        dao.salvar(new Plantao(Utils.stringToDate("1/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("2/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("3/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("4/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("5/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("6/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("7/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("8/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("9/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("10/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("11/07/2019")));
        dao.salvar(new Plantao(Utils.stringToDate("12/07/2019")));
    }

    @Test
//    @Ignore
    public void plantaoDoDia() {
//        List<Medico> medicos = dao.getPlantoesDia(new Date(System.currentTimeMillis()));
        List<Medico> medicos = dao.getPlantoesMedicos();
//        List<Plantao> plantaos = dao.getPlantoesDia(Utils.stringToDate("12/07/2019"));
        for (Medico medico : medicos) {
            for (Plantao plantao : medico.getPlantaos()) {
                System.out.println(plantao.getData());
                System.out.println(medico.getNome());
            }
        }
    }

    @Test
    @Ignore
    public void adicionarMedicosPlantao() {
        MedicoDaoImpl medicoDaoImpl = new MedicoDaoImpl();
        Set<Medico> medicos = new HashSet();
        medicos.add(medicoDaoImpl.buscar(16));
        Plantao p = dao.buscar(4);
        p.setMedicos(medicos);
        dao.editar(p);
    }
}
