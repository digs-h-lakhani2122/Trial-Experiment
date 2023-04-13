package com.example.experiment_trial;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertExperiments(Experiment... experiments);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertExperiment(Experiment experiment);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTrials(Trial... trials);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTrial(Trial trial);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    int updateExperiments(Experiment... experiments);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    int updateExperiment(Experiment experiment);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    int updateTrials(Trial... trials);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    int updateTrial(Trial trial);

    @Delete
    int deleteExperiments(Experiment... experiments);

    @Delete
    int deleteExperiment(Experiment experiment);

    @Delete
    int deleteTrials(Trial... trials);

    @Delete
    int deleteTrial(Trial trial);

    @Query("SELECT * FROM Experiment")
    List<Experiment> getAllexperiments();

    @Query("SELECT * FROM Experiment WHERE experimentDate BETWEEN :startdate AND :enddate")
    List<Experiment> getExperimentsInDateRange(String startdate, String enddate);

    @Query("SELECT * FROM Trial")
    List<Trial> getAllTrials();

    @Query("SELECT * FROM Experiment JOIN Trial ON parentExperiment = experimentId")
    List<TrialWithExperiment> getExperimentsWithTrials();


    class TrialWithExperiment {
        private long experimentId;
        private String experimentName;
        private String experimentDate;
        private long trialId;
        private String trialVariable;
        private String trialResult;

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

        public void setTrialId(long trialId) {
            this.trialId = trialId;
        }

        public long getTrialId() {
            return trialId;
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
}
