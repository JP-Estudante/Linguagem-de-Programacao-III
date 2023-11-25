package com.mycompany.databaseconnectiontest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDBManager {
    private Connection connection = null;
    private String databaseName = "mydatabase.db";
    
    public void connect() throws SQLException {
        if (connection != null){
            return;
        }       
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            System.out.println("Conexão com o banco de dados estabelecida");
        } catch (ClassNotFoundException e){
            throw new SQLException("Driver SQLite não encontrado", e);
        }
    }
    
    public void disconnect(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Conexão com o Banco de Dados encerrada!");
            } catch (SQLException e){
                System.out.println("Erro ao fechar a conexção: " + e.getMessage());
            }
        }
    }
    
    public Connection getConnection() throws SQLException {
        return connection;
    }
}
