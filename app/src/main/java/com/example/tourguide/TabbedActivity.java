package com.example.tourguide;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabbedActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ImageButton sideDrawerButton;
    ImageButton settingsButton;
    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    private String[] titles = new String[]{"places", "hotels", "restaurants", "historical places"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        tabLayout = findViewById(R.id.main_tab_layout);
        viewPager = findViewById(R.id.view_pager);
        sideDrawerButton = findViewById(R.id.side_drawer);
        settingsButton = findViewById(R.id.settings);

        sideDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_note), Toast.LENGTH_SHORT).show();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_note), Toast.LENGTH_SHORT).show();
            }
        });
        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);
        viewPager.setAdapter(viewPagerFragmentAdapter);
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setText(titles[position]))).attach();
    }
}