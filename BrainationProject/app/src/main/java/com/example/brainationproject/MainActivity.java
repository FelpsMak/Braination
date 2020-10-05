package com.example.brainationproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
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

        btnLogin = findViewById(R.id.login_principal);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                ActivityOptionsCompat activityOptionsCompat =ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.move_esquerda,R.anim.fade_in);
                ActivityCompat.startActivity(MainActivity.this,intent,activityOptionsCompat.toBundle());
                startActivity(intent);
            }
        });
        btnRegister=findViewById(R.id.register_principal);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PessoascadastroActivity.class));
            }
        });
    }
}
