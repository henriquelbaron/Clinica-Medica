/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Especialidade;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Sexo;
import br.com.clinica.domain.Usuario;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class EnfermeiroDaoImplTest {

    private EnfermeiroDaoImpl dao;
    private Enfermeiro enfermeiro;
    private EspecialidadeDaoImpl especialidadeDaoImpl;

    public EnfermeiroDaoImplTest() {
        dao = new EnfermeiroDaoImpl();
        especialidadeDaoImpl = new EspecialidadeDaoImpl();
    }

    /**
     * Test of enfermeiroLogar method, of class EnfermeiroDaoImpl.
     */
    @Test
    @Ignore
    public void testEnfermeiroLogar() {
        for (int i = 0; i < 10; i++) {

            enfermeiro = new Enfermeiro();

            enfermeiro.setNome("Maria" + i);
            enfermeiro.setCpf("186.402.484-2" + i);
            enfermeiro.setDataNascimento(new Date(System.currentTimeMillis()));
            enfermeiro.setSexo(Sexo.MASCULINO);
            enfermeiro.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
            enfermeiro.setTipoSanguineo("O+");
            enfermeiro.setTelefone("48996850323");
            enfermeiro.setCorenCofen("123456" + i);
            enfermeiro.setEspecialidade(especialidadeDaoImpl.buscar(38+i));
//        enferemeiro.setPlantaos(new PlantaoDaoImpl().listar());
            enfermeiro.setUsuario(new Usuario("enfermeiro" + i, "123"));
            dao.salvar(enfermeiro);
        }
    }

    @Test
    @Ignore
    public void saveTest() {
        enfermeiro = new Enfermeiro();
        enfermeiro.setNome("Henrique");
        enfermeiro.setCpf("186.402.484-32");
        enfermeiro.setDataNascimento(new Date(System.currentTimeMillis()));
        enfermeiro.setSexo(Sexo.MASCULINO);
        enfermeiro.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
        enfermeiro.setTipoSanguineo("O+");
        enfermeiro.setTelefone("48990323");
        enfermeiro.setCorenCofen("2313");
        enfermeiro.setEspecialidade(especialidadeDaoImpl.buscar(38));

        enfermeiro.setUsuario(new Usuario("enfermeiro", "123"));

//        medico.setPlantaos(new PlantaoDaoImpl().listar());
        dao.salvar(enfermeiro);
    }

    /**
     * Test of getPlantoesDia method, of class EnfermeiroDaoImpl.
     */
    @Test
    @Ignore
    public void testGetPlantoesDia() {
        System.out.println("getPlantoesDia");
        Date dataDesejada = null;
        EnfermeiroDaoImpl instance = new EnfermeiroDaoImpl();
        List<Enfermeiro> expResult = null;
        List<Enfermeiro> result = instance.getPlantoesDia(dataDesejada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlantoes method, of class EnfermeiroDaoImpl.
     */
    @Test
    @Ignore
    public void testGetPlantoes() {
        System.out.println("getPlantoes");
        EnfermeiroDaoImpl instance = new EnfermeiroDaoImpl();
        List<Enfermeiro> expResult = null;
        List<Enfermeiro> result = instance.getPlantoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPaciente method, of class EnfermeiroDaoImpl.
     */
    @Test
    @Ignore
    public void testFindPaciente() {
        System.out.println("findPaciente");
        String termo = "";
        EnfermeiroDaoImpl instance = new EnfermeiroDaoImpl();
        List<Enfermeiro> expResult = null;
        List<Enfermeiro> result = instance.findPaciente(termo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
