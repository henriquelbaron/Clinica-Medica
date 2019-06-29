package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class PlantaoDaoImpl extends GenericDAO<Plantao> {

    public List<Medico> getPlantoesDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select m from Medico as m LEFT JOIN m.plantaos as p WHERE p.data= :data");
            q.setParameter("data", dataDesejada);
            return (List<Medico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Medico> getPlantoesMedicos() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select m from Medico as m LEFT JOIN m.plantaos");
            return (List<Medico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
