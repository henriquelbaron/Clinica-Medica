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
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "funcao", targetEntity = Exame.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exame> exames;

    @OneToMany(mappedBy = "funcao", targetEntity = Sala.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sala> salas;

}
