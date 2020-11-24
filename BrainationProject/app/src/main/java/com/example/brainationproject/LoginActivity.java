package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText cxemail;
    EditText cxpass;
    Button btnLoginAluno;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);
        mAuth = FirebaseAuth.getInstance();

        cxemail=findViewById(R.id.email_text_login);
        cxpass=findViewById(R.id.pass_text_login);

        txtRegister=findViewById(R.id.forgot_password);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotActivity.class));
            }
        });

        btnLoginAluno=findViewById(R.id.btn_login_aluno);
        btnLoginAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password;

                email = cxemail.getText().toString();
                password = cxpass.getText().toString();

                if(!email.trim().isEmpty() && !password.trim().isEmpty()){
                    doLogin(email, password);
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha os Campos Vazios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void doLogin(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("autenticado", "autenticado");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, ListaAlunoActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void sussa(View view) {
        Toast.makeText(getApplicationContext(), "Projeto em andamento", Toast.LENGTH_SHORT).show();
    }

    public void senha(View view) {
        Toast.makeText(getApplicationContext(), "Projeto em andamento", Toast.LENGTH_SHORT).show();
    }
}
