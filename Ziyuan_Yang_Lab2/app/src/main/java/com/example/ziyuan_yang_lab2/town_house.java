package com.example.ziyuan_yang_lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class town_house extends AppCompatActivity {


    Button button;
    ArrayList<String> numbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.town_house);
        button = findViewById(R.id.radioButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add("400000$");
                numbers.add("Town_House");
                numbers.add("33 Sheppard Ave");
                Intent intent = new Intent(town_house.this, payment.class);
                intent.putExtra("key", numbers);
                startActivity(intent);
            }
        });
    }
}
