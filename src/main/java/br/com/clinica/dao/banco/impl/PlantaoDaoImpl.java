package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Plantao;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class PlantaoDaoImpl extends GenericDAO<Plantao> {

    public List<Medico> getPlantoesDia(Date data) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createSQLQuery("Select m.* FROM Plantao as p JOIN plantao_medico as pm ON p.id = pm.idMedico JOIN Medico as m on m.id = pm.idPlantao WHERE p.data = '29/06/2019'");
//            q.setParameter("data", data);
            return (List<Medico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
