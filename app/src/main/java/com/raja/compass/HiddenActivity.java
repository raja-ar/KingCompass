package com.raja.compass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raaja on 07/09/2015.
 */
public class HiddenActivity extends Activity implements View.OnClickListener {
private Button abtdev, devapps, compass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        abtdev = (Button) findViewById(R.id.btn_abtdev);
        abtdev.setOnClickListener(this); // calling onClick() method
        devapps = (Button) findViewById(R.id.btn_devapps);
        devapps.setOnClickListener(this);
        compass = (Button) findViewById(R.id.btn_back);
        compass.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_abtdev:
                Intent about = new Intent(HiddenActivity.this, AboutDevActivity.class);
                startActivity(about);
                break;

            case R.id.btn_devapps:
                Intent apps = new Intent(HiddenActivity.this, DevAppsActivity.class);
                startActivity(apps);
                break;

            case R.id.btn_back:

                Intent back = new Intent(HiddenActivity.this, CompassActivity.class);
                startActivity(back);
                break;

            default:
                break;
        }

    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(HiddenActivity.this, CompassActivity.class);
        startActivity(intent);
    }

}
