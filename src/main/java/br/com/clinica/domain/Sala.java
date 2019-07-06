package br.com.clinica.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String numero;

    private String descrição;

    private int prioridade;

    @OneToMany(mappedBy = "sala", targetEntity = OcupacaoSala.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OcupacaoSala> ocupacaoSalas;

    @ManyToOne
    @JoinColumn(name = "idFuncao")
    private Funcao funcao;

    public Sala() {
    }

    public Sala(String numero, int prioridade, Funcao funcao) {
        this.numero = numero;
        this.prioridade = prioridade;
        this.funcao = funcao;
    }

    public List<OcupacaoSala> getOcupacaoSalas() {
        return ocupacaoSalas;
    }

    public void setOcupacaoSalas(List<OcupacaoSala> ocupacaoSalas) {
        this.ocupacaoSalas = ocupacaoSalas;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero;
    }

}
