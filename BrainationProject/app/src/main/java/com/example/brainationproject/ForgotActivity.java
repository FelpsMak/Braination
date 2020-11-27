package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    EditText edtTextEmail;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);
    }
        public void recuperar(View view){
            firebaseAuth = FirebaseAuth.getInstance();
            edtTextEmail = findViewById(R.id.edit_text_alterar_password);

            firebaseAuth.sendPasswordResetEmail(edtTextEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotActivity.this, "Verifique seu email.", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(ForgotActivity.this, "Aconteceu um erro, tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
}