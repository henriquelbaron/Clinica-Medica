package br.com.clinica.domain;

import java.util.List;

public class Enfermeiro extends Pessoa {

    private String corenCofen;
    private String senha;
    private Especialidade especialidade;
    private List<Plantao> plantaos;
    private List<Exame> exames;
    private List<Vacina> vacinas;

}
