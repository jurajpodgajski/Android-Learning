package juraj.podgajski.com.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String IME_KEY = "juraj.podgajski.com.intents.ime";
    public static final String PREZIME_KEY = "juraj.podgajski.com.intents.prezime";
    public static final String OIB_KEY = "juraj.podgajski.com.intents.oib";
    private EditText etIme;
    private EditText etPrezime;
    private EditText etOib;
    private Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        setupListeners();

    }

    private void initWidgets() {
        etIme = (EditText) findViewById(R.id.etIme);
        etPrezime = (EditText) findViewById(R.id.etPrezime);
        etOib = (EditText) findViewById(R.id.etOib);
        bLogin = (Button) findViewById(R.id.bLogin);
    }

    private void setupListeners() {
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ime = etIme.getText().toString();
                String prezime = etPrezime.getText().toString();
                String oib = etOib.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra(IME_KEY, ime);
                intent.putExtra(PREZIME_KEY, prezime);
                intent.putExtra(OIB_KEY, oib);

                startActivity(intent);

            }
        });
    }


}
