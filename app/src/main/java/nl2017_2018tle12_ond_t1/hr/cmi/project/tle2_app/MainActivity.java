package nl2017_2018tle12_ond_t1.hr.cmi.project.tle2_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TEST", "onCreate: TEST");
        setContentView(R.layout.activity_main);
    }
}
