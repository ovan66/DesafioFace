package com.desafiolatam.desafioface.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.desafiolatam.desafioface.views.main.favorits.FavoriteFragment;
import com.desafiolatam.desafioface.views.main.users.UsersFragment;

/**
 * Created by santo_000 on 24-11-2016.
 */

public class SectionsPagesAdapter extends FragmentPagerAdapter {

    public SectionsPagesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return UsersFragment.newInstance();
            case 1:
                return FavoriteFragment.newInstance();
            default:
                return UsersFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Usuarios";
            case 1:
                return "Favoritos";
            default:
                return "Usuarios";
        }
    }
}
