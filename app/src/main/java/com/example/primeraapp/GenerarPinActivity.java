package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.hanks.passcodeview.PasscodeView;

public class GenerarPinActivity extends AppCompatActivity {


    public Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_pin);

        btnvolver=findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(v->{
            startActivity(new Intent(GenerarPinActivity.this,PerfilActivity.class));
            finish();
        });

    }
}