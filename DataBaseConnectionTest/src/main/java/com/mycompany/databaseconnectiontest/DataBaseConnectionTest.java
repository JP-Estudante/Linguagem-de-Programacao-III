package com.mycompany.databaseconnectiontest;

import com.mycompany.dao.ContactsDAO;
import com.mycompany.model.Contact;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    public static void main(String[] args) throws SQLException {
        ContactsDAO contactDao = new ContactsDAO();
        Contact contato = contactDao.getById(3);
        System.out.println(contato);
        
    }
}
