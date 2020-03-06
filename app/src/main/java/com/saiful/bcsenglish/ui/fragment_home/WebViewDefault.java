package com.saiful.bcsenglish.ui.fragment_home;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdView;
import com.saiful.bcsenglish.AdmobAd;
import com.saiful.bcsenglish.R;

/**
 * A simple {@link Fragment} subclass.
 * @author Saiful Islam
 * @since 6 March 2020
 */
public class WebViewDefault extends Fragment {


    public WebViewDefault() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_view_default, container, false);

        AdmobAd admobAd = new AdmobAd((AdView) v.findViewById(R.id.adView));
        admobAd.bannerAd_initialize();

        assert getArguments() != null;
        String url = getArguments().getString("urlLink");

        WebView mWebView_Default = v.findViewById(R.id.mWebView_Default);
        mWebView_Default.getSettings().setAllowFileAccess(true);
        mWebView_Default.getSettings().setUseWideViewPort(true);
        mWebView_Default.getSettings().setLoadWithOverviewMode(true);
        mWebView_Default.getSettings().setBuiltInZoomControls(true);
        mWebView_Default.clearCache(true);
        mWebView_Default.clearHistory();
        mWebView_Default.loadUrl(url);

        return v;
    }

}
