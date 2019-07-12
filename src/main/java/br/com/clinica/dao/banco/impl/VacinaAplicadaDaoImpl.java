/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.VacinaAplicada;
import br.com.clinica.util.DataUtils;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class VacinaAplicadaDaoImpl extends GenericDAO<VacinaAplicada> {

    public List<VacinaAplicada> naoAplicadas() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select va FROM VacinaAplicada as va where va.aplicada = 0");
            return crit.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<VacinaAplicada> vacinaPorData(Date data) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select va FROM VacinaAplicada as va JOIN va.ocupacaoSala as o WHERE  o.data BETWEEN :data AND :amanha");
            crit.setParameter("data", data);
            crit.setParameter("amanha", DataUtils.addDiaData(data, 1));
            return (List<VacinaAplicada>) crit.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    @Override
    public List<VacinaAplicada> listar() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select va FROM VacinaAplicada as va");
            return crit.getResultList();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
