package juraj.podgajski.com.ponavljanje1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_IME = "key_ime";
    public static final String KEY_OIB = "key_oib";
    public static final String KEY_REGISTRACIJA = "key_registracija";
    public static final String KEY_PROIZVODAC = "key_proizvodac";
    private EditText etImeIPrezime;
    private EditText etRegistracija;
    private EditText etOib;
    private EditText etProizvodac;

    private Button bRegistriraj;
    private Button bOdustani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();


    }

    private void setupListeners() {
        bRegistriraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ime = etImeIPrezime.getText().toString();
                String oib = etOib.getText().toString();
                String registracija = etRegistracija.getText().toString();
                String proizvodac = etProizvodac.getText().toString();

                Intent intent = new Intent(MainActivity.this, SuccesfulRegistrationActivity.class);
                intent.putExtra(KEY_IME, ime);
                intent.putExtra(KEY_OIB, oib);
                intent.putExtra(KEY_REGISTRACIJA, registracija);
                intent.putExtra(KEY_PROIZVODAC, proizvodac);

                startActivity(intent);

            }
        });

        bOdustani.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etProizvodac.setText("");
                etRegistracija.setText("");
                etOib.setText("");
                etImeIPrezime.setText("");
                return true;
            }
        });
    }

    private void initWidgets() {
        etImeIPrezime = (EditText) findViewById(R.id.etImeIPrezime);
        etOib = (EditText) findViewById(R.id.etOib);
        etProizvodac = (EditText) findViewById(R.id.etProizvodac);
        etRegistracija = (EditText) findViewById(R.id.etRegistracija);
        bOdustani = (Button) findViewById(R.id.bOdustani);
        bRegistriraj = (Button) findViewById(R.id.bRegistriraj);
    }
}
