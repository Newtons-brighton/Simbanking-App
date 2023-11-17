package com.example.simbanking.Accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.R;
import com.example.simbanking.RecyclerViewClickListener;
import com.example.simbanking.Settings.settingsAdapter;

import java.util.ArrayList;

public class FragmentAccounts extends Fragment {
    private RecyclerView recyclerView;
    private AccountsAdapter adapter;
    ArrayList<AccountsModelClass> list;



    public FragmentAccounts() {
        // Required empty public constructor
    }
    public static Fragment newInstance() {
        return new FragmentAccounts();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);
        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Initialize RecyclerView and data list
        recyclerView = view.findViewById(R.id.recyclerView);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);


        list = new ArrayList<>();

        list.add(new AccountsModelClass
                (AccountsModelClass.LAYOUT_ONE, "SAVINGS ACCOUNT",
                        "0152446304300", "Actual Balance",
                        "TZS 15,823.23", "Available Balance", "TZS 12,823.23"));
        list.add(new AccountsModelClass
                (AccountsModelClass.LAYOUT_TWO, "Statement", "Government", "Airtime", "Luku"));
        list.add(new AccountsModelClass
                (AccountsModelClass.LAYOUT_THREE, "CRDB Lipa Hapa", "Pay our merchants directly and quickly"));

        // Set up the RecyclerView Adapter
        adapter = new AccountsAdapter(list, requireContext()); // Use requireContext() to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
