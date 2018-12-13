package com.noobs_team.avayeelahi.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.noobs_team.avayeelahi.R;

import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;
import com.noobs_team.avayeelahi.Time.PrayTime;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarMain;
    Button holidays;
    ImageView calendarActivity, volume1, volume2, volume3, volume4, volume5, volume6;
    boolean b1 = true, b2 = true, b3 = true, b4 = true, b5 = true, b6 = true;
    PersianCalendarView persianCalendarView;
    AccountHeader headerResult;
    TextView mainMenuHeaderToday, todayShamsi, todayMiladi, todayJalali;
    PersianCalendarHandler calendar;
    //PrayTime jDate;
    //PersianDate date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarMain = findViewById(R.id.toolbar_main);
        holidays = findViewById(R.id.holidays);
        calendarActivity = findViewById(R.id.calendar_activity);
        persianCalendarView = findViewById(R.id.persian_calendar);
        volume1 = findViewById(R.id.main_volume_1);
        volume2 = findViewById(R.id.main_volume_2);
        volume3 = findViewById(R.id.main_volume_3);
        volume4 = findViewById(R.id.main_volume_4);
        volume5 = findViewById(R.id.main_volume_5);
        volume6 = findViewById(R.id.main_volume_6);
        todayShamsi = findViewById(R.id.today_shamsi);
        todayMiladi = findViewById(R.id.today_miladi);
        todayJalali = findViewById(R.id.today_jalali);
        setupDrawer(this);
        mainMenuHeaderToday = headerResult
                .getView()
                .findViewById(R.id.material_drawer_account_header_today);
        holidays.setOnClickListener(mainOnClick);
        calendarActivity.setOnClickListener(mainOnClick);
        volume1.setOnClickListener(mainOnClick);
        volume2.setOnClickListener(mainOnClick);
        volume3.setOnClickListener(mainOnClick);
        volume4.setOnClickListener(mainOnClick);
        volume5.setOnClickListener(mainOnClick);
        volume6.setOnClickListener(mainOnClick);

        //todayJalali.setText((int) jTime);

        calendar = persianCalendarView.getCalendar();
        PersianDate today = calendar.getToday();
        String dayAndMonth = calendar.getWeekDayName(today)
                + " " + calendar.formatNumber(today.getDayOfMonth())
                + " " + calendar.getMonthName(today)
                + " " + calendar.formatNumber(today.getYear());
        mainMenuHeaderToday.setText(dayAndMonth);
    }

    private void setupDrawer(MainActivity mainActivity) {

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.accountHeaderColor)
                .withDividerBelowHeader(true)
                .addProfiles( new ProfileDrawerItem()
                        .withIcon(R.drawable.ic_avaye_elahi_logo_circle))
                .withSelectionListEnabled(false)
                .withProfileImagesClickable(false)
                .build();

        PrimaryDrawerItem homeItem = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(getResources().getColor(R.color.menuSelectedColor))
                .withName(R.string.menu_home)
                .withIcon(R.drawable.home);

        PrimaryDrawerItem asmaKhodaItem = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_asma_khoda)
                .withIcon(R.drawable.asma_allah);

        SecondaryDrawerItem zekrShomarItem = new SecondaryDrawerItem()
                .withLevel(2)
                .withIdentifier(6)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_zekr_shomar)
                .withIcon(R.drawable.zekr);

        SecondaryDrawerItem tasbihItem = new SecondaryDrawerItem()
                .withLevel(2)
                .withIdentifier(5)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_tasbih)
                .withIcon(R.drawable.tasbih);

        SecondaryDrawerItem azkarRouzanehItem = new SecondaryDrawerItem()
                .withLevel(2)
                .withIdentifier(4)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_azkar_rouzaneh)
                .withIcon(R.drawable.zekr);

        ExpandableDrawerItem jabehAbzarItem = new ExpandableDrawerItem()
                .withIdentifier(3)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_jabeh_abzar)
                .withIcon(R.drawable.jabe_eslami)
                .withSubItems(zekrShomarItem, tasbihItem, azkarRouzanehItem);

        PrimaryDrawerItem compassItem = new PrimaryDrawerItem()
                .withIdentifier(7)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_compass)
                .withIcon(R.drawable.compass);

        PrimaryDrawerItem changeDateItem = new PrimaryDrawerItem()
                .withIdentifier(9)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_change_date)
                .withIcon(R.drawable.change_date);

        PrimaryDrawerItem settingsItem = new PrimaryDrawerItem()
                .withIdentifier(8)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_settings)
                .withIcon(R.drawable.setting);

        PrimaryDrawerItem aboutUsItem = new PrimaryDrawerItem()
                .withIdentifier(10)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_about_us)
                .withIcon(R.drawable.about_us);

        /*PrimaryDrawerItem linkProgramItem = new PrimaryDrawerItem()
                .withIdentifier(11)
                .withSelectedTextColor(Color.parseColor("#000000"))
                .withSelectedColor(Color.parseColor("#FF83CEC6"))
                .withName(R.string.menu_send_program);*/

        final DrawerBuilder drawerBuilder = new DrawerBuilder()
        .withActivity(mainActivity)
        .withToolbar(this.toolbarMain)
        .withAccountHeader(headerResult)
        .withDrawerGravity(Gravity.RIGHT)
        .addDrawerItems(

                homeItem,
                new DividerDrawerItem(),
                asmaKhodaItem,
                jabehAbzarItem,
                compassItem,
                changeDateItem,
                new DividerDrawerItem(),
                settingsItem,
                aboutUsItem
                //linkProgramItem

        )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 10) {
                                intent = new Intent(MainActivity.this, AboutUsActivity.class);
                            } else if (drawerItem.getIdentifier() == 7) {
                                intent = new Intent(MainActivity.this, CompassActivity.class);
                            } else if (drawerItem.getIdentifier() == 6) {
                                intent = new Intent(MainActivity.this, ZekrShomarActivity.class);
                            } else if (drawerItem.getIdentifier() == 5) {
                                intent = new Intent(MainActivity.this, TasbihActivity.class);
                            } else if (drawerItem.getIdentifier() == 9) {
                                intent = new Intent(MainActivity.this, ChangeDateActivity.class);
                            } else if (drawerItem.getIdentifier() == 2) {
                                intent = new Intent(MainActivity.this, AsmaAllahActivity.class);
                            } else if (drawerItem.getIdentifier() == 4) {
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

    private View.OnClickListener mainOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.calendar_activity) {
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }
            if (v.getId() == R.id.holidays) {
                startActivity(new Intent(MainActivity.this, HolidaysActivity.class));
            }
            if (v.getId() == R.id.main_volume_1) {
                if (b1) {
                    volume1.setImageResource(R.drawable.silent);
                    b1 = false;
                } else if (!b1) {
                    volume1.setImageResource(R.drawable.medium);
                    b1 = true;
                }
            }
            if (v.getId() == R.id.main_volume_2) {
                if (b2) {
                    volume2.setImageResource(R.drawable.silent);
                    b2 = false;
                } else if (!b2) {
                    volume2.setImageResource(R.drawable.medium);
                    b2 = true;
                }
            }
            if (v.getId() == R.id.main_volume_3) {
                if (b3) {
                    volume3.setImageResource(R.drawable.silent);
                    b3 = false;
                } else if (!b3) {
                    volume3.setImageResource(R.drawable.medium);
                    b3 = true;
                }
            }
            if (v.getId() == R.id.main_volume_4) {
                if (b4) {
                    volume4.setImageResource(R.drawable.silent);
                    b4 = false;
                } else if (!b4) {
                    volume4.setImageResource(R.drawable.medium);
                    b4 = true;
                }
            }
            if (v.getId() == R.id.main_volume_5) {
                if (b5) {
                    volume5.setImageResource(R.drawable.silent);
                    b5 = false;
                } else if (!b5) {
                    volume5.setImageResource(R.drawable.medium);
                    b5 = true;
                }
            }
            if (v.getId() == R.id.main_volume_6) {
                if (b6) {
                    volume6.setImageResource(R.drawable.silent);
                    b6 = false;
                } else if (!b6) {
                    volume6.setImageResource(R.drawable.medium);
                    b6 = true;
                }
            }
        }
    };
}
