package com.noobs_team.avayeelahi.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.noobs_team.avayeelahi.R;

import java.util.Objects;

public class AboutUsActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarAboutUs;
    LinearLayout layoutTelegram;
    LinearLayout layoutEmail;
    LinearLayout layoutStar;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbarAboutUs = findViewById(R.id.toolbar_about_us);
        toolbarAboutUs.setTitle(R.string.app_activity_about_us);
        setSupportActionBar(toolbarAboutUs);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarAboutUs.setTitleTextColor(getResources().getColor(R.color.textTitleColor));

        layoutTelegram = findViewById(R.id.about_us_telegram_layout);
        layoutEmail = findViewById(R.id.about_us_email_layout);
        layoutStar = findViewById(R.id.about_us_star_layout);


        layoutTelegram.setOnClickListener(aboutUsClicker);
        layoutEmail.setOnClickListener(aboutUsClicker);
        layoutStar.setOnClickListener(aboutUsClicker);
    }

    private View.OnClickListener aboutUsClicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.about_us_telegram_layout) {

                final String appName = "org.telegram.messenger";
                final String appName2 = "com.hanista.mobogram";
                final String appName3 = "org.thunderdog.challegram";
                final boolean isAppInstalled = isAppAvailable(getApplicationContext(), appName);
                final boolean isAppInstalled2 = isAppAvailable(getApplicationContext(), appName2);
                final boolean isAppInstalled3 = isAppAvailable(getApplicationContext(), appName3);
                if (isAppInstalled || isAppInstalled2 || isAppInstalled3) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=Avaye_Elahi"));
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),getText(R.string.about_us_toast_telegram), Toast.LENGTH_SHORT).show();
                }

            }
            if (v.getId() == R.id.about_us_email_layout) {

                String[] to = {"avayeelahi@gmail.com"};
                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT, getText(R.string.about_us_email_subject));
                intent.putExtra(Intent.EXTRA_TEXT,"");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,getText(R.string.about_us_email_chooser)));
            }
            if (v.getId() == R.id.about_us_star_layout) {
                Toast.makeText(getApplicationContext(),"به زودی...!",Toast.LENGTH_SHORT).show();
            }
        }
    };

    public static boolean isAppAvailable(Context context, String appName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(appName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
