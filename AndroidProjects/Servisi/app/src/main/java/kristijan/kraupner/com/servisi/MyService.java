package kristijan.kraupner.com.servisi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    private boolean serviceOn = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!serviceOn) {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(6);
        } else {
            Toast.makeText(this, "Service is already running", Toast.LENGTH_SHORT).show();
        }
        //https://developer.android.com/reference/android/app/Service.html
        return START_STICKY; //ovu konstantu staviti prikladno poslu koji se obavlja, nije uvijek ista
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
