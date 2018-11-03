package com.noobs_team.avayeelahi.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.hardware.SensorEventListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.noobs_team.avayeelahi.R;

import static com.noobs_team.avayeelahi.R.string.compass_top_text;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    private ImageView compassImage;
    private TextView poleView;
    private TextView poleDirection;
    private TextView degreeVeiw;
    private TextView degree;
    private SensorManager directionSensor;
    private float currentDegree = 0f;

    android.support.v7.widget.Toolbar toolbarCompass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        toolbarCompass = findViewById(R.id.toolbar_compass);
        toolbarCompass.setTitle(R.string.app_activity_compass);
        setSupportActionBar(toolbarCompass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarCompass.setTitleTextColor(getResources().getColor(R.color.textTitleColor));

        poleDirection = findViewById(R.id.poleDirection);
        degree = findViewById(R.id.degree);
        //Setting compass image
        compassImage = (ImageView) findViewById(R.id.compassImageView);
        //setting a pole textview
        poleView = (TextView) findViewById(R.id.poleDirectionView);
        //setting a digree textview
        degreeVeiw = (TextView) findViewById(R.id.degreeView);
        //allows Sensor manager to the sensor service
        directionSensor = (SensorManager) getSystemService(SENSOR_SERVICE);

        degreeVeiw.setText("");
        poleView.setText("");

        Button guidanceText = findViewById(R.id.guidanceCompass);
        guidanceText.setOnClickListener(compassClick);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (directionSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null &&  directionSensor.getDefaultSensor(Sensor.TYPE_ORIENTATION) != null) {
            // success! we have an accelerometer
            directionSensor.registerListener(this, directionSensor.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                    SensorManager.SENSOR_DELAY_GAME);
        } else {
            // fail! we dont have an accelerometer!
            Toast.makeText(getApplicationContext(),R.string.compass_top_text,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (directionSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null &&  directionSensor.getDefaultSensor(Sensor.TYPE_ORIENTATION) != null) {
            // success! we have an accelerometer
            directionSensor.unregisterListener(this);
        } else {
            // fail! we dont have an accelerometer!
            Toast.makeText(getApplicationContext(),R.string.compass_top_text,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        //get the numbers of degree of direction
        float degreeOfDir = Math.round(event.values[0]);
        degreeVeiw.setText(" " + Float.toString(degreeOfDir));
        /* you need to figure out all values that degree of circle of compass and compass that moved around.
         * understand that degree of direction the compass is clockwise, but not counter-clockwise.
         * the compass needs to be set 0 to 360 degree and set the pole  */
        if (degreeOfDir == 0 || degreeOfDir == 360) {
            poleView.setText(getString(R.string.DirNorth));
        } else if (degreeOfDir > 0 && degreeOfDir < 90) {
            if (degreeOfDir > 0 && degreeOfDir < 15) {
                poleView.setText(getString(R.string.DirNorth));
            } else if (degreeOfDir >= 15 && degreeOfDir < 35) {
                poleView.setText(getString(R.string.DirNorthNorthEast));
            } else if (degreeOfDir >= 35 && degreeOfDir < 55) {
                poleView.setText(getString(R.string.DirNorthEast));
            } else if (degreeOfDir >= 55 && degreeOfDir < 75) {
                poleView.setText(getString(R.string.DirEastNorthEast));
            } else if (degreeOfDir >= 75 && degreeOfDir <= 89) {
                poleView.setText(getString(R.string.DirEast));
            }
        } else if (degreeOfDir == 90) {
            poleView.setText(getString(R.string.DirEast));
        } else if (degreeOfDir > 90 && degreeOfDir < 180) {
            if (degreeOfDir > 90 && degreeOfDir < 105) {
                poleView.setText(getString(R.string.DirEast));
            } else if (degreeOfDir >= 105 && degreeOfDir < 125) {
                poleView.setText(getString(R.string.DirEastSouthEast));
            } else if (degreeOfDir >= 125 && degreeOfDir < 145) {
                poleView.setText(getString(R.string.DirSouthEast));
            } else if (degreeOfDir >= 145 && degreeOfDir < 165) {
                poleView.setText(getString(R.string.DirSouthSouthEast));
            } else if (degreeOfDir >= 165 && degreeOfDir <= 179) {
                poleView.setText(getString(R.string.DirSouth));
            }
        } else if (degreeOfDir == 180) {
            poleView.setText(getString(R.string.DirSouth));
        } else if (degreeOfDir > 180 && degreeOfDir < 270) {
            if (degreeOfDir > 180 && degreeOfDir < 195) {
                poleView.setText(getString(R.string.DirSouth));
            } else if (degreeOfDir >= 195 && degreeOfDir < 215) {
                poleView.setText(getString(R.string.DirSouthSouthWest));
            } else if (degreeOfDir >= 215 && degreeOfDir < 235) {
                poleView.setText(getString(R.string.DirSouthWest));
            } else if (degreeOfDir >= 235 && degreeOfDir < 255) {
                poleView.setText(getString(R.string.DirWestSouthWest));
            } else if (degreeOfDir >= 255 && degreeOfDir <= 269) {
                poleView.setText(getString(R.string.DirWest));
            }
        } else if (degreeOfDir == 270) {
            poleView.setText(getString(R.string.DirWest));
        } else if (degreeOfDir > 270 && degreeOfDir < 360) {
            if (degreeOfDir > 270 && degreeOfDir < 285) {
                poleView.setText(getString(R.string.DirWest));
            } else if (degreeOfDir >= 285 && degreeOfDir < 305) {
                poleView.setText(getString(R.string.DirWestNorthWest));
            } else if (degreeOfDir >= 305 && degreeOfDir < 325) {
                poleView.setText(getString(R.string.DirNorthwest));
            } else if (degreeOfDir >= 325 && degreeOfDir < 345) {
                poleView.setText(getString(R.string.DirNorthNorthWest));
            } else if (degreeOfDir >= 345 && degreeOfDir <= 359) {
                poleView.setText(getString(R.string.DirNorth));
            }
        }
        // set the rotation animation to rotate compass image and pole image around.
        RotateAnimation rotateAnimation = new RotateAnimation(currentDegree, -degreeOfDir, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(210);
        rotateAnimation.setFillAfter(true);

        compassImage.startAnimation(rotateAnimation);
        currentDegree = -degreeOfDir;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub

    }

    View.OnClickListener compassClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(CompassActivity.this, GuidanceActivity.class);
            startActivity(intent);
        }
    };
}