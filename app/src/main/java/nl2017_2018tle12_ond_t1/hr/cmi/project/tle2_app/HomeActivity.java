package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Notification;
import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private int target;
    private int activity_today;
    private boolean goal_today;
    private ImageView goal_sprite;

    NotificationHelper helper;
    Button dailyNotificationButton;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Notification Creation
        helper = new NotificationHelper(this);
        dailyNotificationButton = findViewById(R.id.dailyNotificationButton);

        dailyNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = getString(R.string.notif_title);
                String content = getString(R.string.notif_daily);
                Notification.Builder builder = helper.getEVIChannelNotification(title,content);
                helper.getManager().notify(new Random().nextInt(),builder.build());
            }
        });

        // TODO: Hardcoded data, user profile not available yet.
        this.target = 1800;
        this.activity_today = getIntent().getIntExtra("activity", 1091);
        this.goal_sprite = findViewById(R.id.goal_icon_false);

        this.goal_today = (this.activity_today - target) > 0;

        if(this.goal_today){
            this.goal_sprite.setImageResource(R.drawable.goal_sprite_true);

            String message = getString(R.string.goal_message_true);
            TextView textView = findViewById(R.id.goal_message);
            textView.setText(message);
        }
    }


    //Public date
    //Public install state

    //Private target
    //Private activity of today
    //Private goal message
    //Private goal img

    //Progress
        //Check goal of today
        //if goal is achieved
            //Update the marker to green
            //Show string of achieved goal
        //else (default)
            //keep marker to red
            //show string of not achieved

    //Update goal marker
        //Retrieve information what is the neccessary goal
        //If (activity of today - necessary goal) is bigger than 0
            //goal of today is set to true

}
