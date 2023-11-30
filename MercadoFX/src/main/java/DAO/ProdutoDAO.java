package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Categoria;
import Models.Produto;
import db.ConnectionFactory;

public class ProdutoDAO {

    private Connection connection;
    private CategoriaDAO categoriaDAO;

    public ProdutoDAO(ConnectionFactory connectionFactory) {
        try {
            this.connection = connectionFactory.getConnection();
            this.categoriaDAO = new CategoriaDAO(this.connection);
        } catch (SQLException e) {
            System.err.println("Erro ao obter a conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Produto getByCodBarras(String codBarras) {
        String sql = "SELECT * FROM Produto WHERE cod_barras = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codBarras);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String idProduto = resultSet.getString("id_produto");
                String nomeProduto = resultSet.getString("nome_produto");
                double valorProduto = resultSet.getDouble("valor_produto");
                int idCategoria = resultSet.getInt("id_categoria");
                codBarras = resultSet.getString("cod_barras");

                Categoria categoria = categoriaDAO.getCategoriaById(idCategoria);

                return new Produto(idProduto, nomeProduto, valorProduto, categoria, codBarras);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return null; // Retorna null se nenhum produto for encontrado
    }
}
