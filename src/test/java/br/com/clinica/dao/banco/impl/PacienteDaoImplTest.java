/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Sexo;
import br.com.clinica.domain.Telefone;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

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
//    @Ignore
    public void testFindPaciente() {
        for (int i = 0; i < 10; i++) {
            Paciente paciente = new Paciente();
            paciente.setNome("amanda" + i);
            paciente.setCpf("000.200.191-2" + i);
            paciente.setDataNascimento(new Date(System.currentTimeMillis()));
            paciente.setSexo(Sexo.MASCULINO);
            paciente.setEmail("heerique@gmail.com" + i);
            paciente.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
            paciente.setTipoSanguineo("O+");
            List<Telefone> telefones = new ArrayList();
            telefones.add(new Telefone(paciente, "(48)996850323", "Celular", "João", "Irmão", true));
            telefones.add(new Telefone(paciente, "(48)996850323", "Celular", "Henrique", "Pai", true));
            paciente.setTelefones(telefones);
            Set<Doenca> doencas = new HashSet();
            doencas.add(new DoencaDaoImpl().buscar(1));
            paciente.setDoencas(doencas);
            dao.salvar(paciente);
        }
    }

//    @Test
    public void listarPoTermo() {
        List<Paciente> pacientes = dao.listar();
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getTelefones());
        }
    }

}
