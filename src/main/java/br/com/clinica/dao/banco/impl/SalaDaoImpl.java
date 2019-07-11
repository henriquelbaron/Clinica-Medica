package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Sala;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class SalaDaoImpl extends GenericDAO<Sala> {

    @Override
    public List<Sala> listar() {
        Session session = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = session.createQuery("from Sala");
            return (List<Sala>) q.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao listar Salas");
            return null;
        } finally {
            session.close();
        }
    }
}
