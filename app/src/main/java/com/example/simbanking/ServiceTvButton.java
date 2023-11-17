package com.example.simbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simbanking.services.ServiceAdapter;

public class ServiceTvButton extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.servicetvbutton);
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
