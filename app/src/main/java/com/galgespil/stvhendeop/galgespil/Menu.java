package com.galgespil.stvhendeop.galgespil;

/**
 * Created by mathiaslarsen on 25/10/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class Menu extends AppCompatActivity implements OnClickListener {
    // Vi erklærer variabler herude så de huskes fra metode til metode
    Button hjaelpKnap, indstillingerKnap, spilKnap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.knapper);

        hjaelpKnap = (Button) findViewById(R.id.knap1);
        hjaelpKnap.setText("Hjælp");

        indstillingerKnap = (Button) findViewById(R.id.knap2);
        indstillingerKnap.setText("Indstillinger");

        spilKnap = (Button) findViewById(R.id.knap3);
        spilKnap.setText("Spil");

        hjaelpKnap.setOnClickListener(this);
        indstillingerKnap.setOnClickListener(this);
        spilKnap.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == hjaelpKnap) {

            Intent i = new Intent(this, Hjaelp.class);
            startActivity(i);

        } else if (v == indstillingerKnap) {

            Intent i = new Intent(this, Indstillinger.class);
            startActivity(i);

        } else if (v == spilKnap) {

            Intent i = new Intent(this, SpilSpillet.class);
            startActivity(i);

        }
    }
}
