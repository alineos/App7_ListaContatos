package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao;

import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Contato;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Usuario;

public interface ContatoDao {

    void addContato(Contato contato);

    Contato findById (int id);

    List<Contato> findAll();

    List<Contato> findAllByUser(Usuario user);

    List<Contato> findAllByUserId(int user);

    Contato findByTel(String telefone);



}
