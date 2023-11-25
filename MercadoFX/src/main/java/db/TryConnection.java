package db;

import java.sql.SQLException;

public class TryConnection {
    public static void main(String[] args) throws SQLException {
        SQLiteDBManager dbManager = new SQLiteDBManager();
        dbManager.connect();
        dbManager.disconnect();
    }
}
