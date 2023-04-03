package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Contato;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Usuario;

public class ContatoDaoImp implements ContatoDao {

    private final List<Contato> database;
    private static ContatoDaoImp instancia;

    private ContatoDaoImp() {
        database = new ArrayList<>();
    }

    public static synchronized ContatoDaoImp getInstance() {
        if (instancia == null) {
            instancia = new ContatoDaoImp();
        }
        return instancia;
    }

    @Override
    public void addContato(Contato contato) {
        if (contato != null) {
            database.add(contato);
        }
    }

    @Override
    public Contato findById(int id) {
        return database.get(id);
    }

    @Override
    public List<Contato> findAll() {
        return database;
    }

    @Override
    public List<Contato> findAllByUser(Usuario user) {
        List<Contato> retorno = new ArrayList<>();

        for (Contato cont : database) {
            if (cont.getUsuario() == user) {
                retorno.add(cont);
            }
        }
        return retorno;
    }

    @Override
    public List<Contato> findAllByUserId(int user) {
        List<Contato> retorno = new ArrayList<>();

        for (Contato cont : database) {
            if (cont.getUsuario().getId() == user) {
                retorno.add(cont);
            }
        }
        return retorno;
    }

    @Override
    public Contato findByTel(String telefone) {
        return database.stream()
                .filter(user1 -> user1.getTelefone().equals(telefone))
                .findAny()
                .orElse(null);

    }

}
