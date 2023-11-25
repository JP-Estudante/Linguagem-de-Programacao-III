
package com.mycompany.databaseconnectiontest;

import com.mycompany.dao.ContactsDAO;
import java.sql.SQLException;

public class E_DeletarContato {
    
    public static void main(String[] args) throws SQLException {
        ContactsDAO contactDao = new ContactsDAO();
        contactDao.delete(2);
    }
    
}
