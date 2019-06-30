package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "paciente", orphanRemoval = true, targetEntity = Telefone.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doenca_paciente",
            joinColumns = @JoinColumn(name = "idPaciente"),
            inverseJoinColumns = @JoinColumn(name = "idDoenca"))
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Doenca> doencas;

    @OneToMany(mappedBy = "paciente", targetEntity = Consulta.class, fetch = FetchType.LAZY)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente", targetEntity = ExamePaciente.class, fetch = FetchType.LAZY)
    private Set<ExamePaciente> examePacientes;

    @OneToMany(mappedBy = "paciente", targetEntity = VacinaAplicada.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<VacinaAplicada> vacinaAplicada;

    public Paciente() {
    }

    public Set<VacinaAplicada> getVacinaAplicada() {
        return vacinaAplicada;
    }

    public void setVacinaAplicada(Set<VacinaAplicada> vacinaAplicada) {
        this.vacinaAplicada = vacinaAplicada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(Set<Doenca> doencas) {
        this.doencas = doencas;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Set<ExamePaciente> getExamePacientes() {
        return examePacientes;
    }

    public void setExamePacientes(Set<ExamePaciente> examePacientes) {
        this.examePacientes = examePacientes;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
