package juraj.podgajski.com.ispitandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvIme;
    private TextView tvPrezime;
    private TextView tvEmail;
    private TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initWidgets();

        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String ime = intent.getStringExtra(MainActivity.KEY_IME);
        String prezime = intent.getStringExtra(MainActivity.KEY_PREZIME);
        String email = intent.getStringExtra(MainActivity.KEY_EMAIL);
        String password = intent.getStringExtra(MainActivity.KEY_PASSWORD);

        tvIme.setText(ime);
        tvPrezime.setText(prezime);
        tvEmail.setText(email);
        tvPassword.setText(password);
    }

    private void initWidgets() {
        tvIme = (TextView) findViewById(R.id.tvIme);
        tvPrezime = (TextView) findViewById(R.id.tvPrezime);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
    }
}
