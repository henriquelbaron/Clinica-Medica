package br.com.clinica.domain;

import java.util.Date;

public class Exame {

	private Integer id;
	private String nome;
	private Date data;
	private String resultado;
	private Paciente paciente;
	private Medico medico;
	private Enfermeiro enfermeiro;
	private Sala sala;
	private Funcao funcao;

}
