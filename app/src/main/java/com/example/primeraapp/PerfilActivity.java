package com.example.primeraapp;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class PerfilActivity extends AppCompatActivity {
    PasscodeView passcodeView;

    public Button btnEditPerfil, btnvolver, btnPIN;



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

        btnPIN = findViewById(R.id.btnPIN);
        btnPIN.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this, GenerarPinActivity.class));
            finish();

        });

    }
}