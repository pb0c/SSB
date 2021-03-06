package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssb.dal.UserDAL;
import com.example.ssb.dto.User;
import com.example.ssb.helpers.DatabaseHelper;

public class UserActivity extends AppCompatActivity {
    private EditText editId, editPass;
    private Button btnAcceder;
    private UserDAL userDAL;
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userDAL = new UserDAL(getApplicationContext(), new User());
        final DatabaseHelper helper = new DatabaseHelper(this,"alarma.db",null,1);


        this.editId = findViewById(R.id.editId);
        this.editPass = findViewById(R.id.editPass);
        this.btnAcceder = findViewById(R.id.btnAcceder);



        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = helper.verif(editId.getText().toString(),editPass.getText().toString());

                if (cursor.getCount()>0){
                    Intent btnAcceder = new Intent(UserActivity.this, MenuActivity.class);

                    startActivity(btnAcceder);
                }else {
                    Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrecto",Toast.LENGTH_LONG).show();

                }
                editId.setText("");
                editPass.setText("");
                editId.findFocus();
            }

        });



    }
}
