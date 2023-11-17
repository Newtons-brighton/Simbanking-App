package com.example.simbanking;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class TermsOfService extends AppCompatActivity implements View.OnClickListener{


    Button button4;
    Button submit;

    BottomSheetDialog ManageOnlineDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.loansbutons_cardview);
        button4 = findViewById(R.id.button4);
        ManageOnlineDialog = new BottomSheetDialog(this);



        // Inflate view
        createManageOnlineDialog();

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManageOnlineDialog.show();
            }
        });

        ManageOnlineDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);



    }

    private void createManageOnlineDialog() {
        View view = getLayoutInflater().inflate(R.layout.manage_online_bottomsheetdialog,
                null, false);

        // Find the "submit" button using the "view" object
        submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManageOnlineDialog.dismiss();
            }
        });

        ManageOnlineDialog.setContentView(view);
    }

    @Override
    public void onClick(View v) {
        // Handle other click events if needed
    }
}
