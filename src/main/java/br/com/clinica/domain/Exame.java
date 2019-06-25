package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private String resultado;
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "idEnfermeiro")
    private Enfermeiro enfermeiro;
    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala sala;
    @ManyToOne
    @JoinColumn(name = "idFuncao")
    private Funcao funcao;

}
