package juraj.podgajski.com.telephone;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            // "pdus" je unaprijed definirani ključ
            Object[] smsObject = (Object[]) bundle.get("pdus");
            SmsMessage [] smsMessages = new SmsMessage[smsObject.length];
            String contact = "";
            String message = "";
            for (int i=0; i<smsObject.length; i++) {
                smsMessages[i] = SmsMessage.createFromPdu((byte[]) smsObject[i]);
                if (i==0) {
                    contact = smsMessages[i].getOriginatingAddress();
                }
                message += smsMessages[i].getMessageBody();
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentTitle(contact);
            builder.setContentText(message);

            Notification notification = builder.build();

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1,notification);
        }

    }
}
