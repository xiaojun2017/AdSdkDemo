package com.example.uc.adsdkdemo;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by UC on 2017/9/26.
 */

public class AdMobLoader {
    private InterstitialAd mInterstitialAd;

    public static void loadBanner(AdView adView, AdListener listener) {
        if (adView != null) {
            adView.setAdListener(listener);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }
    }

}
