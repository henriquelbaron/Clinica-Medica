/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.OcupacaoSala;
import br.com.clinica.domain.Sala;
import br.com.clinica.util.DataUtils;
import java.util.Date;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class OcupacaoSalaDaoImpl extends GenericDAO<OcupacaoSala> {

    public boolean getOcupacaoSala(Sala sala ,Date data) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select os from OcupacaoSala as os WHERE os.sala = :sala AND os.data BETWEEN :data AND :amanha");
            q.setParameter("sala", sala);
            q.setParameter("data", data);
            q.setParameter("amanha", DataUtils.addMinutosData(data, 30));
            return q.getResultList().isEmpty();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
