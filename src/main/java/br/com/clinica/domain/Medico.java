package br.com.clinica.domain;

import java.util.List;

public class Medico extends Pessoa {

	private String crm;
	private String senha;
	private Especialidade especialidade;
	private List<Plantao> plantaos;
	private List<Consulta> consultas;
	private List<Exame> exames;
        

}
