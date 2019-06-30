package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Paciente;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class AtendenteDaoImp extends GenericDAO<Atendente> {

    public Atendente atendenteLogar(String email, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select a FROM Atendente as a where a.senha = :senha AND a.email = :email");
            q.setParameter("email", email);
            q.setParameter("senha", senha);
            return (Atendente) q.getSingleResult();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }

    public List<Atendente> findPaciente(String termo) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select p From Atendente as p where p.nome like :termo");
            q.setParameter("termo", "%" + termo + "%");
            return q.getResultList();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }
}
