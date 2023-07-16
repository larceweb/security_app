package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primeraapp.clases.ValidarPhone;

import org.w3c.dom.Text;

public class OlvidarPassActivity extends AppCompatActivity {

    public TextView textoAC;
    public Button btnIngreso;
    private EditText phoneNumber;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar_pass);

        textoAC = findViewById(R.id.textAc);
        String texto = "<font color=#f7931e>AC</font> <font color=#ECF0F1>SECURITY</font>";
        textoAC.setText(Html.fromHtml(texto));

       btnIngreso=findViewById(R.id.btningresar);
       btnIngreso.setOnClickListener(v -> {
           validaPhone();
       });



        phoneNumber = findViewById(R.id.textPhone);
        ValidarPhone.setupPhoneNumberValidation(phoneNumber);



    }



    private void validaPhone() {

        if (phoneNumber.length() != 8) {
            Toast.makeText(this, "Verifica tu número de teléfono", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(OlvidarPassActivity.this, PinContrasenaActivity.class));
            finish();
        }
    }
}