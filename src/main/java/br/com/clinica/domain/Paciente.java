package br.com.clinica.domain;

import java.util.List;

public class Paciente extends Pessoa {

    private List<Telefone> telefones;
    private List<Doenca> doencas;
    private List<Consulta> consultas;
    private List<Exame> exames;

}
