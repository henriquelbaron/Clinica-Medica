package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import br.com.clinica.util.Utils;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;

public class PlantaoDaoImpl extends GenericDAO<Plantao> {
    
     public List<Plantao> getPlantoesDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select p from Plantao as p LEFT JOIN Medico as m WHERE p.data BETWEEN :data AND :amanha");
            q.setParameter("data", dataDesejada);
            q.setParameter("amanha", Utils.addDiaData(dataDesejada, 1));
            return (List<Plantao>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public List<Medico> getPlantoesMedicoDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
//            Query q = sessao.createQuery("Select m from Medico as m LEFT JOIN m.plantaos as p WHERE p.data= :data");
            Query q = sessao.createQuery("Select m from Medico as m LEFT JOIN m.plantaos as p WHERE p.data BETWEEN :data AND :amanha");
            q.setParameter("data", dataDesejada);
            q.setParameter("amanha", Utils.addDiaData(dataDesejada, 1));
            return (List<Medico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Enfermeiro> getPlantoesEnfermeiroDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
//            Query q = sessao.createQuery("Select m from Medico as m LEFT JOIN m.plantaos as p WHERE p.data= :data");
            Query q = sessao.createQuery("Select e from Enfermeiro as e LEFT JOIN e.plantaos as p WHERE p.data BETWEEN :data AND :amanha");
            q.setParameter("data", dataDesejada);
            q.setParameter("amanha", Utils.addDiaData(dataDesejada, 1));
            return (List<Enfermeiro>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
//"Select m from M as m WHERE m.id= :idMedico AND c.realizada = 0 AND c.data BETWEEN :data AND :amanha"
    
    public List<Medico> getPlantoesMedicos() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select DISTINCT m from Medico as m LEFT JOIN m.plantaos");
            return (List<Medico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Enfermeiro> getPlantoesEnfermeiros() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select e from Enfermeiro as e LEFT JOIN e.plantaos");
            return (List<Enfermeiro>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
