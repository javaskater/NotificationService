package fr.cnam.nfa024.jpmena.notificationservice.Service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import fr.cnam.nfa024.jpmena.notificationservice.R;
import fr.cnam.nfa024.jpmena.notificationservice.ReceiverActivity;

public class ParcoursOptimalService extends IntentService {


    private String FOLLOWERS_CHANNEL_ID  = "Followers";

    private NotificationManager mNotificationsManager;

    public ParcoursOptimalService() {
        super("ParcoursOptimalService");
    }


    @Override
    @TargetApi(26)
    protected void onHandleIntent(Intent intent) {//methode appelée en arrière plan
        if (intent != null) {

            try{
                Thread.sleep(5000);
            } catch (Exception e){
                e.printStackTrace();
            }

            mNotificationsManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 26){
                NotificationChannel followersChannel = new NotificationChannel(FOLLOWERS_CHANNEL_ID, "Followers", NotificationManager.IMPORTANCE_DEFAULT);
                mNotificationsManager.createNotificationChannel(followersChannel);
            }
            CharSequence tickerText = "view hike";
            //does only work with an explicit Intent
            Intent intentReceiverAcctivity = new Intent(this, ReceiverActivity.class);
            intentReceiverAcctivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intentReceiverAcctivity, 0);

            Notification.Builder builder = new Notification.Builder(this);

            builder.setAutoCancel(false);
            builder.setTicker(tickerText);
            builder.setContentTitle("The Hike");
            builder.setContentText("HikeMap is available");
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 26){
                builder.setChannelId(FOLLOWERS_CHANNEL_ID);
            }
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
