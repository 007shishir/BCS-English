package com.saiful.bcsenglish.ui.mcq;

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
import com.saiful.bcsenglish.R;

/**
 * This fragment will show all the option(clickable TextView) for MCQ section
 * @author Saiful Islam
 * @since 7 March 2020
 * @version 2020.2
 */

public class McqFragment extends Fragment implements View.OnClickListener {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        McqViewModel mcqViewModel = new ViewModelProvider(this).get(McqViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mcq, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
        mcqViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        AdmobAd admobAd = new AdmobAd((AdView) root.findViewById(R.id.adView));
        admobAd.bannerAd_initialize();

        TextView mTxt_POS = root.findViewById(R.id.mTxt_POS);
        TextView mTxt_IdiomPhrase = root.findViewById(R.id.mTxt_IdiomPhrase);
        TextView mTxt_ClauseCorrections = root.findViewById(R.id.mTxt_ClauseCorrections);
        TextView mTxt_TransformationSentences = root.findViewById(R.id.mTxt_TransformationSentences);
        TextView mTxt_Voice = root.findViewById(R.id.mTxt_Voice);
        TextView mTxt_Degrees = root.findViewById(R.id.mTxt_Degrees);
        TextView mTxt_WordMeaning = root.findViewById(R.id.mTxt_WordMeaning);
        TextView mTxt_Synonyms = root.findViewById(R.id.mTxt_Synonyms);
        TextView mTxt_Antonyms = root.findViewById(R.id.mTxt_Antonyms);
        TextView mTxt_Spelling = root.findViewById(R.id.mTxt_Spelling);
        TextView mTxt_WordRest = root.findViewById(R.id.mTxt_WordRest);
        TextView mTxt_Narration = root.findViewById(R.id.mTxt_Narration);
        TextView mTxt_ConditionalSentence = root.findViewById(R.id.mTxt_ConditionalSentence);
        TextView mTxt_Analogy = root.findViewById(R.id.mTxt_Analogy);
        TextView mTxt_Diction = root.findViewById(R.id.mTxt_Diction);
        TextView mTxt_Translation = root.findViewById(R.id.mTxt_Translation);

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
        mTxt_Analogy.setOnClickListener(this);
        mTxt_Diction.setOnClickListener(this);
        mTxt_Translation.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.mTxt_POS:
                go_to_mcq_recView(getResources().getString(R.string.mcq_parts_of_speech), v);
                break;
            case R.id.mTxt_IdiomPhrase:
                go_to_mcq_recView(getResources().getString(R.string.mcq_Idioms_phrases), v);
                break;
            case R.id.mTxt_ClauseCorrections:
                go_to_mcq_recView(getResources().getString(R.string.mcq_clause_correction), v);
                break;
            case R.id.mTxt_TransformationSentences:
                go_to_mcq_recView(getResources().getString(R.string.mcq_trans_sentence), v);
                break;
            case R.id.mTxt_Voice:
                go_to_mcq_recView(getResources().getString(R.string.mcq_trans_voice), v);
                break;
            case R.id.mTxt_Degrees:
                go_to_mcq_recView(getResources().getString(R.string.mcq_trans_degree), v);
                break;
            case R.id.mTxt_WordMeaning:
                go_to_mcq_recView(getResources().getString(R.string.mcq_trans_word_mean), v);
                break;
            case R.id.mTxt_Synonyms:
                go_to_mcq_recView(getResources().getString(R.string.mcq_synonym), v);
                break;
            case R.id.mTxt_Antonyms:
                go_to_mcq_recView(getResources().getString(R.string.mcq_antonym), v);
                break;
            case R.id.mTxt_Spelling:
                go_to_mcq_recView(getResources().getString(R.string.mcq_spelling), v);
                break;
            case R.id.mTxt_WordRest:
                go_to_mcq_recView(getResources().getString(R.string.mcq_words_extra), v);
                break;
            case R.id.mTxt_Narration:
                go_to_mcq_recView(getResources().getString(R.string.mcq_narration), v);
                break;
            case R.id.mTxt_ConditionalSentence:
                go_to_mcq_recView(getResources().getString(R.string.mcq_conditonal), v);
                break;
            case R.id.mTxt_Analogy:
                go_to_mcq_recView(getResources().getString(R.string.mcq_analogy), v);
                break;
            case R.id.mTxt_Diction:
                go_to_mcq_recView(getResources().getString(R.string.mcq_diction), v);
                break;
            case R.id.mTxt_Translation:
                go_to_mcq_recView(getResources().getString(R.string.mcq_translation), v);
                break;
            default:
                //do nothing
                break;
        }
    }

    private void go_to_mcq_recView(String str, View v){
        Bundle child_name;
        child_name = new Bundle();
        child_name.putString("child_name", str);
        Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_mcqRecView, child_name);
    }

}