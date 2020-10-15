package com.example.ziyuan_yang_lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class apartment extends AppCompatActivity {

    Button button;
    ArrayList<String> numbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apartment);

        button = findViewById(R.id.radioButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add("1800000");
                numbers.add("Apartment");
                numbers.add("52 Kennedy Road");
                Intent intent = new Intent(apartment.this, payment.class);
                intent.putExtra("key", numbers);
                startActivity(intent);

            }

        });
    }
}
