package juraj.podgajski.com.ispitgrafika;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bPlay;
    private MediaPlayer mediaPlayer;
    private TextView tvVolume;
    private HorizontalSlider hsSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        setupListeners();


        hsSlider.setOnProgressChangedListener(new OnProgressChangedListener() {
            @Override
            public void onProgressChanged(View v, int progress) {
                tvVolume.setText("VOLUME: " + progress + "%");
                float volume = (float) (1 - (Math.log(100 - progress) / Math.log(100)));
                mediaPlayer.setVolume(volume, volume);
            }
        });
    }

    private void initWidgets() {
        bPlay = (Button) findViewById(R.id.bPlay);
        mediaPlayer = MediaPlayer.create(this, R.raw.rickroll);
        mediaPlayer.setVolume(1, 1);
        tvVolume = (TextView) findViewById(R.id.tvVolume);
        hsSlider = (HorizontalSlider) findViewById(R.id.hsSlider);
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

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
        return true;
    }
}

