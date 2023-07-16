package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;



import android.os.Bundle;

import com.chaos.view.PinView;


public class GenerarPinActivity extends AppCompatActivity {

    public Button btnEnviar,btnVolver;
PinView pinView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_pin);


        pinView = findViewById(R.id.PinManual);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(v -> {
            validarPin();
        });

        btnVolver = findViewById(R.id.btnvolver);
        btnVolver.setOnClickListener(v -> {
            startActivity(new Intent(GenerarPinActivity.this,AsistenciaActivity.class));
            finish();
        });




    }

    public void validarPin(){

        if(pinView.length()<=5){
            pinView.setError("Complete el Pin");
            Toast.makeText(this, "Verifica que ingresaste bien el PIN", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"PIN ingresado",Toast.LENGTH_SHORT).show();
        }
    }







}