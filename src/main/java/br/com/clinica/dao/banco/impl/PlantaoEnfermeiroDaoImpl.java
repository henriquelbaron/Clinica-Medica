/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.PlantaoEnfermeiro;
import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.util.DataUtils;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class PlantaoEnfermeiroDaoImpl extends GenericDAO<PlantaoEnfermeiro> {

    public List<PlantaoEnfermeiro> getPlantoesEnfermeiroDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select pm from PlantaoEnfermeiro as pm WHERE p.data BETWEEN :data AND :amanha");
            q.setParameter("data", dataDesejada);
            q.setParameter("amanha", DataUtils.addDiaData(dataDesejada, 1));
            return (List<PlantaoEnfermeiro>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<PlantaoEnfermeiro> getPlantoesEnfermeiro() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("from PlantaoEnfermeiro");
            return (List<PlantaoEnfermeiro>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
