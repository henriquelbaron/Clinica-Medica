/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Usuario;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class UsuarioDaoImpl extends GenericDAO<Usuario> {

    public boolean logarUsuario(String login, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select u FROM Pessoa as u where u.login =:login AND u.senha = :senha");
            crit.setParameter("login", login);
            crit.setParameter("senha", senha);
            return crit.getResultList().isEmpty();
        } catch (RuntimeException erro) {
            return false;
        } finally {
            sessao.close();
        }
    }

    public Medico verificaMedico(String login, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select m FROM Medico as m JOIN m.usuario as u where u.login =:login AND u.senha = :senha");
            crit.setParameter("login", login);
            crit.setParameter("senha", senha);
            return (Medico) crit.getSingleResult();
        } catch (RuntimeException erro) {
            System.out.println("Erro ao verificar Medico");
            return null;
        } finally {
            sessao.close();
        }
    }

    public Enfermeiro verificaEnfermeiro(String login, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select m FROM Enfermeiro as m JOIN m.usuario as u where u.login =:login AND u.senha = :senha");
            crit.setParameter("login", login);
            crit.setParameter("senha", senha);
            return (Enfermeiro) crit.getSingleResult();
        } catch (RuntimeException erro) {
            System.out.println("Erro ao verificar Enfermeiro");
            return null;
        } finally {
            sessao.close();
        }
    }

    public Atendente verificaAtendente(String login, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select m FROM Atendente as m JOIN m.usuario as u where u.login =:login AND u.senha = :senha");
            crit.setParameter("login", login);
            crit.setParameter("senha", senha);
            return (Atendente) crit.getSingleResult();
        } catch (RuntimeException erro) {
            System.out.println("Erro ao verificar Atendente");
            return null;
        } finally {
            sessao.close();
        }
    }
}
