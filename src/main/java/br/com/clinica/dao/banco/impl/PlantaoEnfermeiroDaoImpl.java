/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.PlantaoEnfermeiro;
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

    public List<PlantaoEnfermeiro> findPlantaoEnfermeiroPorNome(String nome) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("FROM PlantaoEnfermeiro as pm WHERE pm.enfermeiro.nome like :nome");
            q.setParameter("nome", "%" + nome + "%");
            return (List<PlantaoEnfermeiro>) q.getResultList();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
    }

    public boolean enfermeiroHasPlantao(Enfermeiro enfermeiro, Date data) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query q = sessao.createQuery("FROM PlantaoEnfermeiro as pm WHERE pm.enfermeiro.id = :enfermeiro AND pm.plantao.data = :data");
            q.setParameter("enfermeiro", enfermeiro.getId());
            q.setParameter("data", data);
            return q.getResultList().isEmpty();
        } catch (Exception e) {
            throw e;
        } finally {
            sessao.close();
        }
    }

    public List<PlantaoEnfermeiro> getPlantoesEnfermeiroDia(Date dataDesejada) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            dataDesejada = DataUtils.zerarHoras(dataDesejada);
            Query q = sessao.createQuery("FROM PlantaoEnfermeiro as pm WHERE pm.plantao.data BETWEEN :data AND :amanha");
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
