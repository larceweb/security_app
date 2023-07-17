package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.telephony.PhoneNumberUtils;

import com.example.primeraapp.io.UserApiAdapter;
import com.example.primeraapp.model.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {


    TextView textAc,textelefono;
    Button btnOtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        textAc = findViewById(R.id.textAc);
        String text = "<font color=#f7931e>AC</font> <font color=#ECF0F1>SECURITY</font>";
        textAc.setText(Html.fromHtml(text));
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
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
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
                cleanedNumber = "9" + cleanedNumber;
            }

            StringBuilder formattedNumber = new StringBuilder();
            formattedNumber.append(cleanedNumber.substring(0, 1));
            formattedNumber.append("");
            //formattedNumber.append(cleanedNumber.substring(1, 5));
            //formattedNumber.append(" ");
            formattedNumber.append(cleanedNumber.substring(1));

            textelefono.setText(formattedNumber.toString());
        } else {
            textelefono.setError("Número inválido");
        }
        //metodo retrofit
        /*
     Call<ArrayList<Users>> call = UserApiAdapter.getApiService().getUsers();
        call.enqueue((Callback<ArrayList<Users>>) this);
    }
   */
    }
}