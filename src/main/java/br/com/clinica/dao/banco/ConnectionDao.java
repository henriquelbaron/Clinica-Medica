package br.com.clinica.dao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDao {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public ConnectionDao() {
        emf = Persistence.createEntityManagerFactory("clinica");
        em = emf.createEntityManager();
    }

    protected Connection conn;

    protected PreparedStatement pstt;

    protected ResultSet rs;

//    public ConnectionDao() {
//        this.conn = SessionFactory.getConnect();
//
//    }
}
