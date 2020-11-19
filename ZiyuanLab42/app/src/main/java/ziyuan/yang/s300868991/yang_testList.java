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

public class yang_testList extends AppCompatActivity {
    ContentValues val =new ContentValues();
    ListView list;
    String arrBloodPressure[],arrRepiratoryRate[],arrBloodOxygenLevel[],arrHeartBeatRAte[],arrCovid[];
    SQLiteDatabase db;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yang_test_list);
        list = (ListView)findViewById(R.id.ziyuan_testlistview);
        db = openOrCreateDatabase("patient.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        Cursor c=db.query("data", null,null,null,null,null,null);
        arrBloodPressure = new String[c.getCount()];
        arrRepiratoryRate = new String[c.getCount()];
        arrBloodOxygenLevel= new String[c.getCount()];
        arrHeartBeatRAte= new String[c.getCount()];
        arrCovid= new String[c.getCount()];
        c.moveToFirst();
        for (int i = 0; i < arrBloodPressure.length;i++)
        {
            arrBloodPressure[i] = c.getString(0);
            arrRepiratoryRate[i] = c.getString(0);
            arrBloodOxygenLevel[i] = c.getString(0);
            arrHeartBeatRAte[i] = c.getString(0);
            arrCovid[i] = c.getString(0);
            Toast.makeText(this,"Username: " + arrBloodPressure[i] + "Password: " + arrRepiratoryRate[i] + "Gender: " + arrBloodOxygenLevel + "Department: " + arrHeartBeatRAte + "Covid-19: " + arrCovid, 1000).show();

            c.moveToNext();
            ArrayAdapter<String> adp = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrBloodPressure);
            list.setAdapter(adp);
        }
    }
}