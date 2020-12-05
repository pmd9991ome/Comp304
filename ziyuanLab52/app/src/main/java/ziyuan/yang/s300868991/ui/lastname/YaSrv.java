package ziyuan.yang.s300868991.ui.lastname;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import ziyuan.yang.s300868991.R;

public class YaSrv extends Fragment {

    private YaSrvViewModel lastNameViewModel;
    TextView textView1;
    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lastNameViewModel =
                ViewModelProviders.of(this).get(YaSrvViewModel.class);
        View root = inflater.inflate(R.layout.ya_srv, container, false);
        final TextView textView = root.findViewById(R.id.ziyuan_text_lastname);
        final  TextView textView1 = root.findViewById(R.id.ziyuan_txt_webservice);
        final Button button= root.findViewById(R.id.ziyuan_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://samples.openweathermap.org/data/2.5/weather?zip=[ZipCode],us&appid=b6907d289e10d714a6e88b30761fae22";

                new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);
                        textView1.setText(str);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        textView1.setText("Error in calling service.");
                    }
                });

            }
        });
        lastNameViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}