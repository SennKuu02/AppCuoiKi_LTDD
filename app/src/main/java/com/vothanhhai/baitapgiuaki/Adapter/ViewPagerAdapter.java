package com.vothanhhai.baitapgiuaki.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.vothanhhai.baitapgiuaki.Fragment.HomeFragment;
import com.vothanhhai.baitapgiuaki.Fragment.ProfileFragment;
import com.vothanhhai.baitapgiuaki.Fragment.SettingFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SettingFragment();
            case 2:
                return new ProfileFragment();
            default:
                return new HomeFragment();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
