package ziyuan.yang.s300868991;
//Ziyuan Yang 300868991  sec:002
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class YangActivity extends ZiyuanActivity {

    private static class MyGreenView extends View {

        public MyGreenView(Context context) {
            super(context);

        }

    @Override
    protected void onDraw(Canvas canvas) {

        Path clipPath = new Path();
        clipPath.addPath(Star());
        canvas.clipPath(clipPath);
        canvas.drawColor(Color.MAGENTA);

        super.onDraw(canvas);

    }


    private Path Star() {

        Path path = new Path();
        float midX = getWidth()/2;
        float midY = getHeight()/2;

        path.moveTo(midX, midY);
        path.lineTo(midX+190, midY+300);
        path.lineTo(midX, midY+210);
        path.lineTo(midX-190, midY+300);
        path.lineTo(midX-160, midY+90);
        path.lineTo(midX-300, midY-70);
        path.lineTo(midX-100 ,midY-110);
        path.lineTo(midX, midY-300);
        path.lineTo(midX+100, midY-110);
        path.lineTo(midX+300, midY-70);
        path.lineTo(midX+160, midY+90);
        path.lineTo(midX+190, midY+300);

        return path;

    }




}}

