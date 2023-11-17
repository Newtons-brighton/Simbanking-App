package com.example.simbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MobileNetwork extends AppCompatActivity {

    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewPager mViewPager;
        TabLayout mTabs;

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.cardless);

    }

    // Handle the back button click event@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Start the DashboardActivity when the back arrow is clicked
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Handle the phone's back button press
    @Override
    public void onBackPressed() {
        // Use the FragmentManager to handle fragment navigation
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Check if there are fragments in the back stack
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // Pop the back stack to return to the previous fragment
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed(); // If there are no fragments in the back stack,
            // behave like the regular back button
        }
    }
}
