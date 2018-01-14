package juraj.podgajski.com.horizontalslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvProgress;
    private HorizontalSlider hsSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvProgress = (TextView) findViewById(R.id.tvProgress);
        hsSlider = (HorizontalSlider) findViewById(R.id.hsSlider);

        hsSlider.setOnProgressChangedListener(new OnProgressChangedListener() {
            @Override
            public void onProgressChanged(View v, int progress) {
                tvProgress.setText(progress + "%");
            }
        });
    }
}
