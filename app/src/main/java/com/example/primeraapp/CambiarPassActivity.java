package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CambiarPassActivity extends AppCompatActivity {

    public Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_pass);

        btnvolver=findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(v->{
            startActivity(new Intent(CambiarPassActivity.this, PdvActivity.class));
            finish();
        });






    }
}