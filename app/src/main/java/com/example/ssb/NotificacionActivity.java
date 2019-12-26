package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ssb.dal.AlarmaDAL;
import com.example.ssb.dto.Alarma;

import java.util.ArrayList;

public class NotificacionActivity extends AppCompatActivity {
    private ListView listNot1, listNot2;
    private ArrayAdapter<Alarma> adapter;
    private ArrayList<Alarma> lista;
    private AlarmaDAL alarmaDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        this.alarmaDAL = new AlarmaDAL(getApplicationContext(), new Alarma());

        this.lista = new AlarmaDAL(getBaseContext()).seleccionar();

        this.listNot1 = findViewById(R.id.listNot1);
        this.listNot2 = findViewById(R.id.listNot2);


        this.adapter = new ArrayAdapter<Alarma>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                this.lista
        );

        //iii asociar arrayadapter al componente listview
        this.listNot1.setAdapter(adapter);



    }
}
