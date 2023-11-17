package com.example.simbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.Accounts.AccountsAdapter;
import com.example.simbanking.Accounts.AccountsModelClass;
import com.example.simbanking.FreezeCard;
import com.example.simbanking.R;
import com.example.simbanking.RequestCard;
import com.example.simbanking.RequestStatus;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class FragmentHistory extends Fragment {

    public static Fragment newInstance() {
        return new FragmentHistory();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmenthistory, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}

