package br.com.clinica.domain;

import java.util.List;

public class Especialidade {

	private Integer id;
	private String especialidade;
	private String descricao;
        private List<Medico> medicos;
        private List<Enfermeiro> enfermeiros;
}
