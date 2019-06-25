/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.ConnectionFactory;
import org.hibernate.Session;

/**
 *
 * @author Henrique Baron
 */
public class main {
    public static void main(String[] args) {
        Session sessao = ConnectionFactory.getFabricaDeSessoes().openSession();
        sessao.close();
        ConnectionFactory.getFabricaDeSessoes().close();
    }
}
