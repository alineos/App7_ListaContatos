package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.R;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.UsuarioDao;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.UsuarioDaoImp;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Usuario;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUserName;
    private EditText txtCadSenha;
    private EditText txtConfSenha;

    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtCadSenha = findViewById(R.id.txtCadSenha);
        txtConfSenha = findViewById(R.id.txtConfSenha);
        txtUserName = findViewById(R.id.txtUserName);
        btnSalvar = findViewById(R.id.btnSalvarUser);
        btnSalvar.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        if (view == btnSalvar) {
            addNewUser();
        }
    }

    private void addNewUser() {
        Usuario user = new Usuario(txtUserName.getText().toString()
                , txtCadSenha.getText().toString()
                ,UsuarioDaoImp.getInstance().getDatabase().size()+1);


        if (validaDados()) {
             UsuarioDaoImp.getInstance().addUsuario(user);
        }

//        Log.d("TESTE", "entrei");
//        for (Usuario userMan :  UsuarioDaoImp.getInstance().findAll()) {
//            Log.d("TESTE",userMan.getId()+" - " + userMan.getUserName());
//        }
//        Log.d("TESTE", "Sai");
    }

    private boolean validaDados() {
        if (txtUserName.getText().toString().isEmpty()
                || txtCadSenha.getText().toString().isEmpty()
                || txtConfSenha.getText().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.usuarioouSenhaVazio), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!txtCadSenha.getText().toString().equals(txtConfSenha.getText().toString())) {
            Toast.makeText(this, getString(R.string.senhasNaoCoicidem), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (UsuarioDaoImp.getInstance().findByUserName(txtUserName.getText().toString()) != null){
            Toast.makeText(this, getString(R.string.usuarioJaCadastrado), Toast.LENGTH_SHORT).show();
            return false;
        }

        Toast.makeText(this, getString(R.string.usuarioCadastrado), Toast.LENGTH_SHORT).show();
        return true;
    }
}
