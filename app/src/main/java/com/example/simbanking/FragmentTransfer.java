package com.example.simbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class FragmentTransfer extends Fragment {

    public FragmentTransfer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transfer, container, false);

        // Find the button with id "button4"
        Button button4 = rootView.findViewById(R.id.button4);
        Button button3 = rootView.findViewById(R.id.button3);
        Button button2 = rootView.findViewById(R.id.button2);
        Button button = rootView.findViewById(R.id.button);

        // Set an OnClickListener for the button
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Intent to start a new activity (replace MyActivity.class with your desired activity)
                Intent intent = new Intent(getActivity(), cardless.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Intent to start a new activity (replace MyActivity.class with your desired activity)
                Intent intent = new Intent(getActivity(), cardless.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new intent to navigate to the desired activity
                Intent intent = new Intent(getActivity(), cardless.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new intent to navigate to the desired activity
                Intent intent = new Intent(getActivity(), cardless.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
