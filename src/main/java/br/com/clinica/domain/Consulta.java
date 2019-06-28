package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data;

    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAgendamento;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "idAtendente", nullable = false)
    private Atendente atendente;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "idSala", nullable = false)
    private Sala sala;

    @OneToMany(mappedBy = "consulta", targetEntity = Remedio.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Remedio> remedios;

    @OneToMany(mappedBy = "consulta", targetEntity = Vacina.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vacina> vacinas;

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
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

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

}
