package com.example.brainationproject.ClassePessoa;

public class Pessoa {

    private String uid;
    private String nome;
    private String email;
    private String senha;

    public Pessoa(){

    }

    public String getUid(){
        return uid;
    }
    public void  setUid(String uid){
        this.uid=uid;
    }
    public String getNome(){
        return nome;
    }
    public void  setNome(String nome){
        this.nome=nome;
    }
    public String getEmail(){
        return email;
    }
    public void  setEmail(String email){
        this.email=email;
    }
    public String getSenha(){
        return senha;
    }
    public void  setSenha(String senha){
        this.senha=senha;
    }

    @Override
    public String toString(){
        return nome;
    }
}
