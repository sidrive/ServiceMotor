package com.motor.service.servicemotor.ui.historyservicefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.motor.service.servicemotor.data.model.Motor;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new PaketServiceFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Test","testcoba");
            fragment.setArguments(bundle);
        }
        else if (position == 1)
        {
            fragment = new GantiOliFragment();
        }
        else if (position == 2)
        {
            fragment = new AnotherServiceFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Paket Service";
        }
        else if (position == 1)
        {
            title = "Ganti Oli";
        }
        else if (position == 2)
        {
            title = "Service Biasa";
        }

        return title;
    }
}
