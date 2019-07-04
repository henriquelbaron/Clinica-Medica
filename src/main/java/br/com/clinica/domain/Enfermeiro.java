package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Enfermeiro extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String corenCofen;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "enfermeiro", targetEntity = PlantaoEnfermeiro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PlantaoEnfermeiro> plantaos;

    @OneToMany(mappedBy = "enfermeiro", targetEntity = ExamePaciente.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamePaciente> exames;

    @OneToMany(mappedBy = "enfermeiro", targetEntity = VacinaAplicada.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VacinaAplicada> vacinas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCorenCofen() {
        return corenCofen;
    }

    public void setCorenCofen(String corenCofen) {
        this.corenCofen = corenCofen;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<PlantaoEnfermeiro> getPlantaos() {
        return plantaos;
    }

    public void setPlantaos(List<PlantaoEnfermeiro> plantaos) {
        this.plantaos = plantaos;
    }

    public List<ExamePaciente> getExames() {
        return exames;
    }

    public void setExames(List<ExamePaciente> exames) {
        this.exames = exames;
    }

    public List<VacinaAplicada> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<VacinaAplicada> vacinas) {
        this.vacinas = vacinas;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    public String toString() {
        if (Sexo.FEMININO.equals(getSexo())) {
            return nome + " - " + especialidade + " - Enfermeira";
        } else {
            return nome + " - " + especialidade + " - Enfermeiro";
        }
    }

}
