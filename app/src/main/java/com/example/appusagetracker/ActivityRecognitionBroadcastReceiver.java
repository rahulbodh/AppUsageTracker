package com.example.appusagetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.ActivityRecognitionResult;

import java.util.List;

public class ActivityRecognitionBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "ActivityAPI";


    @Override
    public void onReceive(Context context, Intent intent) {
        if (ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            if(result != null){
                List<DetectedActivity> probableActivities = result.getProbableActivities();
                DetectedActivity mostProbableActivity = result.getMostProbableActivity();
                int activityType = mostProbableActivity.getType();
                int confidence = mostProbableActivity.getConfidence();
                if(activityType == DetectedActivity.ON_FOOT){
                    Log.d(TAG, "On Foot: " + confidence);
                }else if(activityType == DetectedActivity.WALKING){
                    Log.d(TAG, "Walking: " + confidence);
                }else if(activityType == DetectedActivity.RUNNING){
                    Log.d(TAG, "Running: " + confidence);
                }else if (activityType == DetectedActivity.STILL){
                    Log.d(TAG, "Still: " + confidence);
                }else if (activityType == DetectedActivity.TILTING){
                    Log.d(TAG, "Tilting: " + confidence);
                }else if (activityType == DetectedActivity.UNKNOWN){
                    Log.d(TAG, "Unknown: " + confidence);
                }else if (activityType == DetectedActivity.IN_VEHICLE){
                    Log.d(TAG, "In Vehicle: " + confidence);
                }else if (activityType == DetectedActivity.ON_BICYCLE){
                    Log.d(TAG, "On Bicycle: " + confidence);
                }else if (activityType == DetectedActivity.ON_FOOT){
                    Log.d(TAG, "On Foot: " + confidence);
                }
            }

//            handleDetectedActivities(result.getProbableActivities());
        }
    }

    private void handleDetectedActivities(List<DetectedActivity> probableActivities) {
        for (DetectedActivity activity : probableActivities) {
            switch (activity.getType()) {
                case DetectedActivity.IN_VEHICLE:
                    Log.d(TAG, "In Vehicle: " + activity.getConfidence());
                    break;
                case DetectedActivity.ON_BICYCLE:
                    Log.d(TAG, "On Bicycle: " + activity.getConfidence());
                    break;
                case DetectedActivity.ON_FOOT:
                    Log.d(TAG, "On Foot: " + activity.getConfidence());
                    break;
                case DetectedActivity.RUNNING:
                    Log.d(TAG, "Running: " + activity.getConfidence());
                    break;
                case DetectedActivity.STILL:
                    Log.d(TAG, "Still: " + activity.getConfidence());
                    break;
                case DetectedActivity.WALKING:
                    Log.d(TAG, "Walking: " + activity.getConfidence());
                    break;
                case DetectedActivity.TILTING:
                    Log.d(TAG, "Tilting: " + activity.getConfidence());
                    break;
                case DetectedActivity.UNKNOWN:
                    Log.d(TAG, "Unknown Activity: " + activity.getConfidence());
                    break;
                default:
                    Log.d(TAG, "Other Activity: " + activity.getConfidence());
                    break;
            }
        }
    }
}
