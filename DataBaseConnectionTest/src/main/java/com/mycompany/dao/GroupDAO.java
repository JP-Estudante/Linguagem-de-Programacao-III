package com.mycompany.dao;

import com.mycompany.databaseconnectiontest.SQLiteDBManager;
import com.mycompany.model.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupDAO {
    
    public void insert(Group grupo) throws SQLException {
        String insertDataSQL = "INSERT INTO groups "
                             + "(group_id, name) "
                             + "VALUES ("
                             + "'" + grupo.getGrupoId() + "',"
                             + "'" + grupo.getNome()  + "')";
        
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        Connection conexao = dbManager.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(insertDataSQL);
        stmt.execute();
        stmt.close();
        dbManager.disconnect();
        
        System.out.println("Dados inseridos com sucesso.");
    }
    
    // Continua...
}
