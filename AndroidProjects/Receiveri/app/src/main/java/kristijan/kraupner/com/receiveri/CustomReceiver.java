package kristijan.kraupner.com.receiveri;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //izgradi notifikaciju i izbaci na ekran
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        //treba pozvati ove 3 metode:
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("My notification");
        builder.setContentText("My text");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
}
