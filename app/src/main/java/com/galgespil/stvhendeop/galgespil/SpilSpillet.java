package com.galgespil.stvhendeop.galgespil;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class SpilSpillet extends AppCompatActivity implements View.OnClickListener {

    SpilLogik logik = new SpilLogik();
    private TextView infoText;
    private Button tjek;
    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TableLayout table = new TableLayout(this);

        infoText = new TextView(this);
        infoText.setText("Velkommen til galgespillet!" +
                "\nDu skal nu gætte et ord: "+logik.getSynligtOrd() +
                "\nSkriv ét bogstav herunder og tryk 'Tjek Bogstav'.\n");
        String velkomst = getIntent().getStringExtra("velkomst");
        if (velkomst!=null) infoText.append(velkomst);
        table.addView(infoText);

        editText = new EditText(this);
        editText.setHint("Skriv et bogstav her.");
        table.addView(editText);

        tjek = new Button(this);
        tjek.setText("Tjek Bogstav");
        tjek.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_play, 0, 0, 0);
        table.addView(tjek);

        tjek.setOnClickListener(this);

        imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.galge);
        table.addView(imageView);

        setContentView(table);
    }

    @Override
    public void onClick(View view) {
        String bogstav = editText.getText().toString();
        if (bogstav.length() != 1) {
            editText.setError("Skriv præcis ét bogstav");
            return;
        }
        logik.gætBogstav(bogstav);
        editText.setText("");
        editText.setError(null);
        Update();
    }


    private void Update() {
        infoText.setText("Gæt ordet: " + logik.getSynligtOrd());
        infoText.append("\n\nDu har " + logik.forkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());

        switch (logik.forkerteBogstaver()) {
            case 1:
                imageView.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.forkert6);
                break;

        }


        if (logik.Vundet()) {
            infoText.append("\nDu har vundet");
        }
        if (logik.Tabt()) {
            infoText.setText("Du har tabt, det korrekte ord var : " + logik.getKorrektOrd());
        }

    }
}
