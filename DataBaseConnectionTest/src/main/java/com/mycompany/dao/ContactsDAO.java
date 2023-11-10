package com.mycompany.dao;

import com.mycompany.databaseconnectiontest.SQLiteDBManager;
import com.mycompany.model.Contact;
import com.mycompany.model.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactsDAO {

    public void insert(Contact contato) throws SQLException {
        String insertDataSQL = "INSERT INTO contacts "
                             + "(first_name, last_name, email, phone) "
                             + "VALUES ("
                             + "'" + contato.getFirstName() + "',"
                             + "'" + contato.getLastName()  + "',"
                             + "'" + contato.getEmail()     + "',"
                             + "'" + contato.getPhone()     + "')";
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(insertDataSQL);
        stmt.execute();
        stmt.close();
        dbManager.disconnect();
        System.out.println("Dados inseridos com sucesso.");
    }
    
    public Contact getById(int id) throws SQLException{
        String querySQL = "SELECT * FROM contacts WHERE contact_id = " + id;
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(querySQL);
        ResultSet resultSet = stmt.executeQuery();
        
        if (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String telefone = resultSet.getString("phone");
            stmt.close();
            dbManager.disconnect();
            return new Contact(id, firstName, lastName, email, telefone);
        }else{
            return null;
        }
    }
    
    public void update(Contact contato) throws SQLException{
        String updateSQL = "UPDATE contacts SET "
                         + "first_name = '" + contato.getFirstName() + "', "
                         + "last_name = '" + contato.getLastName() + "', "
                         + "email = '" + contato.getEmail() + "' , "
                         + "phone = '" + contato.getPhone() + "' "
                         + "WHERE contact_id = " + contato.getContactId();
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(updateSQL);
        stmt.executeUpdate();
        stmt.close();
        dbManager.disconnect();
        System.out.println("Dados atualizados com sucesso.");
    }
    
    public void delete(int id) throws SQLException{
        String deleteSQL = "DELETE FROM contacts WHERE contact_id = " + id;
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
        stmt.executeUpdate();
        stmt.close();
        dbManager.disconnect();
        System.out.println("Dados deletados com sucesso.");
    }
    
    public List<Contact> getAll() throws SQLException{
        List<Contact> contacts = new ArrayList<>();
        String querySQL = "SELECT * FROM contacts";
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(querySQL);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("contact_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String telefone = resultSet.getString("phone");
            contacts.add(new Contact(id, firstName, lastName, email,telefone));
        }
        stmt.close();
        dbManager.disconnect();
        return contacts;
    }
}

/*
Principais características de um objeto DAO:
    Abstração de Dados: Um DAO encapsula as operações de acesso a dados, como inserção, consulta, atualização e exclusão, em métodos específicos.
    Separação de Responsabilidades: O DAO separa a lógica de acesso a dados da lógica de negócios da aplicação, promovendo um design limpo e modular.
    Reutilização de Código: Uma vez que as operações de acesso a dados estão encapsuladas em objetos DAO, elas podem ser reutilizadas em toda a aplicação.
    Manutenção Facilitada: Mudanças na fonte de dados (por exemplo, a troca de um banco de dados SQL para um banco de dados NoSQL) podem ser feitas no DAO sem afetar a lógica de negócios.
    Segurança: Os DAOs podem ser usados para aplicar camadas de segurança, como controle de acesso aos dados.
*/