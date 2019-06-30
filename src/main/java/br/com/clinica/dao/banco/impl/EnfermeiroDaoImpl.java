package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Enfermeiro;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class EnfermeiroDaoImpl extends GenericDAO<Enfermeiro> {

    public Enfermeiro enfermeiroLogar(String email, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select e FROM Enfermeiro as e where e.senha = :senha AND e.email = :email");
            q.setParameter("email", email);
            q.setParameter("senha", senha);
            return (Enfermeiro) q.getSingleResult();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }

    public List<Enfermeiro> getPlantoesDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select e from Enfermeiro as e LEFT JOIN e.plantaos as p WHERE p.data= :data");
            q.setParameter("data", dataDesejada);
            return (List<Enfermeiro>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Enfermeiro> getPlantoes() {
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

    public List<Enfermeiro> findPaciente(String termo) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select p From Enfermeiro as p where p.nome like :termo");
            q.setParameter("termo", "%" + termo + "%");
            return q.getResultList();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }
}
