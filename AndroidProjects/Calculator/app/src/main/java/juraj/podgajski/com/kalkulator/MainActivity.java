package juraj.podgajski.com.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPrviBroj;
    private EditText etDrugiBroj;
    private Button bZbroji;
    private Button bOduzmi;
    private Button bPomnozi;
    private Button bPodijeli;
    private TextView tvRezultat;

    private double prviBroj, drugiBroj, rezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        setupListeners();

    }

    private void initWidgets() {
        etPrviBroj = (EditText) findViewById(R.id.etPrviBroj);
        etDrugiBroj = (EditText) findViewById(R.id.etDrugiBroj);
        bZbroji = (Button) findViewById(R.id.bZbroji);
        bOduzmi = (Button) findViewById(R.id.bOduzmi);
        bPodijeli = (Button) findViewById(R.id.bPodijeli);
        bPomnozi = (Button) findViewById(R.id.bPomnozi);
        tvRezultat = (TextView) findViewById(R.id.tvRezultat);
    }

    private void setupListeners() {
        bZbroji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                rezultat = prviBroj + drugiBroj;
                tvRezultat.setText(rezultat + ""); //zbog +"" gleda sve kao String
            }
        });

        bOduzmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                rezultat = prviBroj - drugiBroj;
                tvRezultat.setText(rezultat + "");
            }
        });

        bPodijeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();

                if (drugiBroj>0) {
                    rezultat = prviBroj / drugiBroj;
                    tvRezultat.setText(rezultat + "");
                } else {
                    tvRezultat.setText("");
                    etDrugiBroj.requestFocus();
                    Toast.makeText(MainActivity.this, "Drugi broj mora biti veci od 0", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bPomnozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                rezultat = prviBroj * drugiBroj;
                tvRezultat.setText(rezultat + "");
            }
        });
    }

    private void getNumbers() {
        prviBroj = Double.parseDouble(etPrviBroj.getText().toString());
        drugiBroj = Double.parseDouble(etDrugiBroj.getText().toString());
    }
}
