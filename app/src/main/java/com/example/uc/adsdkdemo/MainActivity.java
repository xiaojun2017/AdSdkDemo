package com.example.uc.adsdkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private AdView mBannerAdView;
    private Spinner mAdSrcSpinner;
    private Spinner mAdShowTypeSpinner;
    private int mSrcType;
    private int mShowType;
    private boolean mFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        initView();
    }

    void t(){

    }
    private void initView() {
        mAdSrcSpinner = (Spinner) findViewById(R.id.ad_src_spinner);
        mAdShowTypeSpinner = (Spinner) findViewById(R.id.ad_show_type_spinner);
        mBannerAdView = (AdView) findViewById(R.id.adView);

        mAdSrcSpinner.setAdapter(AdAdapter.createAdSourceAdapter(this));
        mAdSrcSpinner.setOnItemSelectedListener(this);
        mAdShowTypeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (mFirst) {
            mFirst = false;
            return;
        }
        int spinnerId = adapterView.getId();
        switch (spinnerId) {
            case R.id.ad_src_spinner:
                mSrcType = i;
                loadAds();
                break;
            case R.id.ad_show_type_spinner:
                mShowType = i;
                loadAds();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void loadAds() {
        switch (mSrcType) {
            case 0: //Admob
                loadAdMob();
                break;
            case 1: //Facebook

                break;
            default:
                break;
        }
    }

    private void loadAdMob() {
        switch (mShowType) {
            case 0: //Banner
                AdMobLoader.loadBanner(mBannerAdView, null);
                break;
            case 1: //Native
                break;
            case 2: //Interstitial

            default:
                break;
        }
    }

    /**
     * test1 method
     */
    private void test1() {

    }

    /**
     * test2 method
     */
    private void test2() {

    }

    /**
     * test3 method
     */
    private void test3() {

    }

    /**
     * test4 method
     */
    private void test4() {

    }

    /**
     * test5 method
     */
    private void test5() {

    }

    private void test6() {

    }

    private void test7() {

    }

    private void test8() {

    }
}
