package br.com.clinica.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "paciente", targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Telefone> telefones;
    @ManyToMany(mappedBy = "pacientes")
    private List<Doenca> doencas;

    @OneToMany(mappedBy = "paciente", targetEntity = Consulta.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente", targetEntity = Exame.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exame> exames;

}
