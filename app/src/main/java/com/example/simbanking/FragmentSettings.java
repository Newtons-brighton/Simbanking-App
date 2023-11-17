package com.example.simbanking;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.Settings.SettingModel;
import com.example.simbanking.Settings.settingsAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class FragmentSettings extends Fragment {

    private RecyclerView recyclerView;
    private settingsAdapter adapter;
    ArrayList<SettingModel> list;

    private Button unregister_button;

    BottomSheetDialog unregisterDeviceDialog;

    private settingsAdapter.RecyclerViewClickListener listener;

    private settingsAdapter.UnregisterButtonClickListener unregisterListener;

    public FragmentSettings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        unregisterDeviceDialog = new BottomSheetDialog(requireContext());
        unregister_button = view.findViewById(R.id.unregister_button);

        unregisterListener = new settingsAdapter.UnregisterButtonClickListener() {

            @Override
            public void onUnregisterButtonClick(int position) {

                View bottomSheetView = getLayoutInflater().inflate(R.layout.unregisterdevice_bottomdialog, null);

                // Set up the content and behavior of the dialog (e.g., add buttons or text)

                // Show the Bottom Sheet dialog
                unregisterDeviceDialog.setContentView(bottomSheetView);
                // Handle the unregister_button click here
                unregisterDeviceDialog.show(); // Show the dialog


                Button cancel = bottomSheetView.findViewById(R.id.cancel); // Replace with your close button ID
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        unregisterDeviceDialog.dismiss(); // Dismiss the dialog
                    }
                });
            }
        };



        list = new ArrayList<>();
        list.add(new SettingModel
                (SettingModel.LAYOUT_ONE,"MANDATES",
                        "E-mandate"));
        list.add(new SettingModel
                (SettingModel.LAYOUT_FIVE,"PROFILE"));

        list.add(new SettingModel
                (SettingModel.LAYOUT_TWO,"Link account","set default button",
                        "Bio Update","Favorite service"));

        list.add(new SettingModel
                (SettingModel.LAYOUT_THREE,"SECURITY",
                        "Change Pin","Receipt validator"));
        list.add(new SettingModel
                (SettingModel.LAYOUT_FOUR,"Application",
                        "Switch to Swahili","Enable biometric login",
                        "Choose Theme","Unregister device"
                ));



        //TODO set Adapter....
        adapter = new settingsAdapter(list,requireContext(),listener,unregisterListener); // Use requireContext()
        // to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


}


