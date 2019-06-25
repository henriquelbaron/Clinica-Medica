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

    public Especialidade(String especialidade, String descricao) {
        this.especialidade = especialidade;
        this.descricao = descricao;
    }

    public Especialidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

}
