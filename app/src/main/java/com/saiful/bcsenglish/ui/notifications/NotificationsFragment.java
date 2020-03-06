package com.saiful.bcsenglish.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.google.android.gms.ads.AdView;
import com.saiful.bcsenglish.AdmobAd;
import com.saiful.bcsenglish.Interstitial_ad;
import com.saiful.bcsenglish.R;

public class NotificationsFragment extends Fragment implements View.OnClickListener {

    private Interstitial_ad intAd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        AdmobAd admobAd = new AdmobAd((AdView) root.findViewById(R.id.adView));
        admobAd.bannerAd_initialize();
        intAd = new Interstitial_ad(getContext());
        intAd.createInterstitial();
        intAd.loadInterstitial();

        TextView mTxt_POS = root.findViewById(R.id.mTxt_POS);
        TextView mTxt_IdiomPhrase = root.findViewById(R.id.mTxt_IdiomPhrase);
        TextView mTxt_ClauseCorrections = root.findViewById(R.id.mTxt_ClauseCorrections);
        TextView mTxt_SentenceTransformations = root.findViewById(R.id.mTxt_SentenceTransformations);
        TextView mTxt_Words = root.findViewById(R.id.mTxt_Words);
        TextView mTxt_AdditionalSection = root.findViewById(R.id.mTxt_AdditionalSection);

        mTxt_POS.setOnClickListener(this);
        mTxt_IdiomPhrase.setOnClickListener(this);
        mTxt_ClauseCorrections.setOnClickListener(this);
        mTxt_SentenceTransformations.setOnClickListener(this);
        mTxt_Words.setOnClickListener(this);
        mTxt_AdditionalSection.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {
        Bundle child_name;
        switch (v.getId()) {

            case R.id.mTxt_POS:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Parts_of_Speech));
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_IdiomPhrase:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Idioms_Phrases));
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_ClauseCorrections:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Clause_Correction));
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_SentenceTransformations:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Transformation_Sentences));
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_Words:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_words_meaning));
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_AdditionalSection:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_additional_section));
                intAd.showInterstitial();
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            default:
                //do nothing
                break;
        }
    }
}