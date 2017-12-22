package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private int target;
    private int activity_today;
    private boolean goal_today;
    private ImageView goal_sprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
