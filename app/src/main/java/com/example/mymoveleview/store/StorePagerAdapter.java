package com.example.mymoveleview.store;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class StorePagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public StorePagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                PopCornFragment popCornFragment = new PopCornFragment();
                return popCornFragment;
            case 1:
                DrinkFragment drinkFragment = new DrinkFragment();
                return drinkFragment;
            case 2:
                SnackFragment snackFragment = new SnackFragment();
                return snackFragment;

            case 3:
                ComboFragment comboFragment = new ComboFragment();
                return comboFragment;

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
