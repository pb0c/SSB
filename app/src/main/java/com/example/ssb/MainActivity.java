package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnUser, btnHuella;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnUser = findViewById(R.id.btnUser);
        this.btnHuella = findViewById(R.id.btnHuella);


        btnUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent btnUser = new Intent(MainActivity.this,UserActivity.class);

                    startActivity(btnUser);

                }

            });

    }
}
