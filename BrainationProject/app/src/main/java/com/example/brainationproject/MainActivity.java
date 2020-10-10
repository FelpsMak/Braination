package com.example.brainationproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_activity);

        btnRegister=findViewById(R.id.register_principal);
        btnLogin = findViewById(R.id.login_principal);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                ActivityOptionsCompat activityOptionsCompat =ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.move_direita,R.anim.fade_in);
                ActivityCompat.startActivity(MainActivity.this,intent,activityOptionsCompat.toBundle());
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisteralunoActivity.class);
                ActivityOptionsCompat activityOptionsCompat =ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.move_esquerda,R.anim.fade_in);
                ActivityCompat.startActivity(MainActivity.this,intent,activityOptionsCompat.toBundle());

            }
        });


    }
}
