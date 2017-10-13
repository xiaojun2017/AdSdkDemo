package com.example.uc.adsdkdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UC on 2017/9/26.
 */

public class AdAdapter {
    public static final int AD_TYPE_ADMOB = 1;
    public static final int AD_TYPE_FACEBOOK = 2;

    public static final int AD_SHOW_TYPE_BANNER = 1;
    public static final int AD_SHOW_TYPE_NATIVE = 2;
    public static final int AD_SHOW_TYPE_INTERSTITIAL = 3;


    private static String[] AD_TYPES = {"Admob", "Facebook"};
    private static String[] SHOW_TYPES = {"Banner", "Native", "Interstitial"};

    private static List<AdProperty> mAdSrcData = new ArrayList<>();
    private static List<AdProperty> mAdShowTypeData = new ArrayList<>();

    static {

        AdProperty p = new AdProperty("Admob", AD_TYPE_ADMOB);
        mAdSrcData.add(p);
        p = new AdProperty("Facebook", AD_TYPE_FACEBOOK);
        mAdSrcData.add(p);

        p = new AdProperty("Banner", AD_SHOW_TYPE_BANNER);
        mAdShowTypeData.add(p);
        p = new AdProperty("Native", AD_SHOW_TYPE_NATIVE);
        mAdShowTypeData.add(p);
        p = new AdProperty("Interstitial", AD_SHOW_TYPE_INTERSTITIAL);
        mAdShowTypeData.add(p);
    }

    private static AdSpinnerAdapter createAdapter(final Context context, final List<AdProperty> data) {
        AdSpinnerAdapter adapter = new AdSpinnerAdapter(context, data);
        return adapter;
    }

    public static AdSpinnerAdapter createAdSourceAdapter(Context context) {
        return createAdapter(context, mAdSrcData);
    }

    public static AdSpinnerAdapter createAdShowTypeAdapter(Context context) {
        return createAdapter(context, mAdShowTypeData);
    }
}
