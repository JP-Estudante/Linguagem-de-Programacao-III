package DAO;

import Models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public Cliente getClienteById(int id) {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        Cliente cliente = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome_completo");
                String cpf = resultSet.getString("cpf");

                cliente = new Cliente(nome, cpf, id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return cliente;
    }
    

    public Cliente getClienteByCpf(String cpf) {
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";
        Cliente cliente = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome_completo");
                int id = resultSet.getInt("id_cliente");

                cliente = new Cliente(nome, cpf, id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return cliente;
    }

    

}
