package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Telefone;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class TelefoneDaoImpl extends GenericDAO<Telefone> {

    public List<Telefone> getTelefonesPaciente(int id) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select t FROM Telefone as t where t.paciente.id =:idPessoa");
            crit.setParameter("idPessoa", id);
            return crit.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
