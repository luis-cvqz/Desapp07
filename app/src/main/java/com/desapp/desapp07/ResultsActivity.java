package com.desapp.desapp07;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.desapp.desapp07.databinding.ActivityResultsBinding;

public class ResultsActivity extends AppCompatActivity {
    public static final String LOCAL_SCORE_KEY = "localScore_key";
    public static final String VISITOR_SCORE_KEY = "visitorScore_key";

    ActivityResultsBinding binding;
    private ResultsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ResultsViewModel.class);

        Bundle extras = getIntent().getExtras();
        String finalLocalScore = extras.getString(LOCAL_SCORE_KEY);
        String finalVisitorScore = extras.getString(VISITOR_SCORE_KEY);

        viewModel.setFinalScores(finalLocalScore, finalVisitorScore);
        viewModel.setMessage(finalLocalScore, finalVisitorScore);

        binding.setFinalLocalScore(String.valueOf(viewModel.getFinalLocalScore()));
        binding.setFinalVisitorScore(String.valueOf(viewModel.getFinalVisitorScore()));

        binding.textMessage.setText(viewModel.getMessage());
    }
}