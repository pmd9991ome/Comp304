package ziyuan.yang.s300868991;
//ziyuan yang 300868991
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class yang_addTest extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase db;
    EditText BloodPressure;
    EditText RepiratoryRate;
    EditText BloodOxygenLevel;
    EditText HeartBeatRAte;
    EditText Covid;
    Button add;
    ContentValues val = new ContentValues();

    String arruser[], arrpass[];
    //String patientGender;

    @SuppressLint({"WrongViewCast", "WrongConstant"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yang_add_test);
        BloodPressure = (EditText) findViewById(R.id.ziyuan_blood);
        RepiratoryRate = (EditText) findViewById(R.id.ziyuan_rate);
        BloodOxygenLevel = (EditText) findViewById(R.id.ziyuan_bol);
        HeartBeatRAte = (EditText) findViewById(R.id.ziyuan_hbr);
        Covid = (EditText) findViewById(R.id.ziyuan_covid);
        add = (Button) findViewById(R.id.ziyuan_addTest);
        db = openOrCreateDatabase("patient.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        String query = "create table IF NOT EXiSTS data(BloodPressure text, RepiratoryRate text,BloodOxygenLevel text, HeartBeatRAte text,Covid text)";
        db.execSQL(query);

        add.setOnClickListener(this);

    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ziyuan_addTest) {
            try {
                val.put("BloodPressure", BloodPressure.getText().toString());
                val.put("RepiratoryRate", RepiratoryRate.getText().toString());
                val.put("BloodOxygenLevel", BloodOxygenLevel.getText().toString() );
                val.put("HeartBeatRAte", HeartBeatRAte.getText().toString() );
                val.put("Covid", Covid.getText().toString() );


                long l = db.insert("data", null, val);
                if (l > 0)
                    Toast.makeText(this, "Record insert successfully" , Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patient_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.ziyuan_addTest) {
            Intent myIntent = new Intent(yang_addTest.this,yang_patientList.class);
            startActivity(myIntent);
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

}