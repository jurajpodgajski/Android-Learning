package juraj.podgajski.com.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MA", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MA", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MA", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MA", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MA", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MA", "onDestroy()");
    }
}
