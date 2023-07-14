package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.telephony.PhoneNumberUtils;

public class LoginActivity extends AppCompatActivity {


    TextView textAc,textelefono,txtolvidepass;
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




        textelefono=findViewById(R.id.textPhone);
        textelefono.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        textelefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    formatPhoneNumber();
                }
            }
        });



        btnOtra = findViewById(R.id.btnLogin);
        btnOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }

    //Validación número de celular, formato 912345678
    private void formatPhoneNumber() {
        String phoneNumber = textelefono.getText().toString().trim();
        String cleanedNumber = PhoneNumberUtils.stripSeparators(phoneNumber);

        if (cleanedNumber.length() == 8 || cleanedNumber.length() == 9) {
            if (cleanedNumber.length() == 8) {
                cleanedNumber = "+569" + cleanedNumber;
            }

            StringBuilder formattedNumber = new StringBuilder();
            formattedNumber.append(cleanedNumber.substring(0, 4));
            formattedNumber.append(" ");
            //formattedNumber.append(cleanedNumber.substring(1, 5));
            //formattedNumber.append(" ");
            formattedNumber.append(cleanedNumber.substring(4));

            textelefono.setText(formattedNumber.toString());
        }

        if(cleanedNumber.length()<=7){
            textelefono.setError("Número Incorrecto");
        }
        else {
            textelefono.setError("El formato debe ser así: 89898989");
        }
    }




}