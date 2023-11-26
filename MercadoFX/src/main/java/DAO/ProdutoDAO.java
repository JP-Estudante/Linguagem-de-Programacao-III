package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Produto;

public class ProdutoDAO {

    private Connection connection;

    public Produto getByCodBarras(String codBarras) {
        String sql = "SELECT * FROM Produto WHERE cod_barras = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codBarras);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Produto(
                        resultSet.getString("id_produto"),
                        resultSet.getString("nome_produto"),
                        resultSet.getDouble("valor_produto"),
                        resultSet.getInt("id_categoria"),
                        resultSet.getString("cod_barras"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Se nada for encontrado com o código de barras
    }

}
