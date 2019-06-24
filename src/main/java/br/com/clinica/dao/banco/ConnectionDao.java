package br.com.clinica.dao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDao {

    protected Connection conn;

    protected PreparedStatement pstt;

    protected ResultSet rs;

    public ConnectionDao() {
        this.conn = SessionFactory.getConnect();

    }

}
