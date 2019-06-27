package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Paciente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PacienteDaoImpl extends GenericDAO<Paciente> {

    public List<Paciente> findPaciente(String termo) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Criteria crit = sessao.createCriteria(Paciente.class);
            crit.add(Restrictions.like("nome", "%" + termo + "%"));
            return crit.list();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
