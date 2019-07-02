/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao.banco.impl;

import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.dao.banco.GenericDAO;
import br.com.clinica.domain.Usuario;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class UsuarioDaoImpl extends GenericDAO<Usuario> {

    public Usuario logarUsuario(String login, String senha) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        try {
            Query crit = sessao.createQuery("Select u FROM Usuario as u where u.login =:login AND u.senha = :senha");
            crit.setParameter("login", login);
            crit.setParameter("senha", senha);
            return (Usuario) crit.getSingleResult();
        } catch (RuntimeException erro) {
            return null;
        } finally {
            sessao.close();
        }
    }
}
