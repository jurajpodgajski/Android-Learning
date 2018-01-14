package juraj.podgajski.com.smszadaca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bFirst;
    private TextView tvIspis;
    private EditText etUnosBroj;
    private EditText etUnosPoruka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bFirst = (Button) findViewById(R.id.bFirstButton);
        tvIspis = (TextView) findViewById(R.id.tvIspis);
        etUnosBroj = (EditText) findViewById(R.id.etUnosBroj);
        etUnosPoruka = (EditText) findViewById(R.id.etUnosPoruka);

        bFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String broj = etUnosBroj.getText().toString();
                String text = etUnosPoruka.getText().toString();
                Toast.makeText(MainActivity.this, broj + ": " + text, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
