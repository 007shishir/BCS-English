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
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.saiful.bcsenglish.R;

public class NotificationsFragment extends Fragment implements View.OnClickListener {

    private NotificationsViewModel notificationsViewModel;
    private TextView mTxt_POS, mTxt_IdiomPhrase, mTxt_ClauseCorrections,
            mTxt_SentenceTransformations, mTxt_Words, mTxt_AdditionalSection;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        mTxt_POS = root.findViewById(R.id.mTxt_POS);
        mTxt_IdiomPhrase = root.findViewById(R.id.mTxt_IdiomPhrase);
        mTxt_ClauseCorrections = root.findViewById(R.id.mTxt_ClauseCorrections);
        mTxt_SentenceTransformations = root.findViewById(R.id.mTxt_SentenceTransformations);
        mTxt_Words = root.findViewById(R.id.mTxt_Words);
        mTxt_AdditionalSection = root.findViewById(R.id.mTxt_AdditionalSection);

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
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_IdiomPhrase:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Idioms_Phrases));
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_ClauseCorrections:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Clause_Correction));
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_SentenceTransformations:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_Transformation_Sentences));
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_Words:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_words_meaning));
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            case R.id.mTxt_AdditionalSection:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.memorise_additional_section));
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_memoriseRecView, child_name);
                break;
            default:
                //do nothing
                break;
        }
    }
}