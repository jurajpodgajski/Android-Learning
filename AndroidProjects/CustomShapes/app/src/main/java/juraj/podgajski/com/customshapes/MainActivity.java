package juraj.podgajski.com.customshapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new SimpleView(this));

        //setContentView(new CustomView(this));

        //setContentView(new TextView(this));
    }
}
