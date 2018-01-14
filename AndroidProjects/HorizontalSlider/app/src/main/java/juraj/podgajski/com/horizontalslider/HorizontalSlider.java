package juraj.podgajski.com.horizontalslider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ProgressBar;

public class HorizontalSlider extends ProgressBar {

    private OnProgressChangedListener onProgressChangedListener;

    public HorizontalSlider(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.progressBarStyleHorizontal);
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.onProgressChangedListener = onProgressChangedListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

            float x_os = event.getX();
            int progress = Math.round((float) getMax() * x_os / getWidth());

            if (progress < 0) {
                progress = 0;
            } else if (progress > 100) {
                progress = 100;
            }
            setProgress(progress);

            notifyListeners(progress);
        }
        return true;
    }

    private void notifyListeners(int progress) {
        if (onProgressChangedListener !=null) {
            onProgressChangedListener.onProgressChanged(this,progress);
        }
    }

}
