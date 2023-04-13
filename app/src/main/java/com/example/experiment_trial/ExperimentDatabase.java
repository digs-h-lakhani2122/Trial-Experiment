package com.example.experiment_trial;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Experiment.class, Trial.class}, version = 1,exportSchema = false)
public abstract class ExperimentDatabase extends RoomDatabase
{
    public abstract Dao getDao();
}
