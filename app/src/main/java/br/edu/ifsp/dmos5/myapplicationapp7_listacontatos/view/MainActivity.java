package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.R;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.ContatoDao;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.ContatoDaoImp;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.UsuarioDaoImp;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Contato;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUsuario;
    private EditText txtSenha;
    private Button btnLogin;
    private Button btnNewUser;

    private Usuario user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSenha =findViewById(R.id.txtSenha);
        txtUsuario = findViewById(R.id.txtUsuario);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnNewUser = findViewById(R.id.btnNewUser);
        btnNewUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == btnNewUser){
            showNewUser();
        }
        if (view == btnLogin){
            if (verificaDados()){
                showContatcts(); //validar usuario e senha
            }
        }

    }

    private boolean verificaDados() {

        if (txtUsuario.getText().toString().trim().isEmpty() || txtSenha.getText().toString().trim().isEmpty()){
            Toast.makeText(this, getString(R.string.usuarioOuSenhaInvalidos), Toast.LENGTH_SHORT).show();
            return false;
        }
        if ( UsuarioDaoImp.getInstance().findByUserName(txtUsuario.getText().toString()) == null){
            Toast.makeText(this, getString(R.string.usuarioNaoCadastrado), Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if (!UsuarioDaoImp.getInstance().findByUserName(txtUsuario.getText().toString()).getSenha().equals(txtSenha.getText().toString())){
                Toast.makeText(this, getString(R.string.senhaInvalida), Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        user = UsuarioDaoImp.getInstance().findByUserName(txtUsuario.getText().toString());
        return true;
    }

    private void showContatcts() {
        Bundle bundle = new Bundle();
        bundle.putInt("userId", user.getId());

        Intent intent = new Intent(this, ContactsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void showNewUser() {

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,NewUserActivity.class);
        startActivity(intent);
    }
}