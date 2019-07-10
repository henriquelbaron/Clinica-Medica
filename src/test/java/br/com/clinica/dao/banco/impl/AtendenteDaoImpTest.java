/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Endereco;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.Sexo;
import br.com.clinica.domain.Usuario;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Henrique Baron
 */
public class AtendenteDaoImpTest {

    private AtendenteDaoImp dao;
    private Atendente atendente;

    public AtendenteDaoImpTest() {
        dao = new AtendenteDaoImp();
        atendente = new Atendente();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
//    @Ignore
    public void salvar() {

        atendente.setNome(Testes.nomeAleatorio());
        atendente.setCpf("186.402.484-32");
        atendente.setDataNascimento(new Date(System.currentTimeMillis()));
        atendente.setSexo(Sexo.MASCULINO);
        atendente.setEndereco(new Endereco("88131-743", "Braulina Goulart", "48", "RioGrande", "", "SC"));
        atendente.setTipoSanguineo("O+");
        atendente.setTelefone("48990323");
        atendente.setUsuario(new Usuario("atendente", "123"));

//        medico.setPlantaos(new PlantaoDaoImpl().listar());
        dao.salvar(atendente);
    }

    @Test
    @Ignore
    public void exluir() {
        atendente = new Atendente();
        atendente.setNome("henrique");
        Pessoa p = atendente;
        Atendente a = (Atendente) p;
        System.out.println(a.getNome());
    }

    @Test
    @Ignore
    public void listar() {
        List<Atendente> atendentes = dao.listar();
        for (Atendente atendente1 : atendentes) {
            System.out.println(atendente1.getNome());
        }
    }
}
