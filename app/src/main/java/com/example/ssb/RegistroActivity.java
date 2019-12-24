package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    private EditText editRut, editnombre, editPass, editRe, editMail;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.editRut = findViewById(R.id.editRut);
        this.editnombre = findViewById(R.id.editNombre);
        this.editPass = findViewById(R.id.editPass);
        this.editRe = findViewById(R.id.editRe);
        this.editMail = findViewById(R.id.editMail);
        this.btnRegistro = findViewById(R.id.btnRegistro);



        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rut = editRut.getText().toString();
                String nombre = editnombre.getText().toString();
                String pass = editPass.getText().toString();
                String re = editRe.getText().toString();
                String mail = editMail.getText().toString();

                if (validar(rut) && validar(nombre) && validar(pass) && validar(re) && validar(mail)){

                }else {
                    Toast.makeText(getApplicationContext(),"Datos Incompletos",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    boolean validar(String texto){
        return texto!=null && texto.trim().length()>0;
    }
}
