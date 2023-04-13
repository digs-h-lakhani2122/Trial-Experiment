package com.example.experiment_trial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ExperimentDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB = Room.databaseBuilder(this,ExperimentDatabase.class,"experimentdb").allowMainThreadQueries().build();
        mDB.getDao().insertExperiments(new Experiment("Experiment 1","2019-01-01"),
                new Experiment("Experiment 2", "2019-02-01"));
        List<Experiment> experiments = mDB.getDao().getExperimentsInDateRange("2019-01-01","2019-12-31");
        for (Experiment e: experiments) {
            Log.d("EXPERIMENTS", "Experiment is " + e.getExperimentName() + " on " + e.getExperimentDate());
        }

        experiments = mDB.getDao().getAllexperiments();
        for (Experiment e: experiments) {
            Log.d("EXPERIMENTS", "Experiment is " + e.getExperimentName() + " on " + e.getExperimentDate());
        }

        for (Experiment e: experiments) {
            mDB.getDao().insertTrial(new Trial(e.getExperimentId(),
                            "Variable for " + e.getExperimentName(),
                            "Result for Experiment on " + e.getExperimentDate()
                    )
            );
        }

        List<Trial> trials = mDB.getDao().getAllTrials();
        for (Trial t: trials ) {
            Log.d("TRIAL ", "Trial is for ExperimentID " + t.getParentExperiment() + "\n\tVariable = " + t.getTrialVariable() +
                    "Result = " + t.getTrialResult()
            );
        }


        List<Dao.TrialWithExperiment> trialsWithExperiments = mDB.getDao().getExperimentsWithTrials();

        for (Dao.TrialWithExperiment te:trialsWithExperiments) {
            Log.d(
                    "TRIALWITHEXPERIMENT",
                    "Experiment Name = " + te.getExperimentName() +
                            "\n\tExperiment Date = " + te.getExperimentDate() +
                            "\n\t\tTrial Variable = " + te.getTrialVariable() +
                            "\n\t\tTrial Result = " + te.getTrialResult()
            );

        }
    }
}