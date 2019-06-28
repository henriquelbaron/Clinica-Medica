package br.com.clinica.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@MappedSuperclass
public class Pessoa {

    @Column(length = 50, nullable = false)
    protected String nome;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dataNascimento;

    @Column(length = 14, nullable = false, unique = true)
    @CPF
    protected String cpf;

    @NotEmpty
    @Email
    protected String email;

    @Column(length = 15)
    protected String telefone;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idEndereco")
    protected Endereco endereco;

    @Enumerated(EnumType.STRING)
    protected Sexo sexo;

    protected String tipoSanguineo;

}
