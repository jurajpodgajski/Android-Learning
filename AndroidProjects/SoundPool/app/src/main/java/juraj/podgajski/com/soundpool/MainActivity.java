package juraj.podgajski.com.soundpool;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvPlay;
    private SoundPool soundPool;

    private int soundId;
    private boolean isLoaded;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }


    private void initWidgets() {
        tvPlay = (TextView) findViewById(R.id.tvPlay);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundId = soundPool.load(this, R.raw.winchester, 1);
        handler = new Handler();
    }

    private void setupListeners() {
        tvPlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (isLoaded) {
                    handler.postAtTime(new Runnable() {
                        @Override
                        public void run() {
                            soundPool.play(soundId, 1f, 1f, 1, 0, 1f);
                        }
                    }, 0);
                }
                return true;
            }
        });

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                isLoaded = true;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        soundPool.release();
    }
}
