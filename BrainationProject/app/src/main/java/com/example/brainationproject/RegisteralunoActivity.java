package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brainationproject.ClassePessoa.Pessoa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegisteralunoActivity extends AppCompatActivity {
    Button btnRegister;
    FirebaseAuth mAuth;
    EditText Rnome, Remail, Rsenha;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeraluno_activity);

        mAuth = FirebaseAuth.getInstance();

        btnRegister = findViewById(R.id.btnRegisterAluno);
        Rnome = findViewById(R.id.edit_text_nome);
        Remail = findViewById(R.id.edit_text_email);
        Rsenha = findViewById(R.id.edit_text_senha);

        inicializarFirebase();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, senha;
                name = Rnome.getText().toString();
                email = Remail.getText().toString();
                senha = Rsenha.getText().toString();
                registerNewUser(name, email, senha);

            }
        });


    }

    private void registerNewUser(String name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("AAAAA", "aqui");
                        if (task.isSuccessful()) {
                            Pessoa p = new Pessoa();
                            p.setUid(mAuth.getUid());
                            p.setNome(Rnome.getText().toString());
                            p.setEmail(Remail.getText().toString());
                            p.setSenha(Rsenha.getText().toString());
                            databaseReference.child("Pessoa").child(p.getUid()).setValue(p);
                            limparCampos();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(RegisteralunoActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(RegisteralunoActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }


    private void inicializarFirebase() {
        FirebaseApp.initializeApp(RegisteralunoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void limparCampos() {
        Rnome.setText("");
        Remail.setText("");
        Rsenha.setText("");
    }

}