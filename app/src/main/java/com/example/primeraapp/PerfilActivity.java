package com.example.primeraapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;


public class PerfilActivity extends AppCompatActivity {

    public Button btnEditPerfil, btnvolver,btnlogout,btnPin,btnNotificaciones;
   // private String rut;


    public Dialog dialogo_modal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        dialogo_modal = new Dialog(PerfilActivity.this);

        btnvolver = findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this, HomeActivity.class));
            finish();
        });

        btnEditPerfil = findViewById(R.id.editperfil);
        btnEditPerfil.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this, EditarPerfilActivity.class));
            finish();
        });

        btnPin = findViewById(R.id.btnPIN);
        btnPin.setOnClickListener(v -> {
           infoPin();
        });



        btnlogout=findViewById(R.id.cambiarPass);
        btnlogout.setOnClickListener(v->{
            startActivity(new Intent(PerfilActivity.this,CambiarPassActivity.class ));
            finish();
        });





    }


    public void infoPin(){

        Button btniraNoti;
        dialogo_modal.setContentView(R.layout.modalpin);
        btniraNoti = dialogo_modal.findViewById(R.id.ir_a_notificaciones);


        btniraNoti.setOnClickListener(v -> {

            String Pin = "123456";// Aquí se asigna el PIN generado
            Intent notif = new Intent(PerfilActivity.this,Notificaciones.class);
            notif.putExtra("PIN",Pin);
            startActivity(notif);
            finish();
            //dialogo_modal.setCancelable(true);
            //dialogo_modal.dismiss();
        });

        dialogo_modal.show();
        dialogo_modal.setCancelable(false);

    }


}








//POSIBLE VALIDADOR DE RUT
/*
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }*/
