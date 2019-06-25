package br.com.clinica.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Doenca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String descricao;
    private String medicacao;
    @ManyToMany
    @JoinTable(name = "doenca_paciente",
            joinColumns = @JoinColumn(name = "idDoenca"),
            inverseJoinColumns = @JoinColumn(name = "idPaciente"))
    private List<Paciente> pacientes;

}
