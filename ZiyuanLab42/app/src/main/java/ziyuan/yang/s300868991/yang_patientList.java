package ziyuan.yang.s300868991;
//ziyuan yang 300868991
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class yang_patientList extends AppCompatActivity {
ContentValues val =new ContentValues();
ListView list;
String arrpatientID[],arrName[],arrGender[],arrDepartment[];
SQLiteDatabase db;
@SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yang_patient_list);
        list = (ListView)findViewById(R.id.ziyuan_listview);
        db = openOrCreateDatabase("patient.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
    Cursor c=db.query("person", null,null,null,null,null,null);
    arrpatientID = new String[c.getCount()];
    arrName = new String[c.getCount()];
    arrGender= new String[c.getCount()];
    arrDepartment= new String[c.getCount()];
    c.moveToFirst();
    for (int i = 0; i < arrpatientID.length;i++)
    {
        arrpatientID[i] = c.getString(0);
        arrName[i] = c.getString(0);
        arrGender[i] = c.getString(0);
        arrDepartment[i] = c.getString(0);
        Toast.makeText(this,"Username: " + arrpatientID[i] + "Password: " + arrName[i] + "Gender: " + arrGender + "Department: " + arrDepartment, 1000).show();

        c.moveToNext();
        ArrayAdapter<String> adp = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrpatientID);
        list.setAdapter(adp);
    }
    }
}