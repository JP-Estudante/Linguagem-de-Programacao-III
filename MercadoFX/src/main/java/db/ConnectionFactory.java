package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection connection = null;
    private String databaseName = "mydatabase.db";

    public ConnectionFactory() {
        // Inicialização, se necessário
    }

    // Método para obter a conexão
    public Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar o estado da conexão: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    // Método para fechar a conexão
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão com o banco de dados encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método privado para estabelecer a conexão
    private void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite não encontrado: " + e.getMessage());
            e.printStackTrace();
            throw new SQLException("Driver SQLite não encontrado.", e);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            throw new SQLException("Erro ao conectar ao banco de dados.", e);
        }
    }
}


