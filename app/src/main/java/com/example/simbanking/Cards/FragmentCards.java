package com.example.simbanking.Cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.FreezeCard;
import com.example.simbanking.R;
import com.example.simbanking.RequestCard;
import com.example.simbanking.RequestStatus;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class FragmentCards extends Fragment {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    ArrayList<CardsModelClass> list;
    private Button button4;
    private Button button;
    private Button button3;
    private Button button2;
    BottomSheetDialog manageOnlineDialog;

    public static Fragment newInstance() {
        return new FragmentCards();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cards, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize RecyclerView and data list
        recyclerView = view.findViewById(R.id.recyclerView);
        button4 = view.findViewById(R.id.button4);
        button = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);


        list = new ArrayList<>();

        list.add(new CardsModelClass(R.drawable.wifi, R.drawable.crdbbbb, R.drawable.chip,
                R.drawable.elephant, R.drawable.visa, "TemboCARD", "Classic Debit"));
        list.add(new CardsModelClass(R.drawable.wifi, R.drawable.crdbbbb, R.drawable.chip,
                R.drawable.elephant, R.drawable.visa, "TemboCARD", "Classic Debit"));

        // Set up the RecyclerView Adapter
        adapter = new CardAdapter(list, requireContext()); // Use requireContext() to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FreezeCard.class);
                v.getContext().startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RequestCard.class);
                v.getContext().startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RequestStatus.class);
                v.getContext().startActivity(intent);
            }
        });

        // Create and set the click listener for button4 to show the dialog
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });
    }

    // Method to show the BottomSheetDialog
    private void showBottomSheetDialog() {
        if (getContext() != null) {
            manageOnlineDialog = new BottomSheetDialog(getContext());
            View bottomSheetView = getLayoutInflater().inflate(R.layout.manage_online_bottomsheetdialog, null);
            manageOnlineDialog.setContentView(bottomSheetView);

            // Set a click listener for the submit button inside the dialog
            Button submitButton = bottomSheetView.findViewById(R.id.submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    manageOnlineDialog.dismiss(); // Dismiss the dialog
                }
            });

            // Show the dialog
            manageOnlineDialog.show();
        }
    }
}
