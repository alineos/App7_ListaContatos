package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Usuario;

public class UsuarioDaoImp implements UsuarioDao {

    private final List<Usuario> database ;
    private static  UsuarioDaoImp instancia ;

    private UsuarioDaoImp() {
        database = new ArrayList<>();
        database.add(new Usuario("teste","teste",1));
    }
    public static synchronized UsuarioDaoImp getInstance(){
        if(instancia==null){
            instancia = new UsuarioDaoImp();
        }
        return instancia;
    }

    @Override
    public void addUsuario(Usuario user) {
        if (user != null) {
            database.add(user);
        }
    }

    @Override
    public Usuario findById(int id) {
        return database.get(id-1);
    }

    @Override
    public Usuario findByUserName(String user) {
        return database.stream()
                .filter(user1 -> user1.getUserName().equals(user))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return database;
    }

    public List<Usuario> getDatabase() {
        return database;
    }
}
