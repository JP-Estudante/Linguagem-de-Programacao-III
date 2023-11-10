package com.mycompany.model;

public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Group grupo;

    // Construtor vazio
    public Contact() {
    }

    // Construtor com todos os campos
    public Contact(int id, String firstName, String lastName, String email, String phone) {
        this.contactId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    
    // Construtor com todos os campos, exceto contactId
    public Contact(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    
    // Construtor com todos os campos, exceto contactId
    public Contact(String firstName, String lastName, String email, String phone, Group grupo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.grupo = grupo;
    }
    
    // Getters e Setters
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Group getGrupo() {
        return grupo;
    }

    public void setGrupo(Group grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        String result = lastName.toUpperCase() + " " + firstName + ", " + email + " - " + phone;
        
        if(grupo != null) 
            result += " - " + grupo.getNome();
        
        return  result;
    }
}
