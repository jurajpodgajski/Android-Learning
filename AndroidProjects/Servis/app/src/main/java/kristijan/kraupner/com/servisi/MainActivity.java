package kristijan.kraupner.com.servisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TASK_COUNT = "task.key";
    private Button bStartService, bStopService, bStartIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bStartIService = (Button) findViewById(R.id.bStartIService);
        bStartService = (Button) findViewById(R.id.bStartService);
        bStopService = (Button) findViewById(R.id.bStopService);

        bStartIService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                intent.putExtra(TASK_COUNT,5);
                startService(intent);
            }
        });

        bStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent); //ovo je zadnja stvar - pozove se servis
            }
        });

        bStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent); //ovo je zadnja stvar - pozove se servis
            }
        });
    }
}
