package com.example.primeraapp;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class PerfilActivity extends AppCompatActivity {


    public Button btnEditPerfil, btnvolver, btnPin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        btnvolver = findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this, HomeActivity.class));
            finish();
        });

        btnEditPerfil = findViewById(R.id.editperfil);
        btnEditPerfil.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this, EditarPerfilActivity.class));
            finish();
        });

        btnPin = findViewById(R.id.btnPIN);
        btnPin.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this, GenerarPinActivity.class));
            finish();

        });

    }
}