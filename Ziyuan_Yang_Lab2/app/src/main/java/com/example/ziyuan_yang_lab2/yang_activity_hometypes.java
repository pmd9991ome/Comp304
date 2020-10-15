package com.example.ziyuan_yang_lab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.ziyuan_yang_lab2.R.id;
import static com.example.ziyuan_yang_lab2.R.menu;

public class yang_activity_hometypes extends AppCompatActivity {


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(menu.ziyuan_menu);
    }
    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ziyuan_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch(item.getItemId()) {
            case id.ziyuan_house:
               //System.out.println("Put some meat on the sandwich");
                Intent apartment = new Intent(this, com.example.ziyuan_yang_lab2.apartment.class);
                startActivity(apartment);
                break;
            case id.ziyuan_detached_home:
                Intent dh = new Intent(this, com.example.ziyuan_yang_lab2.detached_home.class);
                startActivity(dh);
                break;
            case id.ziyuan_semi_detached_home:
                Intent sdh = new Intent(this, com.example.ziyuan_yang_lab2.semi_detached_home.class);
                startActivity(sdh);
                break;
            case id.ziyuan_condo:
                Intent condo = new Intent(this, com.example.ziyuan_yang_lab2.condo.class);
                startActivity(condo);
                break;
            case id.ziyuan_town_house:
                Intent th = new Intent(this, com.example.ziyuan_yang_lab2.town_house.class);
                startActivity(th);
                break;
            // TODO: Veggie sandwich
        }
        return true;
    }
}


