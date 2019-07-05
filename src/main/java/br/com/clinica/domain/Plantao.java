package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Plantao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, unique = true)
    private Date data;

    @OneToMany(mappedBy = "plantao", targetEntity = PlantaoMedico.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PlantaoMedico> medicos;

    @OneToMany(mappedBy = "plantao", targetEntity = PlantaoMedico.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PlantaoEnfermeiro> enfermeiros;

    public Plantao(Date data) {
        this.data = data;
    }

    public Plantao() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Plantao other = (Plantao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

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

    public Set<PlantaoMedico> getMedicos() {
        return medicos;
    }

    public void setMedicos(Set<PlantaoMedico> medicos) {
        this.medicos = medicos;
    }

    public List<PlantaoEnfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<PlantaoEnfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

}
