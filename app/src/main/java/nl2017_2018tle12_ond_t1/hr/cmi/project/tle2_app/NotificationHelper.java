package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by HAL9000 on 15-1-2018.
 */

public class NotificationHelper extends ContextWrapper {

    private static final String EVI_CHANNEL_ID = "nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app.EVI";
    private static final String EVI_CHANNEL_NAME = "EVI Channel";
    private NotificationManager manager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels() {
        //SEE IMPORTANCE LEVELS: https://developer.android.com/about/versions/oreo/android-8.1.html
        NotificationChannel eviChannel = new NotificationChannel(EVI_CHANNEL_ID,EVI_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        eviChannel.enableLights(true);
        eviChannel.enableVibration(true);
        eviChannel.setLightColor(Color.GREEN);
        eviChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(eviChannel);
    }

    public NotificationManager getManager() {
        if(manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getEVIChannelNotification(String title, String body)
    {
        return new Notification.Builder(getApplicationContext(),EVI_CHANNEL_ID)
                .setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);
    }

}
