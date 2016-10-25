package com.galgespil.stvhendeop.galgespil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity implements Runnable {

    static MainActivity aktivitetDerVisesNu = null;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        setContentView(imageView);

        if (savedInstanceState == null) {
            handler.postDelayed(this, 3000);
        }
        aktivitetDerVisesNu = this;
    }

    public void run() {
        startActivity(new Intent(this, Menu.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        aktivitetDerVisesNu.finish();
        aktivitetDerVisesNu = null;
    }


    @Override
    public void finish() {
        super.finish();
        handler.removeCallbacks(this);
    }
}