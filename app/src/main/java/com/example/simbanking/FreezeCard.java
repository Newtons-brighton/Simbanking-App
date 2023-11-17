package com.example.simbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class FreezeCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_freezecard);
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
