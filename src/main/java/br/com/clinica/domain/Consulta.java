package br.com.clinica.domain;

import java.util.Date;
import java.util.List;

public class Consulta {
    
    private Integer id;
    private Date data;
    private Date dataAgendamento;
    private Medico medico;
    private Paciente paciente;
    private Atendente atendente;
    private Sala sala;
    private List<Remedio> remedios;
    private List<Vacina> vacinas;
}
