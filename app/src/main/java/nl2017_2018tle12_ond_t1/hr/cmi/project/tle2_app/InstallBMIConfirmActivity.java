package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HAL9000 on 11-12-2017.
 */

public class InstallBMIConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_bmiconfirm);

        TextView txtBMI = findViewById(R.id.txtBMI);
        String bmi = getIntent().getStringExtra("BMI");
        txtBMI.setText(bmi);

        Button btnBMIConfirm = findViewById(R.id.btnBMIConfirm);
        btnBMIConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editPrefs = prefs.edit();
        editPrefs.putBoolean("installed", true);
        editPrefs.apply();

        Intent homeIntent = new Intent(this, HomeActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}
