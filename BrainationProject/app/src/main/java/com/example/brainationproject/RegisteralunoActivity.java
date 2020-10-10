package com.example.brainationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


}
