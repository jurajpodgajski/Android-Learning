package juraj.podgajski.com.listandspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spBoje;
    private ListView lvGradovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spBoje = (Spinner) findViewById(R.id.spBoje);
        lvGradovi = (ListView) findViewById(R.id.lvGradovi);

        String [] boje = {"Crvena" , "Bijela" , "Plava"};

        List<String> gradovi = new ArrayList<>();
        gradovi.add("Zagreb");
        gradovi.add("Beograd");
        gradovi.add("Osijek");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, boje);

        spBoje.setAdapter(adapter);

        ArrayAdapter<String> adapterGradovi = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, gradovi);

        lvGradovi.setAdapter(adapterGradovi);

    }
}
