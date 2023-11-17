package com.example.simbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.Settings.SettingModel;
import com.example.simbanking.Settings.settingsAdapter;

import java.util.ArrayList;

public class RequestCard extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestCardAdapterclass adapter;
    ArrayList<RequestcardModalclass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_requestcard);
        recyclerView = findViewById(R.id.recyclerView);


        list = new ArrayList<>();
        list.add(new RequestcardModalclass
                (RequestcardModalclass.LAYOUT_ONE,"Please select your card of choice",
                        "VISA TZS",
                        "Tap to see the features and apply for this card",
                        "VISA GOLD-TZS",
                        "Tap to see the features and apply for this card",
                        "VISA PLATINUM TZS",
                        "Tap to see the features and apply for this card",
                        "VISA INFINITE TZS",
                        "Tap to see the features and apply for this card",
                        "UNION PAY TZS",
                        "Tap to see the features and apply for this card"));
        list.add(new RequestcardModalclass
                (RequestcardModalclass.LAYOUT_TWO,"SIMBA FAN CLASSIC",
                        "Tap to see the features and apply for this card",
                        "SIMBA PLATINUM",
                        "Tap to see the features and apply for this card",
                        "YANGA VISA CARD",
                        "Tap to see the features and apply for this card",
                        "SIMBA CUB",
                        "Tap to see the features and apply for this card",
                        "AL BARAKAH VISA",
                        "Tap to see the features and apply for this card",
                        "AL BARAKAH GOLD","Tap to see the features and apply for this card",
                        "AL BARAKAH PLATINUM",
                        "Tap to see the features and apply for this card",
                        "AL BARAKAH INFINITE",
                        "Tap to see the features and apply for this card"));


        //TODO set Adapter....
        adapter = new RequestCardAdapterclass(list,this); // Use requireContext()
        // to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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
