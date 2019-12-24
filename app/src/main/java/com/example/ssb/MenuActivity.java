package com.example.ssb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button btnConectar, btnDesconectar, btnEstado, btnAtencion, btnCerrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.btnConectar = findViewById(R.id.btnConectar);
        this.btnDesconectar = findViewById(R.id.btnDesconectar);
        this.btnEstado = findViewById(R.id.btnEstado);
        this.btnAtencion = findViewById(R.id.btnAtencion);
        this.btnCerrar = findViewById(R.id.btnCerrar);

        btnAtencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnAtencion = new Intent(MenuActivity.this, ClienteActivity.class);

                startActivity(btnAtencion);

            }

        });

        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Su alarma está conectada");
                builder.setTitle("Conexión");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }

        });

    }
}
