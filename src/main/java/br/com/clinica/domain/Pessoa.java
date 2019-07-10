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

    @Column(length = 15)
    protected String telefone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idEndereco", nullable = false)
    protected Endereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Sexo sexo;

    @Column(nullable = false)
    protected String tipoSanguineo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
