package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {
    private String[] titles = new String[]{"places", "hotels", "restaurants", "historical places"};

    public ViewPagerFragmentAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PlacesFragment();
            case 1:
                return new HotelsFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new HistoryFragment();
        }
        return new PlacesFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
