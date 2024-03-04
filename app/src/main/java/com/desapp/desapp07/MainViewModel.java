package com.desapp.desapp07;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final String LOCAL_SCORE = "localScore";
    public static final String VISITOR_SCORE = "visitorScore";

    private final MutableLiveData<Integer> localScore = new MutableLiveData<>();
    private final MutableLiveData<Integer> visitorScore = new MutableLiveData<>();

    public MainViewModel() {
        localScore.setValue(0);
        visitorScore.setValue(0);
    }

    public LiveData<Integer> getLocalScore() {
        return localScore;
    }

    public LiveData<Integer> getVisitorScore() {
        return visitorScore;
    }

    public void addPoints(int pointsToAdd, String teamScore) {
        switch (teamScore) {
            case LOCAL_SCORE:
                localScore.setValue(localScore.getValue() + pointsToAdd);
                break;
            case VISITOR_SCORE:
                visitorScore.setValue(visitorScore.getValue() + pointsToAdd);
                break;
            default:
                break;
        }
    }

    public void decreasePoints(String teamScore) {
        switch (teamScore) {
            case LOCAL_SCORE:
                if (localScore.getValue() > 0)
                    localScore.setValue(localScore.getValue() - 1);
                break;
            case VISITOR_SCORE:
                if (visitorScore.getValue() > 0)
                    visitorScore.setValue(visitorScore.getValue() - 1);
                break;
            default:
                break;
        }
    }

    public void resetPoints() {
        localScore.setValue(0);
        visitorScore.setValue(0);
    }
}
