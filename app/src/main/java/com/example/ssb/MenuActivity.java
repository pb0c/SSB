package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

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
        

    }
}
