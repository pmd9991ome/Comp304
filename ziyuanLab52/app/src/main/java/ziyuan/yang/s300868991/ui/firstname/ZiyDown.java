package ziyuan.yang.s300868991.ui.firstname;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ziyuan.yang.s300868991.R;
import ziyuan.yang.s300868991.Yang_MainActivity;

public class ZiyDown extends Fragment {

    URL ImageUrl = null;
    InputStream is = null;
    Bitmap bmImg = null;
    ImageView imageView= null;
    ProgressDialog p;
    private ZiyViewModel ziyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ziyViewModel =
                ViewModelProviders.of(this).get(ZiyViewModel.class);
        View root = inflater.inflate(R.layout.ziy_down, container, false);
        final TextView textView = root.findViewById(R.id.ziyuan_text_firstname);
        final Button button = root.findViewById(R.id.ziyuan_button);
        final ImageView imageView = root.findViewById(R.id.ziyuan_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskExample asyncTask=new AsyncTaskExample();
                //noinspection deprecation
                asyncTask.execute("https://www.tutorialspoint.com/images/tp-logo-diamond.png");
            }
        });
        ziyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {


            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

            }
        });
        return root;
    }
    private class AsyncTaskExample extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //noinspection MoveFieldAssignmentToInitializer
            //p = new ProgressBar(ZiyDown,this);
            p.setMessage("Please wait...It is downloading");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {

                ImageUrl = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) ImageUrl
                        .openConnection();
                conn.setDoInput(true);
                conn.connect();
                is = conn.getInputStream();

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bmImg = BitmapFactory.decodeStream(is, null, options);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return bmImg;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(imageView!=null) {
                p.hide();
                imageView.setImageBitmap(bitmap);
            }else {
                p.show();
            }
        }

    }
}
