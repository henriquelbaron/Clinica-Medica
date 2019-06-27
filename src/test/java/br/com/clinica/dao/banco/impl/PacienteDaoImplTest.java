/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sexo;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class PacienteDaoImplTest {

    private PacienteDaoImpl dao;

    public PacienteDaoImplTest() {
        dao = new PacienteDaoImpl();
    }

    /**
     * Test of findPaciente method, of class PacienteDaoImpl.
     */
    @Test
    @Ignore
    public void testFindPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome("João");
        paciente.setCpf("186.402.198-23");
        paciente.setDataNascimento(new Date(System.currentTimeMillis()));
        paciente.setSexo(Sexo.M);
        paciente.setEmail("henrique@gmail.com");
        paciente.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
        paciente.setTipoSanguineo("O+");
        paciente.setTelefone("48996850323");
        dao.salvar(paciente);

    }

    @Test
//    @Ignore
    public void listarPoTermo() {
        List<Paciente> pacientes = dao.findPaciente("j");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNome());
        }

    }

}
