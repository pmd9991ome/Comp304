package ziyuan.yang.s300868991;
//Ziyuan Yang 300868991  sec:002
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZiyuanActivity extends AppCompatActivity {

    private Button button;
    EditText edtuser,edtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.ziyuan_button);
        edtuser=(EditText)findViewById(R.id.ziyuan_input1);
        edtpass=(EditText)findViewById(R.id.ziyuan_input2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(edtuser.getText().toString().trim().length()==0){
                    edtuser.setError("Username is not entered");
                    edtuser.requestFocus();
                }
                if(edtpass.getText().toString().trim().length()==0){
                    edtpass.setError("Password is not entered");
                    edtpass.requestFocus();
                }
                else{
                    Intent second =new Intent(getApplicationContext(), YangActivity.class);
                    startActivity(second);
                }
            }
        });
    }
}