package com.raja.compass;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;

public class DevActivity extends AppCompatActivity implements ObservableScrollViewCallbacks, View.OnClickListener {

    private View mImageView;

    private View mToolbarView;
    private ObservableScrollView mScrollView;
    private int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        //Set and Define Imageviews id
        ImageView app1 = (ImageView) findViewById(R.id.app1);
        ImageView app2 = (ImageView) findViewById(R.id.app2);
        ImageView app3 = (ImageView) findViewById(R.id.app3);
        ImageView app4 = (ImageView) findViewById(R.id.app4);
        // Set What To Show in The Imageview
        app1.setImageResource(R.drawable.iapp_1);
        app2.setImageResource(R.drawable.iapp_2);
        app3.setImageResource(R.drawable.iapp_3);
        app4.setImageResource(R.drawable.iapp_4);
        //Set On CLick Listeners
        app1.setOnClickListener(this);
        app2.setOnClickListener(this);
        app3.setOnClickListener(this);
        app4.setOnClickListener(this);

        mImageView = findViewById(R.id.image);
        mToolbarView = findViewById(R.id.toolbar);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.primary)));

        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
       int baseColor = getResources().getColor(R.color.primary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, scrollY / 2);
        ViewHelper.setTranslationY(mImageView, scrollY / 2);

    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app1: {
                Toast.makeText(getApplicationContext(), "Clicked 1st Image",
                        Toast.LENGTH_SHORT).show();
                //final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.raja.android.maari")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.raja.android.maari")));
                }
            }
            break;
            case R.id.app2: {
                Toast.makeText(getApplicationContext(), "Clicked 2nd Image",
                        Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.app3: {
                Toast.makeText(getApplicationContext(), "Clicked 3rd Image",
                        Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.app4: {
                Toast.makeText(getApplicationContext(), "Clicked 4th Image",
                        Toast.LENGTH_SHORT).show();
            }
            break;

        }
    }

}

