package juraj.podgajski.com.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvRezultat;
    private String ime, prezime, oib;
    private Button bClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initWidgets();

        handleIntent();

        setupListeners();
    }


    private void initWidgets() {
        tvRezultat = (TextView) findViewById(R.id.tvRezultat);
        bClear = (Button) findViewById(R.id.bClear);
    }

    private void handleIntent() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MainActivity.IME_KEY)) {
            ime = intent.getStringExtra(MainActivity.IME_KEY);
            prezime = intent.getStringExtra(MainActivity.PREZIME_KEY);
            oib = intent.getStringExtra(MainActivity.OIB_KEY);
        }

        tvRezultat.setText(ime + " " + prezime + " " + oib);
    }

    private void setupListeners() {
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRezultat.setText("");
            }
        });
    }
}
