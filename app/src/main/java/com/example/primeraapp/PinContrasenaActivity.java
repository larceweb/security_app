package com.example.primeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class PinContrasenaActivity extends AppCompatActivity {

    public Button btnPin;
    public TextView textoAC;
   PinView pinView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_contrasena);

        textoAC = findViewById(R.id.textAc);
        String texto = "<font color=#f7931e>AC</font> <font color=#ECF0F1>SECURITY</font>";
        textoAC.setText(Html.fromHtml(texto));


       pinView = findViewById(R.id.PinCambiarPass);

        btnPin = findViewById(R.id.btnAceptar);
        btnPin.setOnClickListener(v -> {

            validarPin();
        });


    }


    public void validarPin(){

        if(pinView.length()<=5){
            pinView.setError("Complete el Pin");
            Toast.makeText(this, "Verifica que ingresaste bien el PIN", Toast.LENGTH_SHORT).show();
        }
        else{
            startActivity(new Intent(PinContrasenaActivity.this,LoginActivity.class));
            finish();
        }
    }





}