/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Sexo;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class MedicoDaoImplTest {

    private MedicoDaoImpl dao;
    private static Medico medico;
    private EspecialidadeDaoImpl especialidadeDaoImpl;

    public MedicoDaoImplTest() {
        dao = new MedicoDaoImpl();
        especialidadeDaoImpl = new EspecialidadeDaoImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Test
//    @Ignore
    public void save() {
        for (int i = 0; i < 10; i++) {
            
        medico = new Medico();

        medico.setNome("João"+i);
        medico.setCpf("186.402.484-2"+i);
        medico.setDataNascimento(new Date(System.currentTimeMillis()));
        medico.setSexo(Sexo.MASCULINO);
        medico.setEmail("henrique");
        medico.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
        medico.setTipoSanguineo("O+");
        medico.setTelefone("48996850323");
        medico.setCrm("123456");
        medico.setSenha("123");
        medico.setEspecialidade(especialidadeDaoImpl.buscar(1));
//        medico.setPlantaos(new PlantaoDaoImpl().listar());
        dao.salvar(medico);
        }
    }

    @Test
    @Ignore
    public void buscar() {
        medico = dao.medicoLogar("henrique", "123");
        System.out.println(medico.getPlantaos());
    }
}
