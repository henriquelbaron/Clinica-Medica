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
    private Enfermeiro enferemeiro;
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

            enferemeiro = new Enfermeiro();

            enferemeiro.setNome("Maria" + i);
            enferemeiro.setCpf("186.402.484-2" + i);
            enferemeiro.setDataNascimento(new Date(System.currentTimeMillis()));
            enferemeiro.setSexo(Sexo.MASCULINO);
            enferemeiro.setEmail("jose" + i);
            enferemeiro.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
            enferemeiro.setTipoSanguineo("O+");
            enferemeiro.setTelefone("48996850323");
            enferemeiro.setCorenCofen("123456" + i);
            enferemeiro.setEspecialidade(especialidadeDaoImpl.buscar(1));
//        enferemeiro.setPlantaos(new PlantaoDaoImpl().listar());
            dao.salvar(enferemeiro);
        }
    }

    @Test
//    @Ignore
    public void saveTest() {
        enferemeiro = new Enfermeiro();
        enferemeiro.setNome("Henrique");
        enferemeiro.setCpf("186.402.484-32");
        enferemeiro.setDataNascimento(new Date(System.currentTimeMillis()));
        enferemeiro.setSexo(Sexo.MASCULINO);
        enferemeiro.setEmail("henrique1@gmail.com");
        enferemeiro.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
        enferemeiro.setTipoSanguineo("O+");
        enferemeiro.setTelefone("48990323");
        enferemeiro.setCorenCofen("2313");
        enferemeiro.setEspecialidade(especialidadeDaoImpl.buscar(1));
        Usuario usuario = new Usuario();
        usuario.setLogin("3213123123");
        usuario.setSenha("123");
        usuario.setEnfermeiro(enferemeiro);
        enferemeiro.setUsuario(usuario);
//        medico.setPlantaos(new PlantaoDaoImpl().listar());
        dao.salvar(enferemeiro);
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
