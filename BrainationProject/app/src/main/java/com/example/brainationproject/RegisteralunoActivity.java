package com.example.brainationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisteralunoActivity extends AppCompatActivity {
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeraluno_activity);
        btnRegister=findViewById(R.id.btnRegisterA);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisteralunoActivity.this,LoginActivity.class));
            }
        });
    }

    public void sussa2(View view) {
        Toast.makeText(getApplicationContext(), "Projeto em andamento", Toast.LENGTH_SHORT).show();
    }
}
