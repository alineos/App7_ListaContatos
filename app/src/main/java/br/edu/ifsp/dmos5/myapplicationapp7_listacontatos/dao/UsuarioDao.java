package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao;

import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Usuario;

public interface UsuarioDao {

    void addUsuario(Usuario user);

    Usuario findById (int id);

    Usuario findByUserName (String user);

    List<Usuario> findAll();

}
