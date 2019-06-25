package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @Column(length = 50, nullable = false)
    protected String nome;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dataNascimento;
    @Column(length = 14, nullable = false, unique = true)
    protected String cpf;
    @NotEmpty
    protected String email;
    protected String telefone;
    @ManyToOne
    @JoinColumn(nullable = false)
    protected Endereco endereco;
    protected String sexo;
    protected char tipoSanguineo;

}
