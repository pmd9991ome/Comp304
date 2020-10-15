package com.example.ziyuan_yang_lab2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class payment extends AppCompatActivity {
    TextView textView;
    EditText food,sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        food = findViewById(R.id.food);
        sport = findViewById(R.id.sport);

        textView = findViewById(R.id.price);
        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
        textView.setText(String.valueOf(numbersList));
    }
    private void validate(){
        boolean valid = true;
        String foods  = food.getText().toString();
        String sports =  sport.getText().toString();
        if (foods.isEmpty())
            valid= false;
        else
            isFoodValid(foods);
        valid=true;
        if (sports.isEmpty())
            valid= false;
        else
            isSportValid(sports);
        valid=true;}



    public static boolean isFoodValid(String food) {

        boolean valid = true;
        String answer = "apple";

        if (food.matches(answer)) {
            valid = true;
        }
        return valid;
    }
    public static boolean isSportValid(String sport) {

        boolean valid = true;
        String answer = "soccer";

        if (sport.matches(answer)) {
            valid = true;
        }
        return valid;
    }
}