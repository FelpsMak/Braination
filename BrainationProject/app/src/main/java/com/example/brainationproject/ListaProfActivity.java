package com.example.brainationproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ListaProfActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Spinner sistemas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sistemas=(Spinner) findViewById(R.id.SPIN);

        ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.sistemas_mobile, android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);

        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.nav_view);

        toggle= new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }
}
