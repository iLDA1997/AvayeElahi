package com.noobs_team.avayeelahi.Utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutUtil
{

    public static void setupTabIcons(Context context, TabLayout tabLayout, ArrayList<Integer> ids, int selectedTab, int selectedColor, int unSelectedColor)
    {
        for (int i = 0; i < ids.size(); i++)
            tabLayout.getTabAt(i).setIcon(ids.get(i));
        tabLayout.getTabAt(selectedTab).select();
        for (int i = 0; i < ids.size(); i++)
        {
            if (i == selectedTab)
            {
                int tabIconColor = ContextCompat.getColor(context, selectedColor);
                tabLayout.getTabAt(i).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
            else
            {
                int tabIconColor = ContextCompat.getColor(context, unSelectedColor);
                tabLayout.getTabAt(i).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public static void setupTabIcons(final Context context, TabLayout tabLayout, int[] ids, final int selectedTab, final int selectedColor, final int unSelectedColor)
    {
        for (int i = 0; i < ids.length; i++)
            tabLayout.getTabAt(i).setIcon(ids[i]);
        tabLayout.getTabAt(selectedTab).select();
        for (int i = 0; i < ids.length; i++)
        {
            if (i == selectedTab)
            {
                try
                {
                    int tabIconColor = ContextCompat.getColor(context, selectedColor);
                    tabLayout.getTabAt(i).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }
                catch (Exception e)
                {
                    tabLayout.getTabAt(i).getIcon().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
                }
            }
            else
            {
                try
                {
                    int tabIconColor = ContextCompat.getColor(context, unSelectedColor);
                    tabLayout.getTabAt(i).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }
                catch (Exception e)
                {
                    tabLayout.getTabAt(i).getIcon().setColorFilter(unSelectedColor, PorterDuff.Mode.SRC_IN);
                }
            }
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                TabLayoutUtil.setTabColor(context, tab, selectedColor);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {
                TabLayoutUtil.setTabColor(context, tab, unSelectedColor);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }

    public static void setTabColor(Context context,TabLayout.Tab tab,int color)
    {
        try
        {
            int tabIconColor = ContextCompat.getColor(context, color);
            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        }
        catch (Exception e)
        {
            tab.getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }


    public static class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        private boolean isTitle;

        public ViewPagerAdapter(FragmentManager manager)
        {
            super(manager);
            this.isTitle = true;
        }

        public boolean isTitle()
        {
            return isTitle;
        }

        public void setTitle(boolean title)
        {
            isTitle = title;
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public void addFragment(Fragment fragment, int shamsi_to_gregorian)
        {
            mFragmentList.add(fragment);
            this.isTitle = false;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            if (this.isTitle)
                return mFragmentTitleList.get(position);
            else
                return null;
        }
    }
}