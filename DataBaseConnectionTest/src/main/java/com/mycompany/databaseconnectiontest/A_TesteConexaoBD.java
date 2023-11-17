package com.mycompany.databaseconnectiontest;

import java.sql.SQLException;

public class A_TesteConexaoBD {
    public static void main(String[] args) throws SQLException {
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        dbManager.disconnect();
    }
}
