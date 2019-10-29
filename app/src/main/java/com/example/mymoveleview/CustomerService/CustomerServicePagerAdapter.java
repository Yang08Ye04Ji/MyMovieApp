package com.example.mymoveleview.CustomerService;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CustomerServicePagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public CustomerServicePagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                CustomerServiceFragment_1 customerServiceFragment1 = new CustomerServiceFragment_1();
                return customerServiceFragment1;
            case 1:
                CustomerServiceFragment_2 customerServiceFragment2 = new CustomerServiceFragment_2();
                return customerServiceFragment2;
            case 2:
                CustomerServiceFragment_3 customerServiceFragment3 = new CustomerServiceFragment_3();
                return customerServiceFragment3;
            case 3:
                CustomerServiceFragment_4 customerServiceFragment4 = new CustomerServiceFragment_4();
                return customerServiceFragment4;

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
