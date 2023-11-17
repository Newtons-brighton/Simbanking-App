package com.example.simbanking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button scan;
    Button textbutton;
    BottomSheetDialog scanToPaydialog;
    BottomSheetDialog forgotPinDialog;

    private Button button;


    View digit1, digit2, digit3, digit4;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, btn_clear;
    ArrayList<String> number_list = new ArrayList<>();
    String passcode = "";
    String num_01, num_02, num_03, num_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        scan =  findViewById(R.id.scan);
        scanToPaydialog = new BottomSheetDialog(this);
        forgotPinDialog = new BottomSheetDialog(this);
        textbutton = findViewById(R.id.textbutton);


        //inflate view
        createscanToPayDialog();
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanToPaydialog.show();
            }
        });


        createForgotPinDialog();
        textbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPinDialog.show();
            }
        });


        scanToPaydialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        forgotPinDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);



        initializeComponents();

        button = findViewById(R.id.more);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoreServices();
            }
        });

    }

    private void createscanToPayDialog() {
        View view = getLayoutInflater().inflate(R.layout.bottom_dialog, null, false);
        Button submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanToPaydialog.dismiss();
            }

        });

        scanToPaydialog.setContentView(view);
    }

    private void createForgotPinDialog() {
        View view2 = getLayoutInflater().inflate(R.layout.forgotpin_bottom_dialog, null, false);
        Button reset = view2.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPinDialog.dismiss();
            }

        });

        forgotPinDialog.setContentView(view2);
    }


    private void initializeComponents() {
        digit1 = findViewById(R.id.digit1);
        digit2 = findViewById(R.id.digit2);
        digit3 = findViewById(R.id.digit3);
        digit4 = findViewById(R.id.digit4);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        btn_clear = findViewById(R.id.btn_clear);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }



    public void MoreServices() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                number_list.add("0");
                passNumber(number_list);
                break;
            case R.id.button1:
                number_list.add("1");
                passNumber(number_list);
                break;
            case R.id.button2:
                number_list.add("2");
                passNumber(number_list);
                break;
            case R.id.button3:
                number_list.add("3");
                passNumber(number_list);
                break;
            case R.id.button4:
                number_list.add("4");
                passNumber(number_list);
                break;
            case R.id.button5:
                number_list.add("5");
                passNumber(number_list);
                break;
            case R.id.button6:
                number_list.add("6");
                passNumber(number_list);
                break;
            case R.id.button7:
                number_list.add("7");
                passNumber(number_list);
                break;
            case R.id.button8:
                number_list.add("8");
                passNumber(number_list);
                break;
            case R.id.button9:
                number_list.add("9");
                passNumber(number_list);
                break;
            case R.id.btn_clear:
                if(!number_list.isEmpty()){
                    number_list.remove(number_list.size()-1);
                    passNumber(number_list);
                }
                break;
        }
    }
    private void passNumber(ArrayList<String> number_list) {
        int enteredDigits = number_list.size();

        // Clear all backgrounds first
        digit1.setBackgroundResource(R.drawable.bg_view_grey_oval);
        digit2.setBackgroundResource(R.drawable.bg_view_grey_oval);
        digit3.setBackgroundResource(R.drawable.bg_view_grey_oval);
        digit4.setBackgroundResource(R.drawable.bg_view_grey_oval);

        // Show/hide the delete button based on the number of entered digits
        if (enteredDigits > 0) {
            btn_clear.setVisibility(View.VISIBLE);
        } else {
            btn_clear.setVisibility(View.GONE);
        }

        // Set backgrounds based on the entered digits and update digitStatus
        for (int i = 0; i < enteredDigits; i++) {
            switch (i) {
                case 0:
                    num_01 = number_list.get(i);
                    digit1.setBackgroundResource(R.drawable.bg_view_blue_oval);
                    break;
                case 1:
                    num_02 = number_list.get(i);
                    digit2.setBackgroundResource(R.drawable.bg_view_blue_oval);
                    break;
                case 2:
                    num_03 = number_list.get(i);
                    digit3.setBackgroundResource(R.drawable.bg_view_blue_oval);
                    break;
                case 3:
                    num_04 = number_list.get(i);
                    digit4.setBackgroundResource(R.drawable.bg_view_blue_oval);
                    passcode = num_01 + num_02 + num_03 + num_04;
                    if (getPassCode().isEmpty()) {
                        savePassCode(passcode);
                    } else {
                        matchPassCode();
                    }
                    break;
            }
        }

        // Restore original backgrounds for empty digit views
        boolean[] digitStatus = new boolean[0];
        for (int i = enteredDigits; i < digitStatus.length; i++) {
            if (!digitStatus[i]) {
                switch (i) {
                    case 0:
                        digit1.setBackgroundResource(R.drawable.bg_view_grey_oval);
                        break;
                    case 1:
                        digit2.setBackgroundResource(R.drawable.bg_view_grey_oval);
                        break;
                    case 2:
                        digit3.setBackgroundResource(R.drawable.bg_view_grey_oval);
                        break;
                    case 3:
                        digit4.setBackgroundResource(R.drawable.bg_view_grey_oval);
                        break;
                }
            }
        }
    }
    private void matchPassCode() {
        String savedPasscode = getPassCode();
        if (savedPasscode.equals(passcode)) {
            startActivity(new Intent(this, DashboardActivity.class));
        } else {
            Toast.makeText(this, "Password doesn't match, please retry again", Toast.LENGTH_SHORT).show();
            // Clear entered numbers and reset backgrounds
            number_list.clear();
            passNumber(number_list);
        }
    }

    private void savePassCode(String passcode) {
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passcode", passcode);
        editor.apply();
    }
    private String getPassCode() {
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        return preferences.getString("passcode", "");
    }


}