package com.noobs_team.avayeelahi.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.noobs_team.avayeelahi.R;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarMain;
    Button holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarMain = findViewById(R.id.toolbar_main);
        holidays = findViewById(R.id.holidays);
        setupDrawer(this, toolbarMain);
        holidays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HolidaysActivity.class));
            }
        });
    }

    private void setupDrawer(MainActivity mainActivity, Toolbar toolbarMain) {

        toolbarMain.setTitle(R.string.app_name_fa);
        toolbarMain.setLogo(R.mipmap.ic_launcher);
        toolbarMain.setTitleTextColor(Color.parseColor("#ffffff"));

        PrimaryDrawerItem homeItem = new PrimaryDrawerItem().withIdentifier(1).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_home);
        PrimaryDrawerItem asmaKhodaItem = new PrimaryDrawerItem().withIdentifier(2).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_asma_khoda);

        SecondaryDrawerItem azkarRouzanehItem = new SecondaryDrawerItem().withLevel(2).withIdentifier(4).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_azkar_rouzaneh);
        SecondaryDrawerItem tasbihItem = new SecondaryDrawerItem().withLevel(2).withIdentifier(5).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_tasbih);
        SecondaryDrawerItem zekrShomarItem = new SecondaryDrawerItem().withLevel(2).withIdentifier(6).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_zekr_shomar);
        ExpandableDrawerItem jabehAbzarItem = new ExpandableDrawerItem().withIdentifier(3).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_jabeh_abzar).withSubItems(
                tasbihItem, zekrShomarItem,azkarRouzanehItem
        );
        PrimaryDrawerItem compassItem = new PrimaryDrawerItem().withIdentifier(7).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_compass);
        PrimaryDrawerItem settingsItem = new PrimaryDrawerItem().withIdentifier(8).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_settings);
        PrimaryDrawerItem changeDateItem = new PrimaryDrawerItem().withIdentifier(9).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_change_date);
        PrimaryDrawerItem aboutUsItem = new PrimaryDrawerItem().withIdentifier(10).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_about_us);
        PrimaryDrawerItem linkProgramItem = new PrimaryDrawerItem().withIdentifier(11).withSelectedTextColor(Color.parseColor("#000000")).withSelectedColor(Color.parseColor("#FF83CEC6")).withName(R.string.menu_send_program);


        final DrawerBuilder drawerBuilder = new DrawerBuilder();
        drawerBuilder.withActivity(mainActivity);
        drawerBuilder.withToolbar(this.toolbarMain);
        drawerBuilder.withSliderBackgroundDrawableRes(R.drawable.side_nav_bar);
        drawerBuilder.withDrawerGravity(Gravity.END);
        drawerBuilder.addDrawerItems(

                homeItem,
                new DividerDrawerItem(),
                asmaKhodaItem,
                jabehAbzarItem,
                compassItem,
                changeDateItem,
                new DividerDrawerItem(),
                settingsItem,
                aboutUsItem,
                linkProgramItem

        )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 10) {
                                intent = new Intent(MainActivity.this, AboutUsActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 7) {
                                intent = new Intent(MainActivity.this, CompassActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 6) {
                                intent = new Intent(MainActivity.this, ZekrShomarActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 5) {
                                intent = new Intent(MainActivity.this, TasbihActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 11) {
                                intent = new Intent(MainActivity.this, CalendarActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 9) {
                                intent = new Intent(MainActivity.this, ChangeDateActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 2) {
                                intent = new Intent(MainActivity.this, AsmaAllahActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 4) {
                                intent = new Intent(MainActivity.this, AzkarRouzanehActivity.class);
                            }

                            if (intent != null) {
                                MainActivity.this.startActivity(intent);
                            }
                            return false;
                        }
                        return false;
                    }
                })
                .withActionBarDrawerToggleAnimated(true);
        Drawer result = drawerBuilder.build();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle(R.string.app_name_fa);
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher_round);

        alertDialogBuilder
                .setMessage(R.string.dialog_message)
                .setCancelable(true)
                .setPositiveButton(R.string.dialog_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }
                })
                .setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNeutralButton(R.string.dialog_comment, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setData(Uri.parse("bazaar://details?id=" + PACKAGE_NAME));
                        intent.setPackage("com.farsitel.bazaar");
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
