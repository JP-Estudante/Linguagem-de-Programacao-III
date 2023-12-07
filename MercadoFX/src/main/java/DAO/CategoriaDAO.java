package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Categoria;
import db.ConnectionFactory;

public class CategoriaDAO {

    private Connection connection;

    // Construtor que recebe a conexão
    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    // Construtor que recebe uma ConnectionFactory
    public CategoriaDAO(ConnectionFactory connectionFactory) {
        try {
            this.connection = connectionFactory.getConnection();
        } catch (SQLException e) {
            System.err.println("Erro ao obter a conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Categoria getCategoriaById(int id) {
        Categoria categoria = null;

        // Query SQL para obter uma categoria pelo ID
        String sql = "SELECT * FROM Categoria WHERE id_categoria = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            // Executa a query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verifica se há algum resultado
            if (resultSet.next()) {
                categoria = Categoria.fromResultSet(resultSet);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            // System.err.println("Erro ao executar a consulta SQL para a categoria: " + e.getMessage());
        }

        return categoria;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
