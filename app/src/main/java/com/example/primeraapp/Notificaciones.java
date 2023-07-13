package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Notificaciones extends AppCompatActivity {

    public Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        btnvolver = findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(v -> {
            Intent volver = new Intent(Notificaciones.this,HomeActivity.class);
            startActivity(volver);
            finish();
        });



    }
}