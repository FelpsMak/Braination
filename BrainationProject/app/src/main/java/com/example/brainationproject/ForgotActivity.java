package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotActivity extends AppCompatActivity {

    TextView txtInf, txtInf2;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);

        txtInf2=findViewById(R.id.txtInf2);
        txtInf=findViewById(R.id.txtInf);
        btnOK=findViewById(R.id.btn_login_aluno);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInf.setVisibility(View.VISIBLE);
                txtInf2.setVisibility(View.VISIBLE);
                }
        });

    }
}