package com.example.experiment_trial;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Experiment
{
    @PrimaryKey(autoGenerate = true)
    private long experimentId;
    private String experimentName;
    private String experimentDate;

    public Experiment() {
    }

    @Ignore
    public Experiment(String name, String date) {
        this.experimentName = name;
        this.experimentDate = date;
    }

    public long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getExperimentDate() {
        return experimentDate;
    }

    public void setExperimentDate(String experimentDate) {
        this.experimentDate = experimentDate;
    }
}
