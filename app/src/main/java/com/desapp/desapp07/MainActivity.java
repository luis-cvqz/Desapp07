package com.desapp.desapp07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.desapp.desapp07.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getLocalScore().observe(this, localScore -> updateLocalScore(localScore));

        viewModel.getVisitorScore().observe(this, visitorScore -> updateVisitorScore(visitorScore));
    }

    private void updateLocalScore(int localScore) {
        binding.textLocalScore.setText(String.valueOf(localScore));
    }

    private void updateVisitorScore(int visitorScore) {
        binding.textVisitorScore.setText(String.valueOf(visitorScore));
    }

    public void localDecreaseOne(View view) {
        viewModel.decreasePoints(MainViewModel.LOCAL_SCORE);
    }

    public void localAddOne(View view) {
        viewModel.addPoints(1, MainViewModel.LOCAL_SCORE);
    }

    public void localAddTwo(View view) {
        viewModel.addPoints(2, MainViewModel.LOCAL_SCORE);
    }

    public void resetCount(View view) {
        viewModel.resetPoints();
    }

    public void viewResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);

        String finalLocalScore = viewModel.getLocalScore().getValue().toString();
        String finalVisitorScore = viewModel.getVisitorScore().getValue().toString();

        intent.putExtra(ResultsActivity.LOCAL_SCORE_KEY, finalLocalScore);
        intent.putExtra(ResultsActivity.VISITOR_SCORE_KEY, finalVisitorScore);

        //intent.putExtra(ResultsActivity.LOCAL_SCORE_KEY, String.valueOf(viewModel.getLocalScore().getValue()));
        //intent.putExtra(ResultsActivity.VISITOR_SCORE_KEY, String.valueOf(viewModel.getVisitorScore().getValue()));

        startActivity(intent);
    }

    public void visitorDecreaseOne(View view) {
        viewModel.decreasePoints(MainViewModel.VISITOR_SCORE);
    }

    public void visitorAddOne(View view) {
        viewModel.addPoints(1, MainViewModel.VISITOR_SCORE);
    }

    public void visitorAddTwo(View view) {
        viewModel.addPoints(2, MainViewModel.VISITOR_SCORE);
    }
}