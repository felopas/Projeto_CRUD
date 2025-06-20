package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/agenda_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver"); 
            System.out.println("Conectado ao banco de dados com sucesso!");
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Driver do PostgreSQL não encontrado. Verifique se o JAR foi adicionado ao projeto.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Falha ao conectar ao banco de dados. Verifique a URL, usuário e senha.");
            e.printStackTrace();
        }
        return null;
    }
}
