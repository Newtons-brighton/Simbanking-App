package com.example.simbanking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.services.ServiceAdapter;
import com.example.simbanking.services.ServiceModel;

import java.util.ArrayList;


public class FragmentServices extends Fragment {

    private RecyclerView recyclerView;
    private ServiceAdapter adapter;
    ArrayList<ServiceModel> list;

    public FragmentServices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);


        list = new ArrayList<>();
        list.add(new ServiceModel
                (ServiceModel.LAYOUT_ONE,"TOP CATEGORIES",
                        "SEE ALL","Luku","Airtime","TV",
                        "Government","Education",
                        "Airline","Water Bills","QR","Insurance",
                        "Hospitals","Stocks and",
                        "Rates","Tickets","Investments","Games",
                        "Tembo Points","Football"));
        list.add(new ServiceModel
                (ServiceModel.LAYOUT_TWO, "FOR YOU","MORE SERVICE","More","Payments"));

        list.add(new ServiceModel
                (ServiceModel.LAYOUT_THREE, "Favorites and Recents",
                        "Reccuring Payments"));

        //TODO set Adapter....
        adapter = new ServiceAdapter(list, requireContext()); // Use requireContext()
        // to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}