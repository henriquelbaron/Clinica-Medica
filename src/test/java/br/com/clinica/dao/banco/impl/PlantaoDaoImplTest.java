package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import br.com.clinica.util.DataUtils;
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
//    @Ignore
    public void save() {
        dao.salvar(new Plantao(DataUtils.stringToDate("1/07/2019", "07:00")));
        dao.salvar(new Plantao(DataUtils.stringToDate("2/07/2019", "19:00")));
    }

    @Test
    @Ignore
    public void plantaoDoDia() {
    }

    @Test
    @Ignore
    public void adicionarMedicosPlantao() {
        MedicoDaoImpl medicoDaoImpl = new MedicoDaoImpl();
        Set<Medico> medicos = new HashSet();
        medicos.add(medicoDaoImpl.buscar(2));
        Plantao p = dao.buscar(5);
//        p.setMedicos(medicos);
        dao.editar(p);
    }
}
