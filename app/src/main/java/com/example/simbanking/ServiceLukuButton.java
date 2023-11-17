package com.example.simbanking;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.simbanking.Agent.FragmentAgent;
import com.example.simbanking.Cards.FragmentCards;
import com.google.android.material.tabs.TabLayout;

public class ServiceLukuButton extends AppCompatActivity {
    TabLayout mTabs;
    View mIndicator;
    ViewPager mViewPager;
    private SharedPreferences sharedPreferences;

    private int indicatorWidth;

    private int selectedTabNumber = 1;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serivce_lukubutton);

        mTabs = findViewById(R.id.tab);
        mIndicator = findViewById(R.id.indicator);
        mViewPager = findViewById(R.id.viewpager);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // Set up the view pager and fragments
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(FragmentBuyLuku.newInstance(), "Buy LUKU");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter.addFragment(FragmentRetrieveToken.newInstance(), "Retrieve Token");
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager);

        // Determine indicator width at runtime
        mTabs.post(new Runnable() {
            @Override
            public void run() {
                indicatorWidth = mTabs.getWidth() / mTabs.getTabCount();

                // Assign new width
                FrameLayout.LayoutParams indicatorParams = (FrameLayout.LayoutParams) mIndicator.getLayoutParams();
                indicatorParams.width = indicatorWidth;
                mIndicator.setLayoutParams(indicatorParams);
            }
        });

        // Get the last selected tab position from SharedPreferences
        int lastSelectedTab = sharedPreferences.getInt("lastSelectedTab", 0);
        int lastIndicatorPosition = sharedPreferences.getInt("lastIndicatorPosition", 0);

        // Set the last selected tab as the current tab
        mViewPager.setCurrentItem(lastSelectedTab);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPx) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mIndicator.getLayoutParams();
                float translationOffset = (positionOffset + i) * indicatorWidth;
                params.leftMargin = (int) translationOffset;
                mIndicator.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int i) {
                // Save the selected tab position in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("lastSelectedTab", i);
                editor.apply();
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    // Handle the back button click event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish(); // Finish the current activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    // Handle the phone's back button press
    @Override
    public void onBackPressed() {
        finish(); // Finish the current activity
    }
}
