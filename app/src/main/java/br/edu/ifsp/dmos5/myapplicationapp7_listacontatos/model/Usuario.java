package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model;

public class Usuario {

    private String UserName;
    private String senha;

    private int id;


    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Usuario(String userName, String senha, int id) {
        UserName = userName;
        this.senha = senha;
        this.id = id;

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
