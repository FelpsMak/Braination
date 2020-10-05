package com.example.brainationproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
    public class RegisterprofActivity extends AppCompatActivity {
    Button btnRegisterP;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerprofessor);
        btnRegisterP=findViewById(R.id.btnRegisterP);
        btnRegisterP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterprofActivity.this,ListaProfActivity.class));
            }
        });
    }
    }

