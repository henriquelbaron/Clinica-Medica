package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Vacina;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class VacinaDaoImpl extends GenericDAO<Vacina> {

    @Override
    public List<Vacina> listar() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("FROM Vacina");
            return crit.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
