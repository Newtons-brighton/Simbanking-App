package com.example.simbanking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    public DashboardActivity() {
        // This is the zero-argument constructor.
    }


    private BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);

        btnNav = findViewById(R.id.btnNav);

        btnNav
                .setOnNavigationItemSelectedListener(this);
        btnNav.setSelectedItemId(R.id.overview);


    }



    @Override
    public void onBackPressed() {
        // Check if the current fragment is not the Overview fragment
        if (btnNav.getSelectedItemId() != R.id.overview) {
            // Navigate back to the Overview fragment
            btnNav.setSelectedItemId(R.id.overview);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, Fragment1)
                    .commit();
        } else {
            // If already on the Overview fragment, handle back press normally (exit the app)
            super.onBackPressed();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    // Add a method to load fragments
    FragmentOverview Fragment1 = new FragmentOverview();
    FragmentTransfer Fragment2 = new FragmentTransfer();
    FragmentCashOut Fragment3 = new FragmentCashOut();
    FragmentServices Fragment4 = new FragmentServices();

    FragmentSettings Fragment5 = new FragmentSettings();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.overview:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, Fragment1)
                        .commit();
                return true;

            case R.id.transfer:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, Fragment2)
                        .commit();
                return true;

            case R.id.settings:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, Fragment5)
                        .commit();
                return true;

            case R.id.cashout:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, Fragment3)
                        .commit();
                return true;

            case R.id.services:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, Fragment4)
                        .commit();
                return true;
        }
        return false;
    }

}






