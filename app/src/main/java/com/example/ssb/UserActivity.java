package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {
    private EditText editId, editPass;
    private Button btnAcceder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        this.editId = findViewById(R.id.editId);
        this.editPass = findViewById(R.id.editPass);
        this.btnAcceder = findViewById(R.id.btnAcceder);



        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnAcceder = new Intent(UserActivity.this, MenuActivity.class);

                startActivity(btnAcceder);

            }

        });



    }

    /*Validar usuario
    public Cursor verif(String us, String pass) throw SQLException {
        Cursor mcursor = null;
        mcursor = this.getRe

        return mcursor;
    }*/
}
