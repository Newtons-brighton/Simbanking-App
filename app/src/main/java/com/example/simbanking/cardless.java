package com.example.simbanking;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.simbanking.R;

public class cardless extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.cardless);
    }

    // Handle the back button click event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate back to the previous fragment
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
