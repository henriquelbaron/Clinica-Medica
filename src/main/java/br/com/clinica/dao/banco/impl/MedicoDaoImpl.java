package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Paciente;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

}
