package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Notificaciones extends AppCompatActivity {

    public Button btnvolver;
    private String Pin;
    private TextView txt_pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        Pin = getIntent().getStringExtra("PIN");
        txt_pin = findViewById(R.id.txt_PIN);
        txt_pin.setText(Pin);


        btnvolver = findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(v -> {
            Intent volver = new Intent(Notificaciones.this,HomeActivity.class);
            startActivity(volver);
            finish();
        });




    }
}