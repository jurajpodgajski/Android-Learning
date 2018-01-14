package juraj.podgajski.com.widgets;

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
    private EditText etUnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bFirst = (Button) findViewById(R.id.bFirstButton);
        tvIspis = (TextView) findViewById(R.id.tvIspis);
        etUnos = (EditText) findViewById(R.id.etUnos);

        bFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_SHORT).show();
                // tvIspis.setText("Hello World");
                String text = etUnos.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
