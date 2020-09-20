package com.example.brainationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextView txtRegister;
    ImageView imgVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        imgVoltar=findViewById(R.id.image_login_voltar);
        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });

        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ListaActivity.class));
            }
        });
        txtRegister=findViewById(R.id.forgot_password);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Projeto em andamento", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void sussa(View view) {
        Toast.makeText(getApplicationContext(), "Projeto em andamento", Toast.LENGTH_SHORT).show();
    }

    public void senha(View view) {
        Toast.makeText(getApplicationContext(), "Projeto em andamento", Toast.LENGTH_SHORT).show();
    }
}
