package com.galgespil.stvhendeop.galgespil;

/**
 * Created by mathiaslarsen on 25/10/2016.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;

import static com.galgespil.stvhendeop.galgespil.R.xml.indstillinger;


public class Indstillinger extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(indstillinger);
    }
}
