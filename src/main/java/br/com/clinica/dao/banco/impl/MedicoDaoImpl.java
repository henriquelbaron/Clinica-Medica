package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Medico;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class MedicoDaoImpl extends GenericDAO<Medico> {

    public Medico medicoLogar(String email, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select m FROM Medico as m where m.senha = :senha AND m.email = :email");
            q.setParameter("email", email);
            q.setParameter("senha", senha);
            return (Medico) q.getSingleResult();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }

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

    public List<Medico> getPlantoes() {
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

    public List<Medico> findPaciente(String termo) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select p From Medico as p where p.nome like :termo");
            q.setParameter("termo", "%" + termo + "%");
            return q.getResultList();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }
}
