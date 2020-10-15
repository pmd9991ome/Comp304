package com.example.ziyuan_yang_lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class semi_detached_home extends AppCompatActivity {

    Button button;
    ArrayList<String> numbers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semi_detached_home);
        button = findViewById(R.id.radioButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add("780000");
                numbers.add("Se_mi_detached_Home");
                numbers.add("78 York Ave");
                Intent intent = new Intent(semi_detached_home.this, payment.class);
                intent.putExtra("key", numbers);
                startActivity(intent);

            }

        });
    }
}