package juraj.podgajski.com.ispitandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_IME = "key_ime";
    public static final String KEY_PREZIME = "key_prezime";
    public static final String KEY_EMAIL = "key_email";
    public static final String KEY_PASSWORD = "key_password";

    private EditText etIme;
    private EditText etPrezime;
    private EditText etEmail;
    private EditText etPassword;

    private Button bRegister;
    private Button bCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void setupListeners() {
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ime = etIme.getText().toString();
                String prezime = etPrezime.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra(KEY_IME, ime);
                intent.putExtra(KEY_PREZIME, prezime);
                intent.putExtra(KEY_EMAIL, email);
                intent.putExtra(KEY_PASSWORD, password);

                startActivity(intent);

            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "You canceled!", Toast.LENGTH_SHORT);
                toast.show();
                etIme.setText("");
                etPrezime.setText("");
                etEmail.setText("");
                etPassword.setText("");
            }
        });
    }

    private void initWidgets() {
        etIme = (EditText) findViewById(R.id.etIme);
        etPrezime = (EditText) findViewById(R.id.etPrezime);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bCancel = (Button) findViewById(R.id.bCancel);
        bRegister = (Button) findViewById(R.id.bRegister);
    }
}
