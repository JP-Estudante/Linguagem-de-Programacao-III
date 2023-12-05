package DAO;

import Models.Desconto;
import Models.DescontoCategoria;
import Models.DescontoProdutos;
import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DescontoDAO {

    private ConnectionFactory connectionFactory;

    public DescontoDAO(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public double obterPorcentagemDesconto(int idProduto) {
        // Obtenha a conexão da ConnectionFactory
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT percentual FROM Desconto WHERE id_produto = ? AND data_inicio <= CURRENT_DATE AND data_fim >= CURRENT_DATE")) {
            statement.setInt(1, idProduto);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Recupere a porcentagem de desconto da coluna percentual
                return resultSet.getDouble("percentual");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }

        // Se não houver desconto, retorne 0.0 ou algum valor padrão
        return 0.0;
    }

    public Desconto getDescontoById(int id) {
        // Obtenha a conexão da ConnectionFactory
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Desconto WHERE id_desconto = ?")) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idProduto = resultSet.getInt("id_produto");
                int idCategoria = resultSet.getInt("id_categoria");
                double percentual = resultSet.getDouble("percentual");
                String cupom = resultSet.getString("cupom");
                Date dataInicio = resultSet.getDate("data_inicio");
                Date dataFim = resultSet.getDate("data_fim");

                if (idProduto != 0) {
                    return new DescontoProdutos(idProduto, percentual);
                } else if (idCategoria != 0) {
                    return new DescontoCategoria(String.valueOf(idCategoria), percentual);
                } else {
                    // Lógica para lidar com outros tipos de desconto, se aplicável
                    // Por exemplo, desconto baseado na quantidade
                    // return new DescontoQuantidade(quantidadeMinima, percentual);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
