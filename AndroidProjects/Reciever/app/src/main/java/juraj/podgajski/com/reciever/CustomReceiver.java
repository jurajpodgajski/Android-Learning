package juraj.podgajski.com.reciever;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class CustomReceiver extends BroadcastReceiver {

    private String input;

    @Override
    public void onReceive(Context context, Intent intent) {

        input = intent.getStringExtra("juraj.podgajski.com.intents.input");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("My notification");
        builder.setContentText(input);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
}
