package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InstallQuestionActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private ToggleButton btnNewspaperYes;
    private ToggleButton btnNewspaperNo;
    private ToggleButton btnTvNever;
    private ToggleButton btnTvSometimes;
    private ToggleButton btnTvOften;
    private EditText txtSportName;
    private EditText txtSportTimes;
    private EditText txtBreakfast;
    private ToggleButton btnBikeYes;
    private ToggleButton btnBikeNo;
    private EditText txtBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_question);

        this.btnNewspaperYes = findViewById(R.id.btnQuestion1Yes);
        this.btnNewspaperNo = findViewById(R.id.btnQuestion1No);
        this.btnTvNever = findViewById(R.id.btnQuestion2Never);
        this.btnTvSometimes = findViewById(R.id.btnQuestion2Sometimes);
        this.btnTvOften = findViewById(R.id.btnQuestion2Often);
        this.txtSportName = findViewById(R.id.inputQuestion3);
        this.txtSportTimes = findViewById(R.id.inputQuestion4);
        this.txtBreakfast = findViewById(R.id.inputQuestion5);
        this.btnBikeYes = findViewById(R.id.btnQuestion6Yes);
        this.btnBikeNo = findViewById(R.id.btnQuestion6No);
        this.txtBike = findViewById(R.id.inputQuestion7);
        Button btnConfirm = findViewById(R.id.btnQuestionConfirm);

        this.btnNewspaperYes.setOnCheckedChangeListener(this);
        this.btnNewspaperNo.setOnCheckedChangeListener(this);
        this.btnTvNever.setOnCheckedChangeListener(this);
        this.btnTvSometimes.setOnCheckedChangeListener(this);
        this.btnTvOften.setOnCheckedChangeListener(this);
        this.btnBikeYes.setOnCheckedChangeListener(this);
        this.btnBikeNo.setOnCheckedChangeListener(this);

        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        // Question 1
        // Switch 'no' off when 'yes' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion1Yes && this.btnNewspaperNo.isChecked()) {
            this.btnNewspaperNo.setChecked(false);
        }

        // Switch 'yes' off when 'no' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion1No && this.btnNewspaperYes.isChecked()) {
            this.btnNewspaperYes.setChecked(false);
        }

        // Question 2
        // Switch 'sometimes' & 'often' off when 'never' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion2Never &&
                (this.btnTvSometimes.isChecked() || this.btnTvOften.isChecked())) {
            this.btnTvSometimes.setChecked(false);
            this.btnTvOften.setChecked(false);
        }

        // Switch 'never' & 'often' off when 'sometimes' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion2Sometimes &&
                (this.btnTvNever.isChecked() || this.btnTvOften.isChecked())) {
            this.btnTvNever.setChecked(false);
            this.btnTvOften.setChecked(false);
        }

        // Switch 'never' & 'sometimes' off when 'often' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion2Often &&
                (this.btnTvNever.isChecked() || this.btnTvSometimes.isChecked())) {
            this.btnTvNever.setChecked(false);
            this.btnTvSometimes.setChecked(false);
        }

        // Question 6
        // Switch 'no' off when 'yes' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion6Yes && this.btnBikeNo.isChecked()) {
            this.btnBikeNo.setChecked(false);
        }

        // Switch 'yes' off when 'no' is switched on
        if (b && compoundButton.getId() == R.id.btnQuestion6No && this.btnBikeYes.isChecked()) {
            this.btnBikeYes.setChecked(false);
        }
    }

    @Override
    public void onClick(View view) {
        String newspaper;
        String tv;
        String sportName;
        String sportTimes;
        String breakfast;
        String bike;
        String bikeTimes;

        // Send a toast message if one or more questions aren't answered
        if ((!this.btnNewspaperYes.isChecked() && !this.btnNewspaperNo.isChecked()) ||
                (!this.btnTvNever.isChecked() && !this.btnTvSometimes.isChecked() && !this.btnTvOften.isChecked()) ||
                this.txtSportName.getText().toString().matches("") ||
                this.txtSportTimes.getText().toString().matches("") ||
                this.txtBreakfast.getText().toString().matches("") ||
                (!this.btnBikeYes.isChecked() && !this.btnBikeNo.isChecked()) ||
                this.txtBike.getText().toString().matches("")) {
            Toast.makeText(this, R.string.questionMissedText, Toast.LENGTH_SHORT).show();
        } else {
            // Save the data
            if (this.btnNewspaperYes.isChecked()) {
                newspaper = "yes";
            } else {
                newspaper = "no";
            }

            if (this.btnTvNever.isChecked()) {
                tv = "never";
            } else if (this.btnTvSometimes.isChecked()) {
                tv = "sometimes";
            } else {
                tv = "often";
            }

            sportName = this.txtSportName.getText().toString();
            sportTimes = this.txtSportTimes.getText().toString();
            breakfast = this.txtBreakfast.getText().toString();

            if (this.btnBikeYes.isChecked()) {
                bike = "yes";
            } else {
                bike = "no";
            }

            bikeTimes = this.txtBike.getText().toString();

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            String name = "";
            String age = "";
            String gender = "";

            if (extras != null) {
                name = extras.getString("name");
                age = extras.getString("age");
                gender = extras.getString("gender");
            }

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editPrefs = prefs.edit();

            editPrefs.putBoolean("installed", true);
            editPrefs.putString("name", name);
            editPrefs.putString("age", age);
            editPrefs.putString("gender", gender);
            editPrefs.putString("newspaper", newspaper);
            editPrefs.putString("tv", tv);
            editPrefs.putString("sportName", sportName);
            editPrefs.putString("sportTimes", sportTimes);
            editPrefs.putString("breakfast", breakfast);
            editPrefs.putString("bike", bike);
            editPrefs.putString("bikeTimes", bikeTimes);
            editPrefs.apply();

            Intent homeIntent = new Intent(this, HomeActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(homeIntent);
            finish();
        }
    }
}
