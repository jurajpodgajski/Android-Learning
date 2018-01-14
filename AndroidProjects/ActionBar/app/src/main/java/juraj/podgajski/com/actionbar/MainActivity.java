package juraj.podgajski.com.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bShowHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bShowHide = (Button) findViewById(R.id.bShowHide);
        bShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideAB ();
            }
        });
    }
    
    private void showHideAB () {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar.isShowing()){
            actionBar.hide();
        }else {
            actionBar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miFaces:
                Toast.makeText(this, "Faces item clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miHttp:
                Toast.makeText(this, "Http item clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miLand:
                Toast.makeText(this, "Land item clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miTakeoff:
                Toast.makeText(this, "Takeoff item clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miTimer:
                Toast.makeText(this, "Timer item clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
