package com.example.simbanking.Agent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.R;

import java.util.ArrayList;
public class FragmentAgent extends Fragment {
    private RecyclerView recyclerView;
    private AgentAdapter adapter;

    private Spinner spinner;

    String[] spinnerData = {"01525353637"};


    ArrayList<AgentModalClass> list;

    public static Fragment newInstance() {
        return new FragmentAgent();
    }


    public FragmentAgent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_agent, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize RecyclerView and data list
        recyclerView = view.findViewById(R.id.recyclerView);
        list = new ArrayList<>();

        list.add(new AgentModalClass
                (AgentModalClass.LAYOUT_ONE, "Visit a CRDB agent or branch attendant to withdraw money " +
                        "with a card","withdraw from"));
        list.add(new AgentModalClass
                (AgentModalClass.LAYOUT_TWO, "Amount"));
        list.add(new AgentModalClass
                (AgentModalClass.LAYOUT_THREE,
                        "Transaction description(Optional)","Remove Description"
                        ,"PROCEED"));

        // Set up the RecyclerView Adapter
        adapter = new AgentAdapter(list, requireContext()); // Use requireContext() to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // Initialize the Spinner
        spinner = view.findViewById(R.id.spinner);

        // Create an ArrayAdapter for the Spinner with the data

    }
}
