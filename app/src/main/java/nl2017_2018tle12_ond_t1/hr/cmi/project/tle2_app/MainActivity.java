package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean installed = prefs.getBoolean("installed", false);

        if (!installed) {
            // Create an intent and start the InstallRegistrationActivity
            Intent registrationIntent = new Intent(this, InstallRegistrationActivity.class);
            startActivity(registrationIntent);
        } else {
            // Create an intent and start the HomeActivity
            Intent homeIntent = new Intent(this, HomeActivity.class);
            homeIntent.putExtra("activity", 2117);
            startActivity(homeIntent);
        }

        finish();
    }
}
