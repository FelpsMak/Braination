package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisteralunoActivity extends AppCompatActivity {
    Button btnRegister;
    FirebaseAuth mAuth;
    EditText Rnome, Remail, Rsenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeraluno_activity);

        String name, email, senha;
        btnRegister=findViewById(R.id.btnRegisterA);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisteralunoActivity.this,LoginActivity.class));
            }}
        Rnome=findViewById(R.id.edit_text_nome);
        Remail=findViewById(R.id.edit_text_email);
        Rsenha=findViewById(R.id.edit_text_senha);
        name=Rnome.getText().toString();
        email=Remail.getText().toString();
        senha=Rsenha.getText().toString();


        registerNewUser(name, email, senha);

    }
    private void registerNewUser(String name, String email, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                        }
                        else {
                            Toast.makeText(RegisteralunoActivity.this, "Authentication failed",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }


}
