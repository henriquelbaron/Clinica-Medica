package br.com.clinica.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numero;
    private String tipo;
    private String nome;
    private String parentesco;
    private boolean isEmergencia;
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

}
