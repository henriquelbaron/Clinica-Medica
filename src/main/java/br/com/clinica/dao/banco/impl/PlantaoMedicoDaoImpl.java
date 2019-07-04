/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.util.Utils;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class PlantaoMedicoDaoImpl extends GenericDAO<PlantaoMedico> {

    public List<PlantaoMedico> getPlantoesMedicoDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("Select pm from PlantaoMedico as pm WHERE p.data BETWEEN :data AND :amanha");
            q.setParameter("data", dataDesejada);
            q.setParameter("amanha", Utils.addDiaData(dataDesejada, 1));
            return (List<PlantaoMedico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<PlantaoMedico> getPlantoesMedico() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("from PlantaoMedico");
            return (List<PlantaoMedico>) q.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
