package com.example.simbanking.AccountStatement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.simbanking.Accounts.FragmentAccounts;
import com.example.simbanking.Cards.FragmentCards;
import com.example.simbanking.DashboardActivity;
import com.example.simbanking.FragmentHistory;
import com.example.simbanking.FragmentMini;
import com.example.simbanking.Loans.FragmentLoans;
import com.example.simbanking.R;
import com.example.simbanking.TabFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class AccountsStatement extends AppCompatActivity {

    TabLayout mTabs;
    View mIndicator;
    private SharedPreferences sharedPreferences;
    private int indicatorWidth;

    private int selectedTabNumber=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewPager mViewPager;
        TabLayout mTabs;

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_accounts_statement);


        mTabs = findViewById(R.id.tab);
        mIndicator = findViewById(R.id.indicator);
        mViewPager = findViewById(R.id.viewpager);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        // Set up the view pager and fragments
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(FragmentMini.newInstance(), "MINI");
        adapter.addFragment(FragmentHistory.newInstance(), "HISTORY");
        adapter.addFragment(FragmentLoans.newInstance(), "FULL");
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
                // Start the DashboardActivity when the back arrow is clicked
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Handle the phone's back button press
    @Override
    public void onBackPressed() {
        // Start the DashboardActivity when the phone's back button is pressed
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }


}

