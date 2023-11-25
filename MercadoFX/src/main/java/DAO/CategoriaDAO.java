package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Categoria;

public class CategoriaDAO {

    private Connection connection;

    // Construtor que recebe a conexão
    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public Categoria getCategoriaById(int id) {
        Categoria categoria = null;

        // Query SQL para obter uma categoria pelo ID
        String sql = "SELECT * FROM Categoria WHERE id_categoria = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Substitui o parâmetro na query pelo valor do ID desejado
            preparedStatement.setInt(1, id);

            // Executa a query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verifica se há algum resultado
            if (resultSet.next()) {
                // Preenche a instância de Categoria com os dados do resultado
                categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("id_categoria"));
                categoria.setNomeCategoria(resultSet.getString("nome_categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lide com a exceção conforme necessário
        }

        return categoria;
    }
}
