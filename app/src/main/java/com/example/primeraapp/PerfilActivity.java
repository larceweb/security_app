package com.example.primeraapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class PerfilActivity extends AppCompatActivity {

    public Button btnEditPerfil, btnvolver,btnlogout,btnPin,btnNotificaciones;
   // private String rut;

    LinearLayout my_Modal, fond_opaco_overbox; //Linear Layout para activar el modal de Notificación.
    LinearLayout Layout_1,Layout_2; //Layouts de Pefil .

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

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

        btnNotificaciones = findViewById(R.id.ir_a_notificaciones);//Btn para ir al Layout de Notificaciones
        btnPin = findViewById(R.id.btnPIN);
        Layout_1 = findViewById(R.id.linearLayout1);//Layout principal del Perfil
        Layout_2 = findViewById(R.id.linearLayout2);//Layout de txt btn del Perfil
        my_Modal = findViewById(R.id.myContentModal); //Layout del Modal
        fond_opaco_overbox = findViewById(R.id.overbox);//Fondo opaco para visualizar bien el Modal
        my_Modal.setAlpha(0);//Modal deshabilitado
        fond_opaco_overbox.setAlpha(0);

        btnPin.setOnClickListener(v -> {
            my_Modal.setAlpha(1);
            fond_opaco_overbox.setAlpha(1);

            for (int h = 0; h < Layout_1.getChildCount(); h++){
                View elementos_hijos = Layout_1.getChildAt(h);
                elementos_hijos.setEnabled(false);
            }
            for (int i = 0; i < Layout_2.getChildCount(); i++) {
                View elementos_hijos = Layout_2.getChildAt(i);
                elementos_hijos.setEnabled(false);
            }

        });

        btnNotificaciones.setOnClickListener(v -> {
            startActivity(new Intent(PerfilActivity.this,HomeActivity.class));
            finish();

            String PINdefault = "175865";




        });





        btnlogout=findViewById(R.id.cambiarPass);
        btnlogout.setOnClickListener(v->{
            startActivity(new Intent(PerfilActivity.this,CambiarPassActivity.class ));
            finish();
        });





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
