package ziyuan.yang.s300868991.ui.home;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ziyuan.yang.s300868991.R;
import ziyuan.yang.s300868991.Yang_MainActivity;

public class YaHome extends Fragment {

    private YaHomeViewModel yaHomeViewModel;

    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        yaHomeViewModel =
                ViewModelProviders.of(this).get(YaHomeViewModel.class);
        final View root = inflater.inflate(R.layout.ya_home, container, false);
        final TextView textView = root.findViewById(R.id.ziyuan_text_home);
        yaHomeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (!isInterrupted()) {
                                Thread.sleep(1000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        TextView tdate = root.findViewById(R.id.ziyuan_text_date);
                                        long date = System.currentTimeMillis();
                                        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy\nhh-mm-ss a");
                                        String dateString = sdf.format(date);
                                        tdate.setText(dateString);
                                    }
                                });
                            }
                        } catch (InterruptedException e) {
                        }
                    }
                };
                t.start();
                }

                /*Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dateTime = simpleDateFormat.format(calendar.getTime());
                textView1.setText(dateTime);*/

        });
        return root;



    }

    private void runOnUiThread(Runnable runnable) {
    }
}