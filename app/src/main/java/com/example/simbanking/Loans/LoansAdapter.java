package com.example.simbanking.Loans;

import static com.example.simbanking.Loans.LoansModelClass.LAYOUT_ONE;
import static com.example.simbanking.Loans.LoansModelClass.LAYOUT_THREE;
import static com.example.simbanking.Loans.LoansModelClass.LAYOUT_TWO;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.MandatesActivity;
import com.example.simbanking.R;

import java.util.ArrayList;
import java.util.List;
public class LoansAdapter extends RecyclerView.Adapter{
    List<LoansModelClass>list;

    Context context;

    private LoansAdapter.RecyclerViewClickListener listener;

    private LoansAdapter.buttonClickListener ApplyListener;
    private LoansAdapter.buttonClickListener RepayListener;
    private LoansAdapter.buttonClickListener SummaryListener;
    private LoansAdapter.buttonClickListener termsListener;


    public interface buttonClickListener {
        void onbuttonClick(int position);
    }

    public LoansAdapter(ArrayList<LoansModelClass> list, Context context,
                        LoansAdapter.RecyclerViewClickListener listener,
                        LoansAdapter.buttonClickListener termsListener
                        ) {
        this.list = list;
        this.context = context;
        this.termsListener = termsListener;
        this.listener = listener;
    }


    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getViewType()){
            case 1:
                return LAYOUT_ONE;
            case 2:
                return LAYOUT_TWO;
            case 3:
                return LAYOUT_THREE;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case LAYOUT_ONE:
                View layoutOne =LayoutInflater.from(context).inflate(R.layout.loanscircular_cardview,parent,false);
                return new CircularcardViewHolder(layoutOne);
            case LAYOUT_TWO:
                View layoutTwo =LayoutInflater.from(context).inflate(R.layout.loansbutons_cardview,parent,false);
                return new ButtoncardViewHolder(layoutTwo);
            case LAYOUT_THREE:
                View layoutThree =LayoutInflater.from(context).inflate(R.layout.loanscrdb_cardview,parent,false);
                return new CrdbcardViewHolder(layoutThree);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType()){
            case  LAYOUT_ONE:
                String enjoy = list.get(position).getEnjoy();
                String branches = list.get(position).getBranches();
                
                ((CircularcardViewHolder) holder).setCircularData(enjoy,branches);
                break;

            case  LAYOUT_TWO:
                String Apply =list.get(position).getApply();
                String Loans = list.get(position).getLoans();
                String Repay = list.get(position).getRepay();
                String Loan = list.get(position).getLoan();
                String Summary = list.get(position).getSummary();
                String Terms = list.get(position).getTerms();
                String Service = list.get(position).getService();
                ((ButtoncardViewHolder) holder).setButtonData(Apply,Loans,Repay,Loan,Summary,Terms,Service);
                break;

            case  LAYOUT_THREE:
                String Salary =list.get(position).getSalary();
                String Up =list.get(position).getUp();
                String Interest =list.get(position).getInterest();
                String In =list.get(position).getIn();
                ((CrdbcardViewHolder) holder).setCrdbData(Salary,Up,Interest,In);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CircularcardViewHolder extends RecyclerView.ViewHolder{

        private TextView enjoy;
        private TextView branches;

        public CircularcardViewHolder(@NonNull View itemView) {
            super(itemView);

            enjoy = itemView.findViewById(R.id.enjoy);
            branches = itemView.findViewById(R.id.branches);
        }

        void setCircularData(String enjoy, String branches){
            this.enjoy.setText(enjoy);
            this.branches.setText(branches);
        }
    }

    class ButtoncardViewHolder extends RecyclerView.ViewHolder{
        private TextView Apply;
        private TextView Loans;
        private TextView Repay;
        private TextView Loan;
        private TextView Summary;
        private TextView Service;
        private TextView Terms;

        private Button button;
        private Button button2;
        private Button button3;
        private Button button4;

        public ButtoncardViewHolder(@NonNull View itemView) {
            super(itemView);

            Apply = itemView.findViewById(R.id.Apply);
            Loans = itemView.findViewById(R.id.Loans);
            Repay = itemView.findViewById(R.id.Repay);
            Loan = itemView.findViewById(R.id.Loan);
            Summary = itemView.findViewById(R.id.Summary);
            Terms = itemView.findViewById(R.id.Terms);
            Service = itemView.findViewById(R.id.Service);

            button = itemView.findViewById(R.id.button);
            button2 = itemView.findViewById(R.id.button2);
            button3 = itemView.findViewById(R.id.button3);
            button4 = itemView.findViewById(R.id.button4);


            // Set click listeners for the buttons in Recyclerview
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for button2
                    int position = getAdapterPosition();
                    termsListener.onbuttonClick(position);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for button2
                    int position = getAdapterPosition();
                    termsListener.onbuttonClick(position);
                }
            });


            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for button2
                    int position = getAdapterPosition();
                    termsListener.onbuttonClick(position);
                }
            });


            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for button2
                    int position = getAdapterPosition();
                    termsListener.onbuttonClick(position);
                }
            });

        }

        void setButtonData(String Apply,String Loans,String Repay,String Loan,
                           String Summary,String Terms,String Service
                           ){

            this.Apply.setText(Apply);
            this.Loans.setText(Loans);
            this.Repay.setText(Repay);
            this.Loan.setText(Loan);
            this.Summary.setText(Summary);
            this.Terms.setText(Terms);
            this.Service.setText(Service);

        }
    }

    class CrdbcardViewHolder extends RecyclerView.ViewHolder{
        private TextView Salary;
        private TextView Up;
        private TextView Interest;
        private TextView In;

        public CrdbcardViewHolder(@NonNull View itemView) {
            super(itemView);

            Salary = itemView.findViewById(R.id.Salary);
            Up = itemView.findViewById(R.id.Up);
            Interest = itemView.findViewById(R.id.Interest);
            In = itemView.findViewById(R.id.In);
        }


        void setCrdbData(String Salary, String Up, String Interest, String In){
            this.Salary.setText(Salary);
            this.Up.setText(Up);
            this.Interest.setText(Interest);
            this.In.setText(In);
        }

    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);

    }

}
