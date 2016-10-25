package com.galgespil.stvhendeop.galgespil;

/**
 * Created by mathiaslarsen on 25/10/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Hjaelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String hjælpHtml = "<html><body>"
                + "<h1>Vejledning</h1>"
                + "<p>Spillet er meget simpelt. Du gætter rigtigt, ellers bliver din fine ven hængt. Og det ønsker du vel ikke? :-O</p>";

        WebView wv = new WebView(this);
        wv.loadData(hjælpHtml, "text/html", null);

        setContentView(wv);
    }
}
