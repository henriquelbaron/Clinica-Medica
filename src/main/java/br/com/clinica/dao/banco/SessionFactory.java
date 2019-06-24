package br.com.clinica.dao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SessionFactory {

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection connect;

    public static Connection getConnect() {
        return null;
    }

    public static void closeConnection(Connection conn, PreparedStatement pstt) {

    }

}
