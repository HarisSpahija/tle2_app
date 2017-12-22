package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.HashMap;

/**
 * Created by HAL9000 on 11-12-2017.
 */

public class InstallRegistrationActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private EditText txtName;
    private EditText txtAge;
    private ToggleButton btnMale;
    private ToggleButton btnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_registration);

        this.txtName = findViewById(R.id.inputName);
        this.txtAge = findViewById(R.id.inputAge);
        this.btnMale = findViewById(R.id.btnMale);
        this.btnFemale = findViewById(R.id.btnFemale);
        Button btnRegister = findViewById(R.id.btnRegister);

        this.btnMale.setOnCheckedChangeListener(this);
        this.btnFemale.setOnCheckedChangeListener(this);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        // Switch female off when male is switched on
        if (b && compoundButton.getId() == R.id.btnMale && this.btnFemale.isChecked()) {
            this.btnFemale.setChecked(false);
        }

        // Switch male off when female is switched on
        if (b && compoundButton.getId() == R.id.btnFemale && this.btnMale.isChecked()) {
            this.btnMale.setChecked(false);
        }
    }

    @Override
    public void onClick(View view) {
        String name;
        String age;
        String gender;

        // Send a toast message if one of the fields is not filled in
        if (this.txtName.getText().toString().matches("")) {
            Toast.makeText(this, R.string.noNameText, Toast.LENGTH_SHORT).show();
        } else if (this.txtAge.getText().toString().matches("")) {
            Toast.makeText(this, R.string.noAgeText, Toast.LENGTH_SHORT).show();
        } else if (!this.btnMale.isChecked() && !this.btnFemale.isChecked()) {
            Toast.makeText(this, R.string.noGenderText, Toast.LENGTH_SHORT).show();
        } else {
            // Save the data
            name = this.txtName.getText().toString();
            age = this.txtAge.getText().toString();

            if (this.btnMale.isChecked()) {
                gender = "male";
            } else {
                gender = "female";
            }

            // TODO: Implement saving of data and go to questionnaire
            HashMap<String, String> data = new HashMap<>();
            data.put("name", name);
            data.put("age", age);
            data.put("gender", gender);

            Intent bmiCalcIntent = new Intent(this, InstallBMICalculationActivity.class);
            bmiCalcIntent.putExtra("userData", data);
            startActivity(bmiCalcIntent);
        }
    }
}
