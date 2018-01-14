package kristijan.kraupner.com.broadcastsender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSendBroadcast = (Button) findViewById(R.id.bSend);

        bSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("com.kristijan.kraupner.dogadjaj");
                //intent.setAction("com.kristijan.kraupner.dogadjaj");
                sendBroadcast(intent);
            }
        });
    }
}
