package br.com.clinica.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Enfermeiro extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String corenCofen;
    private String senha;
    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

    @ManyToMany(mappedBy = "enfermeiros")
    private List<Plantao> plantaos;

    @OneToMany(mappedBy = "enfermeiro", targetEntity = Exame.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exame> exames;

    @OneToMany(mappedBy = "enfermeiro", targetEntity = Vacina.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vacina> vacinas;

}
