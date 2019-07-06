/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Henrique Baron
 */
@Entity
public class OcupacaoSala implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @OneToOne(mappedBy = "ocupacaoSala", targetEntity = ExamePaciente.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ExamePaciente exame;

    @OneToOne(mappedBy = "ocupacaoSala", targetEntity = Consulta.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Consulta consulta;

    @OneToOne(mappedBy = "ocupacaoSala", targetEntity = VacinaAplicada.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private VacinaAplicada vacina;

    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala sala;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ExamePaciente getExame() {
        return exame;
    }

    public void setExame(ExamePaciente exame) {
        this.exame = exame;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public VacinaAplicada getVacina() {
        return vacina;
    }

    public void setVacina(VacinaAplicada vacina) {
        this.vacina = vacina;
    }


    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OcupacaoSala other = (OcupacaoSala) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
