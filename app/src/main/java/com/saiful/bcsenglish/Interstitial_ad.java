package com.saiful.bcsenglish;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.saiful.bcsenglish.interFace.Iinterstitial_Ad;

/**
 * The class "Interstitial_ad was create to facilitate the Interstitial ad
 * to other activity and fragment
 * There are three method:
 * createInterstitial() - for initializing ad
 * loadInterstitial() - to load an ad
 * showInterstitial() - to show the ad
 * @author Saiful Islam
 * @since 6 March 2020"
 */
public class Interstitial_ad implements Iinterstitial_Ad {
    private com.google.android.gms.ads.InterstitialAd mInterstitialAd;
    private Context context;
//    private static final String TAG = "Interstitial_ad Class";

    public Interstitial_ad(Context context) {
        this.context = context;
    }

    @Override
    public void createInterstitial() {
        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-2522810443010389/6227965761");

        //Below is for the TEST purpose only
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // not call show interstitial ad from here
//                Log.d(TAG, "successfully ad loaded");
            }

            @Override
            public void onAdClosed() {
                loadInterstitial();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
//                Log.d(TAG, "Failed"+i);
            }
        });
        loadInterstitial();
    }

    @Override
    public void loadInterstitial() {
        AdRequest interstitialRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(interstitialRequest);
    }

    @Override
    public void showInterstitial() {

        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
//            Log.d(TAG, "Congratulation, Ad is loaded");
        }
        else
        {
            loadInterstitial();
//            Log.d(TAG, "Ad not loaded, reason unknown");
        }

    }
}
