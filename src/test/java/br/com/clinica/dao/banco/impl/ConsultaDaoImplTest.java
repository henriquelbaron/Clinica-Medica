/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Especialidade;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.OcupacaoSala;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Remedio;
import br.com.clinica.domain.Sala;
import br.com.clinica.util.DataUtils;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Luiza Mistro
 */
public class ConsultaDaoImplTest {

    Consulta consulta;
    Atendente atendente;
    Especialidade especialidade;
    Medico medico;
    Paciente paciente;
    List<Remedio> remedios;
    OcupacaoSala sala;

    @Test
    @Ignore
    public void saveTeste() {
        consulta = new Consulta();

        consulta.setAtendente(atendente);
        consulta.setDataAgendamento(DataUtils.stringToDate("19/07/2019", "07:00"));
        consulta.setDiagnostico("");
        consulta.setEspecialidade(especialidade);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setRealizada(true);
        consulta.setRemedios(remedios);
        consulta.setSala(sala);

    }

}
