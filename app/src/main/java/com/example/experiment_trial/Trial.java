package com.example.experiment_trial;

import android.provider.BaseColumns;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Trial
{
    @PrimaryKey(autoGenerate = true)
    private long trialId;
    @ForeignKey(entity = Experiment.class, parentColumns = {BaseColumns._ID},childColumns = "parentExperiment", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    private long parentExperiment;
    private String trialVariable;
    private String trialResult;

    public Trial() {
    }

    @Ignore
    public Trial(long parentExperimentId, String variable, String result) {
        this.parentExperiment = parentExperimentId;
        this.trialVariable = variable;
        this.trialResult = result;
    }

    public long getTrialId() {
        return trialId;
    }

    public void setTrialId(long trialId) {
        this.trialId = trialId;
    }

    public long getParentExperiment() {
        return parentExperiment;
    }

    public void setParentExperiment(long parentExperiment) {
        this.parentExperiment = parentExperiment;
    }

    public String getTrialVariable() {
        return trialVariable;
    }

    public void setTrialVariable(String trialVariable) {
        this.trialVariable = trialVariable;
    }

    public String getTrialResult() {
        return trialResult;
    }

    public void setTrialResult(String trialResult) {
        this.trialResult = trialResult;
    }
}
