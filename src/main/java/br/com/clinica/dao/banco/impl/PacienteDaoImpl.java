package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Paciente;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PacienteDaoImpl extends GenericDAO<Paciente> {

    public List<Paciente> findPaciente(String termo) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try { 
            Query q = sessao.createQuery("Select p From Paciente as p where p.nome like :termo");
            q.setParameter("termo", "%"+termo+"%");
            return q.getResultList();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }

    @Override
    public List<Paciente> listar() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select p From Paciente as p");
            return q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
