package fr.cnam.nfa024.jpmena.notificationservice.Service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import fr.cnam.nfa024.jpmena.notificationservice.R;

public class ParcoursOptimalService extends IntentService {


    public final static String TAG_INTENT = "NotificationClicked";

    private NotificationManager mNotificationsManager;

    public ParcoursOptimalService() {
        super("ParcoursOptimalService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {//methode appelée en arrière plan
        if (intent != null) {

            try{
                Thread.sleep(5000);
            } catch (Exception e){
                e.printStackTrace();
            }

            mNotificationsManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            CharSequence tickerText = "view hike";
            Intent intentReceiverAcctivity = new Intent(TAG_INTENT);
            intentReceiverAcctivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intentReceiverAcctivity, 0);

            Notification.Builder builder = new Notification.Builder(this);

            builder.setAutoCancel(false);
            builder.setTicker(tickerText);
            builder.setContentTitle("The Hike");
            builder.setContentText("HikeMap is available");
            builder.setSmallIcon(R.drawable.explore);
            Bitmap large_icon_bmp = BitmapFactory.decodeResource(this.getResources(),
                    R.drawable.ic_action_map);
            builder.setLargeIcon(large_icon_bmp);
            builder.setContentIntent(pendingIntent);
            builder.setOngoing(true);
            builder.setSubText("Click on this icon to access the Hike's map");   //API level 16
            builder.setNumber(5000); //durée d'apparition de l'icone dans la barre de notifications ?
            builder.build();

            Notification notification = builder.getNotification();
            mNotificationsManager.notify(11, notification);

        }
    }
}
