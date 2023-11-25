package com.mycompany.dao;

import com.mycompany.databaseconnectiontest.SQLiteDBManager;
import com.mycompany.model.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GroupDAO {
    public void insert(Group grupo) throws SQLException {
        String insertDataSQL = "INSERT INTO group "
                             + "(group_id, nome) "
                             + "VALUES ("
                             + "'" + grupo.getGrupoId() + "',"
                             + "'" + grupo.getNome()  +  "')";
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(insertDataSQL);
        stmt.execute();
        stmt.close();
        dbManager.disconnect();
        System.out.println("Dados inseridos com sucesso.");
    }
    
    public Group getById(int id) throws SQLException{
        String querySQL = "SELECT * FROM groups WHERE group_id = " + id;
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(querySQL);
        ResultSet resultSet = stmt.executeQuery();
        
        if (resultSet.next()) {
            String nome = resultSet.getString("name");
            stmt.close();
            dbManager.disconnect();
            return new Group(id, nome);
        }else{
            return null;
        }
    }
    
    public void update(Group grupo) throws SQLException{
        String updateSQL = "UPDATE groups SET "
                         + "name = '" + grupo.getNome()
                         + "WHERE grupo_id = " + grupo.getGrupoId();
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
        String deleteSQL = "DELETE FROM groups WHERE groups_id = " + id;
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
        stmt.executeUpdate();
        stmt.close();
        dbManager.disconnect();
        System.out.println("Dados deletados com sucesso.");
    }
    
    public List<Group> getAll() throws SQLException{
        List<Group> groups = new ArrayList<>();
        String querySQL = "SELECT * FROM groups";
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(querySQL);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("group_id");
            String name = resultSet.getString("name");
            groups.add(new Group(id, name));
        }
        stmt.close();
        dbManager.disconnect();
        return groups;
    }
}
