package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Plantao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date data;
    @ManyToMany(mappedBy = "plantaos")
    private List<Medico> medicos;
    @ManyToMany(mappedBy = "plantaos")
    private List<Enfermeiro> enfermeiros;

}
