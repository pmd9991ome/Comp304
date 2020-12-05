package ziyuan.yang.s300868991;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Yang_MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public LocationManager locationManager;
    public LocationListener locationListener = new MyLocationListener();
    String lat, lon;
    String latitude, longtitude;
    CoordinatorLayout coordinatorLayout;
    private boolean gps_enable = false;
    private boolean network_enable = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.ziyuan_coordinate);

        Toolbar toolbar = findViewById(R.id.ziyuan_toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.ziyuan_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.ziyuan_nav_home, R.id.ziyuan_nav_firstname, R.id.ziyuan_nav_lastname, R.id.ziyuan_nav_settings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.ziyuan_nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        checkLocationPermission();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.yang_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.ziyuan_nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.ziyuan_option:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com")));
                return true;
            case R.id.ziyuan_option1:
                getMyLocation();
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, lat + lon, Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            case R.id.ziyuan_option2:

        }
        return super.onOptionsItemSelected(item);


    }


    class MyLocationListener implements LocationListener {


        @Override
        public void onLocationChanged(@NonNull Location location) {
            if (location != null) {
                locationManager.removeUpdates((android.location.LocationListener) locationListener);
                lat = "" + location.getLatitude();
                lon = "" + location.getLongitude();

                //latitude.setText(lat);
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }

    public void getMyLocation() {
        try {
            gps_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }
        if (!gps_enable && !network_enable) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Yang_MainActivity.this);
            builder.setTitle("Attention");
            builder.setMessage("Sorry, location is not available");

            builder.create().show();
        }

        if (gps_enable) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
        if (network_enable) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }

    }

    private void checkLocationPermission() {
        int location = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int location2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        List<String> listPermission = new ArrayList<>();
        if (location != PackageManager.PERMISSION_GRANTED) {
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (location2 != PackageManager.PERMISSION_GRANTED) {
            listPermission.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!listPermission.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermission.toArray(new String[listPermission.size()]),
                    1);
        }

    }
}