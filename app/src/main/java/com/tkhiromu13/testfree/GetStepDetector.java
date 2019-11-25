package com.tkhiromu13.testfree;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class GetStepDetector extends Activity {

    SensorManager sensorManager = (SensorManager) getSystemService (Context.SENSOR_SERVICE);
    public Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
}
