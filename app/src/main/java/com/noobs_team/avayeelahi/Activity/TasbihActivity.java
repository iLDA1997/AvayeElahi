package com.noobs_team.avayeelahi.Activity;

        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toolbar;

        import com.noobs_team.avayeelahi.R;

        import java.util.ArrayList;

        import devlight.io.library.ArcProgressStackView;

public class TasbihActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarTasbih;
    public final static int MODEL_COUNT = 3;
    private TextView topTextAllaho;
    private TextView topTextAlhamdo;
    private TextView topTextSobhan;
    int mode1 = 0, mode2 = 0, mode3 = 0;
    int count1 = 1, count2 = 1, count3 = 1;
    boolean m01 = true;
    boolean m02, m03 = false;
    boolean check1, check2 = false;
    boolean endTasbih = false;
    boolean switch1, switch2 = false;
    int vulomeCount = 2;
    // APSV
    private ArcProgressStackView mArcProgressStackView;
    private Button btnTasbihCounter;
    private Button btnTasbihRefresh;
    private Button btnTasbihMines;
    private Button btnTasbihVolume;
    // Parsed colors
    private int[] mStartColors = new int[MODEL_COUNT];
    private int[] mEndColors = new int[MODEL_COUNT];
    // First full size of APSV
    private int mFullSize = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);
        toolbarTasbih = findViewById(R.id.toolbar_tasbih);
        toolbarTasbih.setTitle(R.string.app_activity_tasbih);
        setSupportActionBar(toolbarTasbih);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarTasbih.setTitleTextColor(getResources().getColor(R.color.textTitleColor));

        topTextAllaho = findViewById(R.id.top_text_allaho);
        topTextAlhamdo = findViewById(R.id.top_text_alhamdo);
        topTextSobhan = findViewById(R.id.top_text_sobhan);

        btnTasbihCounter = findViewById(R.id.btn_tasbih_counter);
        btnTasbihRefresh = findViewById(R.id.btn_tasbih_refresh);
        btnTasbihMines = findViewById(R.id.btn_tasbih_mines);
        btnTasbihVolume = findViewById(R.id.btn_tasbih_volume);
        // Get APSV
        mArcProgressStackView = (ArcProgressStackView) findViewById(R.id.apsv_tasbih);
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
        models.add(new ArcProgressStackView.Model("الله اکبر", 0, Color.parseColor(bgColors[0]), mStartColors[0]));
        models.add(new ArcProgressStackView.Model("الحمدلله", 0, Color.parseColor(bgColors[1]), mStartColors[1]));
        models.add(new ArcProgressStackView.Model("سبحان الله", 1, Color.parseColor(bgColors[2]), mStartColors[2]));
        mArcProgressStackView.setModels(models);

        btnTasbihCounter.setOnClickListener(click);
        btnTasbihRefresh.setOnClickListener(click);
        btnTasbihMines.setOnClickListener(click);
        btnTasbihVolume.setOnClickListener(click);

    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_tasbih_counter) {
                if (count1 == 100 && count2 == 100 && count3 == 100) {
                    endTasbih = true;
                    btnTasbihCounter.setText("✔");
                    topTextAllaho.setText("34");
                }
                if (!endTasbih) {
                    if (m01) {
                        count1 = count1 + 3;
                        mArcProgressStackView.getModels().get(2).setProgress(count1);
                        mArcProgressStackView.animateProgress();
                        btnTasbihCounter.setText((mode1 + 1) + "");
                        topTextSobhan.setText((mode1 + 1) + "");
                        mode1++;
                    }

                    if (m02) {
                        count2 = count2 + 3;
                        mArcProgressStackView.getModels().get(1).setProgress(count2);
                        mArcProgressStackView.animateProgress();
                        btnTasbihCounter.setText((mode2 + 1) + "");
                        topTextAlhamdo.setText((mode2 + 1) + "");
                        mode2++;
                    }

                    if (m03) {
                        count3 = count3 + 3;
                        mArcProgressStackView.getModels().get(0).setProgress(count3);
                        mArcProgressStackView.animateProgress();
                        btnTasbihCounter.setText((mode3 + 1) + "");
                        topTextAllaho.setText((mode3 + 1) + "");
                        mode3++;
                    }

                    if (count1 == 100) {
                        if (!check1) {
                            m02 = true;
                            m01 = false;
                            mArcProgressStackView.getModels().get(1).setProgress(1);
                            check1 = true;
                            mArcProgressStackView.getModels().get(2).setProgress(100);
                        }
                    }

                    if (count2 == 100) {
                        if (!check2) {
                            m03 = true;
                            m02 = false;
                            mArcProgressStackView.getModels().get(0).setProgress(1);
                            check2 = true;
                            mArcProgressStackView.getModels().get(1).setProgress(100);
                        }
                    }

                }
            }

            if (v.getId() == R.id.btn_tasbih_refresh) {
                endTasbih = false;
                mode1 = 0;
                mode2 = 0;
                mode3 = 0;
                count1 = 1;
                count2 = 1;
                count3 = 1;
                m01 = true;
                m02 = false;
                m03 = false;
                check1 = false;
                check2 = false;
                mArcProgressStackView.getModels().get(2).setProgress(0);
                mArcProgressStackView.getModels().get(1).setProgress(0);
                mArcProgressStackView.getModels().get(0).setProgress(0);
                mArcProgressStackView.animateProgress();
                mArcProgressStackView.getModels().get(2).setProgress(1);
                mArcProgressStackView.getModels().get(1).setProgress(0);
                mArcProgressStackView.getModels().get(0).setProgress(0);
                btnTasbihCounter.setText("0");
                topTextAllaho.setText("0");
                topTextAlhamdo.setText("0");
                topTextSobhan.setText("0");
            }

            if (v.getId() == R.id.btn_tasbih_mines) {

                if (count1 > 1 && count1 < 100) {
                    count1 = count1 - 3;
                    mArcProgressStackView.getModels().get(2).setProgress(count1);
                    mArcProgressStackView.animateProgress();
                    btnTasbihCounter.setText((mode1 - 1) + "");
                    topTextSobhan.setText((mode1 - 1) + "");
                    mode1 = mode1 - 1;
                }
                if (count2 > 1 && count2 < 100) {
                    count2 = count2 - 3;
                    mArcProgressStackView.getModels().get(1).setProgress(count2);
                    mArcProgressStackView.animateProgress();
                    btnTasbihCounter.setText((mode2 - 1) + "");
                    topTextAlhamdo.setText((mode2 - 1) + "");
                    mode2 = mode2 - 1;
                    switch1 = true;
                }
                if (count3 > 1 && count3 < 100) {
                    count3 = count3 - 3;
                    mArcProgressStackView.getModels().get(0).setProgress(count3);
                    mArcProgressStackView.animateProgress();
                    btnTasbihCounter.setText((mode3 - 1) + "");
                    topTextAllaho.setText((mode3 - 1) + "");
                    mode3 = mode3 - 1;
                    switch2 = true;
                }

                if (!switch1) {
                    if (count1 == 100 && count2 == 1) {
                        count1 = count1 - 3;
                        mArcProgressStackView.getModels().get(1).setProgress(0);
                        mArcProgressStackView.getModels().get(2).setProgress(count1);
                        mArcProgressStackView.animateProgress();
                        mArcProgressStackView.getModels().get(1).setProgress(0);
                        btnTasbihCounter.setText((mode1 - 1) + "");
                        topTextSobhan.setText((mode1 - 1) + "");
                        mode1 = mode1 - 1;
                        m02 = false;
                        m01 = true;
                        check1 = false;
                    }
                }
                if (!switch2) {
                    if (count2 == 100 && count3 == 1) {
                        count2 = count2 - 3;
                        mArcProgressStackView.getModels().get(0).setProgress(0);
                        mArcProgressStackView.getModels().get(1).setProgress(count2);
                        mArcProgressStackView.animateProgress();
                        mArcProgressStackView.getModels().get(0).setProgress(0);
                        btnTasbihCounter.setText((mode2 - 1) + "");
                        topTextAlhamdo.setText((mode2 - 1) + "");
                        mode2 = mode2 - 1;
                        m03 = false;
                        m02 = true;
                        check2 = false;
                    }
                }
                switch1 = false;
                switch2 = false;

                if (count1 == 100 && count2 == 100 && count3 == 100) {
                    count3 = count3 - 3;
                    mArcProgressStackView.getModels().get(0).setProgress(count3);
                    mArcProgressStackView.animateProgress();
                    btnTasbihCounter.setText((mode3 - 1) + "");
                    topTextAllaho.setText((mode3 - 1) + "");
                    mode3 = mode3 - 1;
                    endTasbih = false;
                }
            }
            if (v.getId() == R.id.btn_tasbih_volume) {
                vulomeCount = vulomeCount + 1;
                if (vulomeCount%2 == 1){
                    btnTasbihVolume.setText(R.string.tasbih_btn_volume_off);
                    btnTasbihCounter.setSoundEffectsEnabled(false);
                    btnTasbihVolume.setSoundEffectsEnabled(false);
                    btnTasbihMines.setSoundEffectsEnabled(false);
                    btnTasbihRefresh.setSoundEffectsEnabled(false);
                }
                if (vulomeCount%2 == 0) {
                    btnTasbihVolume.setText(R.string.tasbih_btn_volume_on);
                    btnTasbihCounter.setSoundEffectsEnabled(true);
                    btnTasbihVolume.setSoundEffectsEnabled(true);
                    btnTasbihMines.setSoundEffectsEnabled(true);
                    btnTasbihRefresh.setSoundEffectsEnabled(true);
                }
            }
        }
    };
}

