package juraj.podgajski.com.customshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by jurajdnd on 17/10/2017.
 */

public class TextView extends View {
    public TextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAlpha(120);
        paint.setTextSize(100);
        canvas.drawText("Android", 200, 600, paint);

        Path path = new Path();
        path.addArc(new RectF(0, 200, 550, 600), 230, 90);
        paint.setColor(Color.BLUE);
        canvas.drawTextOnPath("Android", path, 0, 0, paint);

        float[] positions = {
                100, 350,
                170, 390,
                220, 350,
                280, 300,
                320, 350,
                375, 400,
                400, 420
        };


        paint.setColor(Color.MAGENTA);
        canvas.drawPosText("Android",positions,paint);

    }
}
