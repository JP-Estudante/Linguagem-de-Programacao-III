package com.mycompany.databaseconnectiontest;

import com.mycompany.dao.ContactsDAO;
import com.mycompany.model.Contact;
import java.sql.SQLException;

public class B_InserirContato {
    
    public static void main(String[] args) throws SQLException {
        Contact contato = new Contact("Maria",
                                       "Silva",
                                         "maria@maria.com",
                                         "54999999999");
        ContactsDAO contactDao = new ContactsDAO();
        contactDao.insert(contato);
    }
    
}
