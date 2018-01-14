package juraj.podgajski.com.ponavljanje1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SuccesfulRegistrationActivity extends AppCompatActivity {

    private TextView tvImeIPrezime;
    private TextView tvRegistracija;
    private TextView tvOib;
    private TextView tvProizvodac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succesful_registration);

        initWidgets();

        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String ime = intent.getStringExtra(MainActivity.KEY_IME);
        String oib = intent.getStringExtra(MainActivity.KEY_OIB);
        String registracija = intent.getStringExtra(MainActivity.KEY_REGISTRACIJA);
        String proizvodac = intent.getStringExtra(MainActivity.KEY_PROIZVODAC);

        tvImeIPrezime.setText(ime);
        tvOib.setText(oib);
        tvProizvodac.setText(proizvodac);
        tvRegistracija.setText(registracija);
    }

    private void initWidgets() {
        tvImeIPrezime = (TextView) findViewById(R.id.tvImeIPrezime);
        tvRegistracija = (TextView) findViewById(R.id.tvRegistracija);
        tvOib = (TextView) findViewById(R.id.tvOib);
        tvProizvodac = (TextView) findViewById(R.id.tvProizvodac);
    }
}
