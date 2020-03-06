package com.saiful.bcsenglish.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.saiful.bcsenglish.AdmobAd;
import com.saiful.bcsenglish.Interstitial_ad;
import com.saiful.bcsenglish.R;
import com.saiful.bcsenglish.SocialMediaConnectivity;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Objects;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Interstitial_ad intAd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //initializing banner ad and interstitial ad
        AdmobAd admobAd = new AdmobAd((AdView) root.findViewById(R.id.adView));
        admobAd.bannerAd_initialize();
        intAd = new Interstitial_ad(getContext());
        intAd.createInterstitial();
        intAd.loadInterstitial();

//        final TextView textView = root.findViewById(R.id.text_home);
        Button mBtn_privacy = root.findViewById(R.id.mBtn_privacy);
        Button mBtn_FBpage = root.findViewById(R.id.mBtn_FBpage);
        Button mBtn_FBgroup = root.findViewById(R.id.mBtn_FBgroup);
        Button mBtn_sendEmail = root.findViewById(R.id.mBtn_sendEmail);
        Button mBtn_bcsSyllabus = root.findViewById(R.id.mBtn_bcsSyllabus);
        Button mBtn_bcsBookList = root.findViewById(R.id.mBtn_bcsBookList);

        mBtn_privacy.setOnClickListener(this);
        mBtn_FBpage.setOnClickListener(this);
        mBtn_FBgroup.setOnClickListener(this);
        mBtn_sendEmail.setOnClickListener(this);
        mBtn_bcsSyllabus.setOnClickListener(this);
        mBtn_bcsBookList.setOnClickListener(this);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {
        Bundle urlLink;
        Intent intent;
        SocialMediaConnectivity socialMediaConnectivity;
        switch (v.getId()) {
            case R.id.mBtn_privacy:
                urlLink = new Bundle();
                urlLink.putString("urlLink", "file:///android_asset/privacy_policy.html");
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_homeWebViewDefault, urlLink);
                break;
            case R.id.mBtn_FBpage:
                 socialMediaConnectivity = new SocialMediaConnectivity();
                intent = socialMediaConnectivity.fb_page(getContext());
                startActivity(intent);
                break;
            case R.id.mBtn_FBgroup:
                 socialMediaConnectivity = new SocialMediaConnectivity();
                intent = socialMediaConnectivity.fb_group(getContext());
                startActivity(intent);
                break;
            case R.id.mBtn_sendEmail:
                intAd.showInterstitial();
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_sendFragment);
                break;
            case R.id.mBtn_bcsSyllabus:
                urlLink = new Bundle();
                urlLink.putString("urlLink", "file:///android_asset/bcs_syllabus.html");
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_homeWebViewDefault, urlLink);
                break;
            case R.id.mBtn_bcsBookList:
                urlLink = new Bundle();
                urlLink.putString("urlLink", "file:///android_asset/bcs_book_list.html");
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_homeWebViewDefault, urlLink);
                break;
            default:
                try {
                    Toast.makeText(getContext(), "Some Error Might Happen!", Toast.LENGTH_SHORT).show();
                }catch (NullPointerException exception){
                    Toast.makeText(getContext(), exception.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}