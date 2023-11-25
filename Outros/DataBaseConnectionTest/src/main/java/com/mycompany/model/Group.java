package com.mycompany.model;


public class Group {
    private int grupoId;
    private String nome;
    
    public Group(){
        
    }
    
    public Group(String nome){
        this.nome = nome;
    }
    
    public Group(int id, String nome){
        this.grupoId = id;
        this.nome = nome;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}