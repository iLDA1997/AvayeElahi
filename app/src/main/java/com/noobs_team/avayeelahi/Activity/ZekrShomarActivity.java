package com.noobs_team.avayeelahi.Activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.noobs_team.avayeelahi.R;

import java.util.ArrayList;
import java.util.Objects;

import devlight.io.library.ArcProgressStackView;

public class ZekrShomarActivity extends AppCompatActivity {

    public final static int MODEL_COUNT = 1;
    private TextView topTextZekr;
    int vulomeCount = 2;
    int zekrCounter = 0;
    private Button btnZekrCounter;
    private Button btnZekrRefresh;
    private Button btnZekrMines;
    private Button btnZekrVolume;
    // Parsed colors
    private int[] mStartColors = new int[MODEL_COUNT];
    private int[] mEndColors = new int[MODEL_COUNT];
    // First full size of APSV
    private int mFullSize = -1;
    android.support.v7.widget.Toolbar toolbarZekrShomar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zekr_shomar);

        toolbarZekrShomar = findViewById(R.id.toolbar_zekr_shomar);
        toolbarZekrShomar.setTitle(R.string.app_activity_zekr_shomar);
        setSupportActionBar(toolbarZekrShomar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarZekrShomar.setTitleTextColor(getResources().getColor(R.color.textTitleColor));

        topTextZekr = findViewById(R.id.top_text_zekr);

        btnZekrCounter = findViewById(R.id.btn_zekr_counter);
        btnZekrRefresh = findViewById(R.id.btn_zekr_refresh);
        btnZekrMines = findViewById(R.id.btn_zekr_mines);
        btnZekrVolume = findViewById(R.id.btn_zekr_volume);

        // Get APSV
        ArcProgressStackView mArcProgressStackView = (ArcProgressStackView) findViewById(R.id.apsv_zekr);
        // Get colors
        final String[] startColors = getResources().getStringArray(R.array.polluted_waves);
        final String[] endColors = getResources().getStringArray(R.array.default_preview);
        final String[] bgColors = getResources().getStringArray(R.array.medical_express);
        // Parse colors
        for (int i = 0; i < MODEL_COUNT; i++) {
            mStartColors[i] = Color.parseColor(startColors[i]);
            mEndColors[i] = Color.parseColor(endColors[i]);
        }
        // Set models
        final ArrayList<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("", 100, Color.parseColor(bgColors[0]), mStartColors[0]));
        mArcProgressStackView.setModels(models);

        btnZekrCounter.setOnClickListener(click);
        btnZekrRefresh.setOnClickListener(click);
        btnZekrMines.setOnClickListener(click);
        btnZekrVolume.setOnClickListener(click);

    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_zekr_counter) {
                zekrCounter = zekrCounter + 1;
                btnZekrCounter.setText(zekrCounter + "");
                topTextZekr.setText(zekrCounter + "");
            }

            if (v.getId() == R.id.btn_zekr_refresh) {
                zekrCounter = 0;
                btnZekrCounter.setText(zekrCounter + "");
                topTextZekr.setText(zekrCounter + "");
            }

            if (v.getId() == R.id.btn_zekr_mines) {
                zekrCounter = zekrCounter - 1;
                if (zekrCounter<0)
                    zekrCounter=0;
                btnZekrCounter.setText(zekrCounter + "");
                topTextZekr.setText(zekrCounter + "");
            }
            if (v.getId() == R.id.btn_zekr_volume) {
                vulomeCount = vulomeCount + 1;
                if (vulomeCount%2 == 1){
                    btnZekrVolume.setText(R.string.zekr_btn_volume_off);
                    btnZekrCounter.setSoundEffectsEnabled(false);
                    btnZekrVolume.setSoundEffectsEnabled(false);
                    btnZekrMines.setSoundEffectsEnabled(false);
                    btnZekrRefresh.setSoundEffectsEnabled(false);
                }
                if (vulomeCount%2 == 0) {
                    btnZekrVolume.setText(R.string.zekr_btn_volume_on);
                    btnZekrCounter.setSoundEffectsEnabled(true);
                    btnZekrVolume.setSoundEffectsEnabled(true);
                    btnZekrMines.setSoundEffectsEnabled(true);
                    btnZekrRefresh.setSoundEffectsEnabled(true);
                }
            }
        }
    };
}

