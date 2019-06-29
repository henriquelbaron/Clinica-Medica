/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Henrique Baron
 */
public class GenericDAO<Entidade> {

    private Class<Entidade> classe;

    public GenericDAO() {
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public boolean salvar(Entidade entidade) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
            return true;
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            System.out.println(erro.getMessage());
            return false;
        } finally {
            sessao.close();
        }
    }

    public List<Entidade> listar() {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            List<Entidade> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public Entidade buscar(Integer codigo) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.idEq(codigo));
            Entidade resultado = (Entidade) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Entidade entidade) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void editar(Entidade entidade) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.update(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
