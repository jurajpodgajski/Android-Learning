package juraj.podgajski.com.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bPlay;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        setupListeners();

    }

    private void setupListeners() {
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                    bPlay.setText("Stop");
                } else {
                    mediaPlayer.pause();
                    bPlay.setText("Play");
                }
            }
        });
    }

    private void initWidgets() {
        bPlay = (Button) findViewById(R.id.bPlay);
        mediaPlayer = MediaPlayer.create(this,R.raw.anthem);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}
