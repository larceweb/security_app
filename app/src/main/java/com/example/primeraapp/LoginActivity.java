package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    TextView textAc;
    Button btnOtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        textAc = findViewById(R.id.textAc);
        String text = "<font color=#f7931e>AC</font> <font color=#ECF0F1>SECURITY</font>";
        textAc.setText(Html.fromHtml(text));
        btnOtra = findViewById(R.id.btnLogin);
        btnOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }


}