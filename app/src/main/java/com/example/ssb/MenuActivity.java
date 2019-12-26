package com.example.ssb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssb.dal.AlarmaDAL;
import com.example.ssb.dal.UserDAL;
import com.example.ssb.dto.Alarma;
import com.example.ssb.dto.User;
import com.example.ssb.helpers.DatabaseHelper;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private Button btnConectar, btnDesconectar, btnEstado, btnAtencion, btnCerrar;
    private EditText editRut;
    private AlarmaDAL alarmaDAL;
    private UserDAL userDAL;
    private ArrayAdapter<User> adapter;
    private ArrayList<User> lista;
    private int codPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.userDAL = new UserDAL(getApplicationContext(), new User());

        this.lista = new UserDAL(getBaseContext()).seleccionar();

        this.btnConectar = findViewById(R.id.btnConectar);
        this.btnDesconectar = findViewById(R.id.btnDesconectar);
        this.btnEstado = findViewById(R.id.btnEstado);
        this.btnAtencion = findViewById(R.id.btnAtencion);
        this.btnCerrar = findViewById(R.id.btnCerrar);
        //this.editRut = findViewById(R.id.editRut);

        final DatabaseHelper helper = new DatabaseHelper(this,"alarma.db",null,1);


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
                AlarmaDAL alarmaDAL = new AlarmaDAL(getApplicationContext(), new Alarma());
                String rut = userDAL.getUser().getRut();
                String estado = "Conectado";

                alarmaDAL.insertar(rut,estado);

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

        btnDesconectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Su alarma está desconectada");
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

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if (){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                    builder.setMessage("Estado Conectado");
                    builder.setTitle("Estado");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }else (){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                    builder.setMessage("Estado Desconectado");
                    builder.setTitle("Estado");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                } */
            }
        });



        btnCerrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            logOut();
            Toast.makeText(getApplicationContext(),"Se ha cerrado sesión",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void logOut(){
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_notif){
            Intent intent = new Intent(MenuActivity.this, NotificacionActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
