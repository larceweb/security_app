package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AsistenciaActivity extends AppCompatActivity {
Button btnAsistencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);
        btnAsistencia = findViewById(R.id.btnmarcarasistencia);

        btnAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AsistenciaActivity.this, GenerarPinActivity.class));
                finish();
            }
        });
    }

}