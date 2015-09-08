package com.raja.compass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raaja on 07/09/2015.
 */
public class DevActivity extends Activity {
    public Button compass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        compass = (Button) findViewById(R.id.btn_back);
        compass.setOnClickListener(myhandler);
    }

    View.OnClickListener myhandler = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(DevActivity.this, CompassActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(DevActivity.this, CompassActivity.class);
        startActivity(intent);
    }
}
