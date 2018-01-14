package juraj.podgajski.com.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNickname;
    private Button bSettings, bSpremi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNickname = (EditText) findViewById(R.id.etNickname);
        bSettings = (Button) findViewById(R.id.bSettings);
        bSpremi = (Button) findViewById(R.id.bSpremi);

        bSpremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nickname = etNickname.getText().toString();
                if (nickname.trim().length()==0){
                    Toast.makeText(MainActivity.this, "Molimo unesite nadimak", Toast.LENGTH_SHORT).show();
                    etNickname.requestFocus();
                    return;
                }
                
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nickname",nickname);
                editor.commit();
                Toast.makeText(MainActivity.this, "Spremljeno", Toast.LENGTH_SHORT).show();
                
                
                
            }
        });

        bSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferences();
    }

    private void getPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.contains("nickname")) {
            etNickname.setText(preferences.getString("nickname", null));
        }
        if (preferences.contains("color")) {
            if (preferences.getString("color", "0").equals("1")) {
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            } else if (preferences.getString("color", "0").equals("2")) {
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            } else if (preferences.getString("color", "0").equals("3")) {
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            } else {
                getWindow().getDecorView().setBackgroundColor(Color.CYAN);
            }
        }
    }

}
