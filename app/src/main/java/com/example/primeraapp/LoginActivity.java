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


import android.widget.Toast;

import com.example.primeraapp.clases.ValidarPhone;
import com.example.primeraapp.io.UserApiService;
import com.example.primeraapp.model.DataModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {
    private EditText Phone, Password;
    private ProgressBar loadingPB;
    TextView textAc,txtolvidepass;
     EditText phoneNumber;
    Button btnOtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Phone = findViewById(R.id.textPhone);
        Password = findViewById(R.id.TextPassword);
        loadingPB = findViewById(R.id.idLoadingPB);
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



        btnOtra = findViewById(R.id.btnLogin);
        btnOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Phone.getText().toString().isEmpty() && Password.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Ingrese el datos otra vez", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(Phone.getText().toString(), Password.getText().toString());
            }

            {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent); //
            }


        });
    }

    private void postData(String phone, String pass) {

        // below line is for displaying our progress bar.
        loadingPB.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://68.183.144.230:3000/api/users")

                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        UserApiService retrofitAPI = retrofit.create(UserApiService.class);

        // passing data from our text fields to our modal class.
        DataModal modal = new DataModal(phone, pass);

        // calling a method to create a post and passing our modal class.
        Call<DataModal> call = retrofitAPI.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                // this method is called when we get response from our api.
                Toast.makeText(LoginActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                // below line is for hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

                // on below line we are setting empty text
                // to our both edit text.
                Phone.setText("");
                Password.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                DataModal responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
                String responseString = "Response Code : " + response.code() + "\nPhone : " + responseFromAPI.getPhone() + "\n" + "Password : " + responseFromAPI.getPassword();


            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.

            }
        });
    }
    }

