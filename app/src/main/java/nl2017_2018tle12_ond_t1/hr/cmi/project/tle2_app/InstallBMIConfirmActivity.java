package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HAL9000 on 11-12-2017.
 */

public class InstallBMIConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_bmiconfirm);

        TextView txtBMI = findViewById(R.id.txtBMI);
        String bmi = getIntent().getStringExtra("BMI");
        txtBMI.setText(bmi);
    }
}
