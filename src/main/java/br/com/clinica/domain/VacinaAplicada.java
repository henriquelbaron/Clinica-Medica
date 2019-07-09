package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Henrique Baron
 */
@Entity
public class VacinaAplicada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAgendamento;

    private boolean aplicada;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOcupacaoSala")
    private OcupacaoSala ocupacaoSala;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAtendente")
    private Atendente atendente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEnfermeiro")
    private Enfermeiro enfermeiro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVacina", nullable = false)
    private Vacina vacina;

    public VacinaAplicada() {
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public OcupacaoSala getSala() {
        return ocupacaoSala;
    }

    public void setSala(OcupacaoSala sala) {
        this.ocupacaoSala = sala;
    }

    public boolean isAplicada() {
        return aplicada;
    }

    public void setAplicada(boolean aplicada) {
        this.aplicada = aplicada;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dataAgendamento);
        hash = 97 * hash + (this.aplicada ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.vacina);
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
        final VacinaAplicada other = (VacinaAplicada) obj;
        if (this.aplicada != other.aplicada) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataAgendamento, other.dataAgendamento)) {
            return false;
        }
        if (!Objects.equals(this.vacina, other.vacina)) {
            return false;
        }
        return true;
    }

}
