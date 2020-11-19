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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase db;
    EditText patientID;
    EditText patientName;
    RadioButton patientMale;
    RadioButton patientFemale;
    Spinner patientDepartment;
    Button insert;
    ContentValues val = new ContentValues();

    String arruser[], arrpass[];
    String patientGender;

    @SuppressLint({"WrongViewCast", "WrongConstant"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        patientID = (EditText) findViewById(R.id.Ziyuan_txtpatientId);
        patientName = (EditText) findViewById(R.id.Ziyuan_txtPatientName);
        patientMale = (RadioButton) findViewById(R.id.ziyuan_male);
        patientFemale = (RadioButton) findViewById(R.id.ziyuan_female);
        patientDepartment = (Spinner) findViewById(R.id.ziyuan_spinner);
        insert = (Button) findViewById(R.id.Ziyuan_add);
        db = openOrCreateDatabase("patient.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        String query = "create table IF NOT EXiSTS person(patientID text, patientName text,patientGender text, department text)";
        db.execSQL(query);

        insert.setOnClickListener(this);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ziyuan_spinner));
        patientDepartment.setAdapter(myAdapter);
    }

    public void RadioButtonClicked(View view) {

        //This variable will store whether the user was male or female
        String PatientGender="";
        // Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.ziyuan_female:
                if (checked)
                    PatientGender = "female";
                break;
            case R.id.ziyuan_male:
                if (checked)
                    PatientGender = "male";
                break;
        }
        //db.execSQL("INSERT INTO person VALUES('"+patientGender+"');");
        patientGender = PatientGender.toString();
    }


    @SuppressLint("WrongViewCast")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Ziyuan_add) {
            try {
                val.put("patientID", patientID.getText().toString());
                val.put("patientName", patientName.getText().toString());
                val.put("patientGender", patientGender.getBytes().toString() );


                long l = db.insert("person", null, val);
                if (l > 0)
                    Toast.makeText(this, "Record insert successfully" + patientID.getText().toString(), Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        //else if (v.getId() == R.id)

        patientDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patient_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.ziyuan_patientlist) {
            Intent myIntent = new Intent(MainActivity.this,yang_patientList.class);
            startActivity(myIntent);
            return false;
        }
        if (id == R.id.ziyuan_addTest) {
            Intent myIntent = new Intent(MainActivity.this,yang_addTest.class);
            startActivity(myIntent);
            return false;
        }
        if (id == R.id.ziyuan_testList) {
            Intent myIntent = new Intent(MainActivity.this,yang_testList.class);
            startActivity(myIntent);
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

}