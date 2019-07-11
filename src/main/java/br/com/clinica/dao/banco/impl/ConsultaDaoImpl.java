package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Consulta;
import br.com.clinica.util.DataUtils;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class ConsultaDaoImpl extends GenericDAO<Consulta> {

    public List<Consulta> consultaDoMedico(int idMedico) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select c from Consulta as c WHERE c.medico.id= :idMedico AND c.realizada = 0 ");
            q.setParameter("idMedico", idMedico);
            return (List<Consulta>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Consulta> consultaDoMedicoNome(int idMedico, String nome) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select c from Consulta as c WHERE c.medico.id= :idMedico AND c.realizada = 0 AND c.paciente.nome like :nome");
            q.setParameter("idMedico", idMedico);
            q.setParameter("nome", "%" + nome + "%");
            return (List<Consulta>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Consulta> consultaDoMedicoData(int idMedico, Date data) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            String hql = "Select c from Consulta as c WHERE c.medico.id= :idMedico AND c.realizada = 0 AND c.ocupacaoSala.data BETWEEN :data AND :amanha";
            Query q = sessao.createQuery(hql);
            q.setParameter("idMedico", idMedico);
            q.setParameter("data", data);
            q.setParameter("amanha", DataUtils.addDiaData(data, 1));
            return (List<Consulta>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
