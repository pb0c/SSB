package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssb.dal.UserDAL;
import com.example.ssb.dto.User;
import com.example.ssb.helpers.DatabaseHelper;

public class RegistroActivity extends AppCompatActivity {
    private EditText editRut, editnombre, editPass, editRe, editMail;
    private Button btnRegistro;
    private UserDAL userDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        userDAL = new UserDAL(getApplicationContext(), new User());

        this.editRut = findViewById(R.id.editRut);
        this.editnombre = findViewById(R.id.editNombre);
        this.editPass = findViewById(R.id.editPass);
        this.editRe = findViewById(R.id.editRe);
        this.editMail = findViewById(R.id.editMail);
        this.btnRegistro = findViewById(R.id.btnRegistro);

        final DatabaseHelper databaseHelper= new DatabaseHelper(getApplicationContext());



        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String rut = editRut.getText().toString();
                String nombre = editnombre.getText().toString();
                String pass = editPass.getText().toString();
                String re = editRe.getText().toString();
                String mail = editMail.getText().toString();

                if (validar(rut) && validar(nombre) && validar(pass) && validar(re) && validar(mail)){
                    userDAL.insertar(editRut.getText().toString(), editnombre.getText().toString(), editPass.getText().toString(), editMail.getText().toString());

                    Intent btnRegistro = new Intent(RegistroActivity.this, UserActivity.class);
                    startActivity(btnRegistro);

                    Toast.makeText(getApplicationContext(),"Usuario registrado con éxito",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Datos Incompletos",Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    //Validar datos
    boolean validar(String texto){
        return texto!=null && texto.trim().length()>0;
    }



}
