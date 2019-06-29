package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
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

}
