package com.desapp.desapp07;

import android.content.Intent;

import androidx.lifecycle.ViewModel;

public class ResultsViewModel extends ViewModel {
    private String finalLocalScore;
    private String finalVisitorScore;

    private String message;

    public void setFinalScores(String localScore, String visitorScore) {
        finalLocalScore = localScore;
        finalVisitorScore = visitorScore;
    }

    public String getFinalLocalScore() {
        return finalLocalScore;
    }

    public String getFinalVisitorScore() {
        return finalVisitorScore;
    }

    public void setMessage(String finalLocalScore, String finalVisitorScore) {
        int localScore = Integer.parseInt(finalLocalScore);
        int visitorScore = Integer.parseInt(finalVisitorScore);

        if (localScore == visitorScore) {
            message = "Es un empate.";
        } else if (localScore > visitorScore) {
            message = "Gana el equipo local.";
        } else {
            message = "Gana el equipo visitante.";
        }
    }

    public String getMessage() {
        return message;
    }
}
