package com.example.engg6600.accelerometer;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private TextView xField, yField, zField, lightField, proximityField;

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
        //not used
    }

    SensorManager sm;

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//            xField.setText("X: "+ event.values[0]);
//            yField.setText("Y: "+ event.values[1]);
//            zField.setText("Z: "+ event.values[2]);
            String stringX = "X: "+ event.values[0];
            String stringY = "Y: "+ event.values[1];
            String stringZ = "Z: "+ event.values[2];
            xField.setText(stringX);
            yField.setText(stringY);
            zField.setText(stringZ);
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            String stringLight = "Light:"+ event.values[0];
            lightField.setText(stringLight);
        }
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            String stringProximity = "Proximity:" + event.values[0];
            proximityField.setText(stringProximity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

		Sensor accelerometerSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		Sensor lightSensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
		Sensor proximitySensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

		sm.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);

        xField = (TextView)findViewById(R.id.textView);
        yField = (TextView)findViewById(R.id.textView2);
        zField = (TextView)findViewById(R.id.textView3);
        lightField = (TextView)findViewById(R.id.textView4);
        proximityField = (TextView)findViewById(R.id.textView5);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        sm.unregisterListener(this);
//    }

}
