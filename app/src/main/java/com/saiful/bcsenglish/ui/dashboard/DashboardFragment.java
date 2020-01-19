package com.saiful.bcsenglish.ui.dashboard;

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

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private DashboardViewModel dashboardViewModel;
    private TextView mTxt_POS, mTxt_IdiomPhrase, mTxt_ClauseCorrections, mTxt_TransformationSentences,
            mTxt_Voice, mTxt_Degrees, mTxt_WordMeaning, mTxt_Synonyms, mTxt_Antonyms, mTxt_Spelling,
            mTxt_WordRest, mTxt_Narration, mTxt_ConditionalSentence, mTxt_Analogy, mTxt_Diction, mTxt_Translation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        mTxt_POS = root.findViewById(R.id.mTxt_POS);
        mTxt_IdiomPhrase = root.findViewById(R.id.mTxt_IdiomPhrase);
        mTxt_ClauseCorrections = root.findViewById(R.id.mTxt_ClauseCorrections);
        mTxt_TransformationSentences = root.findViewById(R.id.mTxt_TransformationSentences);
        mTxt_Voice = root.findViewById(R.id.mTxt_Voice);
        mTxt_Degrees = root.findViewById(R.id.mTxt_Degrees);
        mTxt_WordMeaning = root.findViewById(R.id.mTxt_WordMeaning);
        mTxt_Synonyms = root.findViewById(R.id.mTxt_Synonyms);
        mTxt_Antonyms = root.findViewById(R.id.mTxt_Antonyms);
        mTxt_Spelling = root.findViewById(R.id.mTxt_Spelling);
        mTxt_WordRest = root.findViewById(R.id.mTxt_WordRest);
        mTxt_Narration = root.findViewById(R.id.mTxt_Narration);
        mTxt_ConditionalSentence = root.findViewById(R.id.mTxt_ConditionalSentence);
        mTxt_Diction = root.findViewById(R.id.mTxt_Diction);
        mTxt_Translation = root.findViewById(R.id.mTxt_Translation);

        mTxt_POS.setOnClickListener(this);
        mTxt_IdiomPhrase.setOnClickListener(this);
        mTxt_ClauseCorrections.setOnClickListener(this);
        mTxt_TransformationSentences.setOnClickListener(this);
        mTxt_Voice.setOnClickListener(this);
        mTxt_Degrees.setOnClickListener(this);
        mTxt_WordMeaning.setOnClickListener(this);
        mTxt_Synonyms.setOnClickListener(this);
        mTxt_Antonyms.setOnClickListener(this);
        mTxt_Spelling.setOnClickListener(this);
        mTxt_WordRest.setOnClickListener(this);
        mTxt_Narration.setOnClickListener(this);
        mTxt_ConditionalSentence.setOnClickListener(this);
        mTxt_Diction.setOnClickListener(this);
        mTxt_Translation.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        Bundle child_name;
        switch (v.getId()) {
            case R.id.mTxt_POS:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.mcq_parts_of_speech));
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_mcqRecView, child_name);
                break;
            case R.id.mTxt_IdiomPhrase:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.mcq_Idioms_phrases));
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_mcqRecView, child_name);
                break;
            case R.id.mTxt_ClauseCorrections:
                child_name = new Bundle();
                child_name.putString("child_name", getResources().getString(R.string.mcq_clause_correction));
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_mcqRecView, child_name);
                break;
            case R.id.mTxt_TransformationSentences:
                break;
            case R.id.mTxt_Voice:
                break;
            case R.id.mTxt_Degrees:
                break;
            case R.id.mTxt_WordMeaning:
                break;
            case R.id.mTxt_Synonyms:
                break;
            case R.id.mTxt_Antonyms:
                break;
            case R.id.mTxt_Spelling:
                break;
            case R.id.mTxt_WordRest:
                break;
            case R.id.mTxt_Narration:
                break;
            case R.id.mTxt_ConditionalSentence:
                break;
            case R.id.mTxt_Analogy:
                break;
            case R.id.mTxt_Diction:
                break;
            case R.id.mTxt_Translation:
                break;
        }
    }
}