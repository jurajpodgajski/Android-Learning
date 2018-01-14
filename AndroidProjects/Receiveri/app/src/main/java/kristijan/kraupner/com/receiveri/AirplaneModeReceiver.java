package kristijan.kraupner.com.receiveri;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startMainActivity = new Intent(context, MainActivity.class);
        startMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMainActivity);
        Toast.makeText(context, "Airplane mode changes detected, starting activity now", Toast.LENGTH_SHORT).show();
    }
}
