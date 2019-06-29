package br.com.clinica.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Pessoa {

    @Column(nullable = false)
    protected String nome;

    @Temporal(TemporalType.DATE)
    protected Date dataNascimento;

    @Column(length = 14, nullable = false, unique = true)
    protected String cpf;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(length = 15)
    protected String telefone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idEndereco")
    protected Endereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Sexo sexo;

    @Column(nullable = false)
    protected String tipoSanguineo;

}
