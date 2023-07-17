package com.example.primeraapp.clases;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ValidarPhone {

    public static void setupPhoneNumberValidation(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validatePhoneNumber(editText);
            }
        });
    }

    private static void validatePhoneNumber(EditText editText) {
        String phoneNumber = editText.getText().toString().trim();

        if (phoneNumber.length() == 8) {
            // Verificar si todos los caracteres son dígitos
            if (phoneNumber.matches("\\d+")) {
                // El número de teléfono tiene exactamente 8 dígitos y es válido.
                editText.setError(null); // Borrar cualquier error anterior
            } else {
                // El número de teléfono contiene caracteres que no son dígitos.
                editText.setError("El número de teléfono solo debe contener dígitos.");
                editText.requestFocus();
            }
        } else {
            // El número de teléfono no tiene 8 dígitos.
            editText.setError("El número de teléfono debe tener 8 dígitos.");
            editText.requestFocus();
        }
    }
}
