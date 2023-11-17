package com.example.simbanking.Loans;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.simbanking.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;

public class FragmentLoans extends Fragment{

    private RecyclerView recyclerView;
    private LoansAdapter adapter;

    ArrayList<LoansModelClass> list;

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;

    private LoansAdapter.RecyclerViewClickListener listener;
    private LoansAdapter.buttonClickListener termsListener;

    BottomSheetDialog ApplyLoanDialog;


    public FragmentLoans() {
        // Required empty public constructor
    }
    public static Fragment newInstance() {
        return new FragmentLoans();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loans, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize RecyclerView and data list
        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        ApplyLoanDialog = new BottomSheetDialog(requireContext());
        button = view.findViewById(R.id.button);


        termsListener = new LoansAdapter.buttonClickListener() {
            @Override
            public void onbuttonClick(int position) {


                View bottomSheetView =
                        getLayoutInflater().inflate(R.layout.terms_of_service_loansbutton_bottomsheetdialog,
                                null);

                // Set up the content and behavior of the dialog (e.g., add buttons or text)

                // Show the Bottom Sheet dialog
                ApplyLoanDialog.setContentView(bottomSheetView);
                // Handle the unregister_button click here
                ApplyLoanDialog.show(); // Show the dialog


                Button submit = bottomSheetView.findViewById(R.id.submit); // Replace with your close button ID
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ApplyLoanDialog.dismiss(); // Dismiss the dialog
                    }
                });

            }

        };



        list = new ArrayList<>();

        list.add(new LoansModelClass
                (LoansModelClass.LAYOUT_ONE, "Enjoy digital loans experience visit our",
                        "branches for more information"));
        list.add(new LoansModelClass
                (LoansModelClass.LAYOUT_TWO, "Apply","Loan","Repay","Loan",
                        "Summary","Terms of","Service",
                        "","","",""));
        list.add(new LoansModelClass
                (LoansModelClass.LAYOUT_THREE, "Salary Advance", "get up to 3 million",
                        "5% interest", "Pay in 30 days"));


        // Set up the RecyclerView Adapter
        adapter = new LoansAdapter(list, requireContext(),listener,termsListener);// Use requireContext() to get the fragment's context
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
