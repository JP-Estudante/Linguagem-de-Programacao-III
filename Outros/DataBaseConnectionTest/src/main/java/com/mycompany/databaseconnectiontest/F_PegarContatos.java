
package com.mycompany.databaseconnectiontest;

import com.mycompany.dao.ContactsDAO;
import com.mycompany.model.Contact;
import java.sql.SQLException;
import java.util.List;

public class F_PegarContatos {
    
    public static void main(String[] args) throws SQLException {
        ContactsDAO contactDao = new ContactsDAO();
        List<Contact> listaContatos = contactDao.getAll();
        
        for(Contact contato : listaContatos){
            System.out.println(contato);
        }
    }
    
}
