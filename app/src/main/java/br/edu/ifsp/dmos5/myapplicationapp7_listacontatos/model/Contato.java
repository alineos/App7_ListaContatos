package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model;

public class Contato {

    private String apelido;
    private String nomeCompleto;
    private String telefone;
    private Usuario usuario;

    public Contato() {

    }

    public Contato(String apelido, String nomeCompleto, String telefone, Usuario usuario) {
        this.apelido = apelido;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.usuario = usuario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
