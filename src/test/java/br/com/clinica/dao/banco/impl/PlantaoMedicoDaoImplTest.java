/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.util.DataUtils;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class PlantaoMedicoDaoImplTest {

    private PlantaoMedicoDaoImpl dao;
    private PlantaoDaoImpl daoPlantao;
    private MedicoDaoImpl daoMedico;

    public PlantaoMedicoDaoImplTest() {
        dao = new PlantaoMedicoDaoImpl();
        daoPlantao = new PlantaoDaoImpl();
        daoMedico = new MedicoDaoImpl();
    }
}
