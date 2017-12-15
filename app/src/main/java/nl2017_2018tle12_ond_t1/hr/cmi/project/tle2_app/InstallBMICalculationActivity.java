package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by HAL9000 on 11-12-2017.
 */

public class InstallBMICalculationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputHeight;
    private EditText inputWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_bmicalculation);

        this.inputHeight = findViewById(R.id.inputHeight);
        this.inputWeight = findViewById(R.id.inputWeight);
        Button btnBMICalc = findViewById(R.id.btnBMICalc);

        btnBMICalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (this.inputHeight.getText().toString().matches("")) {
            Toast.makeText(this, R.string.noHeightText, Toast.LENGTH_SHORT).show();
        } else if (this.inputWeight.getText().toString().matches("")) {
            Toast.makeText(this, R.string.noWeightText, Toast.LENGTH_SHORT).show();
        } else {
            double height = Double.parseDouble(this.inputHeight.getText().toString()) / 100;
            double weight = Double.parseDouble(this.inputWeight.getText().toString());

            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.CEILING);
            String bmi = df.format(weight / (height * height));

            Intent bmiConfirmIntent = new Intent(this, InstallBMIConfirmActivity.class);
            bmiConfirmIntent.putExtra("BMI", bmi);
            startActivity(bmiConfirmIntent);
        }
    }
}
