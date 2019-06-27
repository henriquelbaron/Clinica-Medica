package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Plantao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PlantaoDaoImpl extends GenericDAO<Plantao> {

    public List<String> getPlantoesDia(String data) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Medico.nome,Enfermeiro.nome FROM Plantao as p where p.data =" + data);
            return crit.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
