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
import android.widget.ProgressBar;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private ProgressBar loadingPB;


    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        loadingPB = findViewById(R.id.idLoadingPB);
        btn1 = findViewById(R.id.btnlogin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }

        });
    }     }