package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Medico;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class ConsultaDaoImpl extends GenericDAO<Consulta> {

    public List<Consulta> consultaDoMedico(int idMedico) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select c from Consulta as c WHERE c.medico.id= :idMedico");
            q.setParameter("idMedico", idMedico);
            return (List<Consulta>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
