package juraj.podgajski.com.customshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by jurajdnd on 17/10/2017.
 */

public class CustomView extends View {

    public CustomView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.BLACK);

        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(6);

        canvas.drawLine(100,0,100,200,paint);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(15);

        canvas.drawCircle(200,250,100,paint);


        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);

        for (int i = 30, alpha = 255;alpha>2;alpha -= 20, i+= 30) {
            paint.setAlpha(alpha);
            canvas.drawLine(350,i,950,i,paint);
        }

    }



}
