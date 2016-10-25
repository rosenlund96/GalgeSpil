package com.galgespil.stvhendeop.galgespil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class SpilLogik {
    private ArrayList<String> muligeOrd = new ArrayList<String>();
    private String korrektOrd;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private int forkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean Vundet;
    private boolean Tabt;


    public ArrayList<String> getBrugteBogstaver() {
        return brugteBogstaver;
    }

    public String getSynligtOrd() {
        return synligtOrd;
    }

    public String getKorrektOrd() {
        return korrektOrd;
    }

    public int forkerteBogstaver() {
        return forkerteBogstaver;
    }

    public boolean erSidsteBogstavKorrekt() {
        return sidsteBogstavVarKorrekt;
    }

    public boolean Vundet() {
        return Vundet;
    }

    public boolean Tabt() {
        return Tabt;
    }

    public boolean erSpilletSlut() {
        return Tabt || Vundet;
    }


    public SpilLogik() {
        muligeOrd.add("bil");
        muligeOrd.add("computer");
        muligeOrd.add("programmering");
        muligeOrd.add("motorvej");
        muligeOrd.add("busrute");
        muligeOrd.add("gangsti");
        muligeOrd.add("skovsnegl");
        muligeOrd.add("solsort");
        nulstil();
    }

    public void nulstil() {
        brugteBogstaver.clear();
        forkerteBogstaver = 0;
        Vundet = false;
        Tabt = false;
        korrektOrd = muligeOrd.get(new Random().nextInt(muligeOrd.size()));
        opdaterSynligtOrd();
    }


    private void opdaterSynligtOrd() {
        synligtOrd = "";
        Vundet = true;
        for (int n = 0; n < korrektOrd.length(); n++) {
            String bogstav = korrektOrd.substring(n, n + 1);
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav;
            } else {
                synligtOrd = synligtOrd + "*";
                Vundet = false;
            }
        }
    }

    public void gætBogstav(String bogstav) {
        if (bogstav.length() != 1) return;
        if (brugteBogstaver.contains(bogstav)) return;
        if (Vundet || Tabt) return;

        brugteBogstaver.add(bogstav);

        if (korrektOrd.contains(bogstav)) {
            sidsteBogstavVarKorrekt = true;

        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            sidsteBogstavVarKorrekt = false;

            forkerteBogstaver = forkerteBogstaver + 1;
            if (forkerteBogstaver > 6) {
                Tabt = true;
            }
        }
        opdaterSynligtOrd();
    }




}