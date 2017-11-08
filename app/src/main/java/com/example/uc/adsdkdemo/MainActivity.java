package com.example.uc.adsdkdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okio.BufferedSink;
import okio.Okio;

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

    void t() {

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

        testOkIO();
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

    private void filePermission() {
        int REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    private void testOkIO() {
        filePermission();
        try {
            File file = new File("/sdcard/xiaojun.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedSink sink = createSink(file);
            sink.writeUtf8("\nxiaojun");
            sink.writeUtf8("hello");
            sink.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BufferedSink createSink(File f) {
        if (f == null) {
            return null;
        }

        BufferedSink sink = null;
        try {
            FileOutputStream fos = new FileOutputStream(f, true);
            sink = Okio.buffer(Okio.sink(fos));
        } catch (FileNotFoundException ignored) {
        }

        return sink;
    }

    //111111111111111111
    //222222222222222222
    //333333333333333333
    //444444444444444444
}
