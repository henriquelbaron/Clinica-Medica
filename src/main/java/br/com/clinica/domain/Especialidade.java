package br.com.clinica.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Especialidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String especialidade;
    private String descricao;

    @OneToMany(mappedBy = "especialidade", targetEntity = Medico.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medico> medicos;

    @OneToMany(mappedBy = "especialidade", targetEntity = Enfermeiro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Enfermeiro> enfermeiros;
}
