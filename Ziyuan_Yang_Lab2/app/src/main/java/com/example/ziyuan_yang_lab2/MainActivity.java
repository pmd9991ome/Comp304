package com.example.ziyuan_yang_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Ziyuan_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ziyuan_button = (Button) findViewById(R.id.Ziyuan_button);
        Ziyuan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openactivity2();
            }
        });
    }

    private void openactivity2() {
        Intent intent = new Intent(this,yang_activity_hometypes.class);
        startActivity(intent);
    }


}