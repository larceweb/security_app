package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;


import com.example.primeraapp.clases.ValidarPhone;



public class LoginActivity extends AppCompatActivity{

    TextView textAc,textelefono,txtolvidepass;
     EditText phoneNumber;
    Button btnOtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);





        textAc = findViewById(R.id.textAc);
        String text = "<font color=#f7931e>AC</font> <font color=#ECF0F1>SECURITY</font>";
        textAc.setText(Html.fromHtml(text));

//Se crea un SpannableString para subrayar el texto y también el boton de este mismo.
        txtolvidepass  = findViewById(R.id.txt_olvidepass);
        String texto = "Haz clic aquí";
        SpannableString textoSubrayado = new SpannableString(texto);
        textoSubrayado.setSpan(new UnderlineSpan(), 0,texto.length(),0);
        txtolvidepass.setText(textoSubrayado);

        txtolvidepass.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, OlvidarPassActivity.class));
            finish();
        });

        phoneNumber = findViewById(R.id.textPhone);
        ValidarPhone.setupPhoneNumberValidation(phoneNumber);



        btnOtra = findViewById(R.id.btnLogin);
        btnOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaPhone();

            }
        });
    }


    private void validaPhone() {

        if (phoneNumber.length() != 8) {
            Toast.makeText(this, "Verifica tu número de teléfono", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent); // El número de teléfono es válido, realiza otras acciones aquí.
        }
    }


}