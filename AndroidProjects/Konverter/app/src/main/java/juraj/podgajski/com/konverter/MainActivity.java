package juraj.podgajski.com.konverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUnos;
    private RadioButton rbEur, rbUsd, rbGbp, rbKm;
    private Button bIzracunaj;
    private TextView tvRezultat;

    private double iznos, rezultat;

    private final double EUR_TECAJ = 7.42;
    private final double USD_TECAJ = 6.38;
    private final double GBP_TECAJ = 8.30;
    private final double KM_TECAJ = 4.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
        registerForContextMenu(etUnos);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Izaberi");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cm_Obrisi:
                etUnos.setText("");
                return true;
            case R.id.cm_Odustani:
                return false;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void initWidgets() {
        etUnos = (EditText) findViewById(R.id.etUnos);
        rbEur = (RadioButton) findViewById(R.id.rbEur);
        rbUsd = (RadioButton) findViewById(R.id.rbUsd);
        rbGbp = (RadioButton) findViewById(R.id.rbGbp);
        rbKm = (RadioButton) findViewById(R.id.rbKm);
        bIzracunaj = (Button) findViewById(R.id.bIzracunaj);
        tvRezultat = (TextView) findViewById(R.id.tvRezultat);
    }

    private void setupListeners() {
        bIzracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUnos.getText().toString().length() > 0) {
                    getAmount();
                    if (rbEur.isChecked()) {
                        rezultat = iznos / EUR_TECAJ;
                    } else if (rbUsd.isChecked()) {
                        rezultat = iznos / USD_TECAJ;
                    } else if (rbGbp.isChecked()) {
                        rezultat = iznos / GBP_TECAJ;
                    } else if (rbKm.isChecked()) {
                        rezultat = iznos / KM_TECAJ;
                    } else {
                        Toast.makeText(MainActivity.this, "Odaberi valutu", Toast.LENGTH_SHORT).show();
                    }
                    tvRezultat.setText(rezultat + "");
                } else {
                    Toast.makeText(MainActivity.this, "Unesi iznos", Toast.LENGTH_SHORT).show();
                    etUnos.requestFocus();
                }
            }
        });
    }

    private void getAmount() {
        iznos = Double.parseDouble(etUnos.getText().toString());
    }
}
