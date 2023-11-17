package com.example.simbanking.Accounts;
import static com.example.simbanking.Accounts.AccountsModelClass.LAYOUT_ONE;
import static com.example.simbanking.Accounts.AccountsModelClass.LAYOUT_THREE;
import static com.example.simbanking.Accounts.AccountsModelClass.LAYOUT_TWO;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.simbanking.AccountStatement.AccountsStatement;
import com.example.simbanking.AccountsGovernment;
import com.example.simbanking.CircularViewActivity;
import com.example.simbanking.R;

import java.util.ArrayList;
import java.util.List;

public class AccountsAdapter extends RecyclerView.Adapter{

    List<AccountsModelClass>list;
    Context context;


    public AccountsAdapter(ArrayList<AccountsModelClass> list,
                           Context context
                           ) {
        this.list = list;
        this.context = context;
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
                View layoutOne =LayoutInflater.from(context).inflate(R.layout.accountscircular_cardview,parent,false);
                    return new CircularcardViewHolder(layoutOne);
            case LAYOUT_TWO:
                View layoutTwo =LayoutInflater.from(context).inflate(R.layout.accountbuttons_cardview,parent,false);
                return new ButtoncardViewHolder(layoutTwo);
            case LAYOUT_THREE:
                View layoutThree =LayoutInflater.from(context).inflate(R.layout.accountscrdb_cardview,parent,false);
                return new CrdbcardViewHolder(layoutThree);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType()){
            case  LAYOUT_ONE:
            String accNo = list.get(position).getAccNo();
            String actual_text = list.get(position).getActual_text();
            String actual_balance = list.get(position).getActual_balance();
            String available_text = list.get(position).getAvailable_text();
            String saving_text = list.get(position).getSaving_text();
            String availableNo = list.get(position).getAvailableNo();



                ((CircularcardViewHolder) holder).setCircularData(saving_text,accNo,actual_text,
                        actual_balance,available_text,availableNo);
                  break;

            case  LAYOUT_TWO:
                String text1 =list.get(position).getText1();
                String text2 = list.get(position).getText2();
                String text3 = list.get(position).getText3();
                String text4 = list.get(position).getText4();
                ((ButtoncardViewHolder) holder).setButtonData(text1,text2,text3,text4);
                break;

            case  LAYOUT_THREE:
                String lipa =list.get(position).getLipa();
                String pay =list.get(position).getPay();
                ((CrdbcardViewHolder) holder).setCrdbData(lipa,pay);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class CircularcardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView saving_text;
        private TextView accNo;
        private TextView actual_text;
        private TextView actual_balance;
        private TextView available_balance;
        private TextView availableNo;
        private TextView available_text;

        private Button hide;
        private boolean isHidden = false;

        public CircularcardViewHolder(@NonNull View itemView) {
            super(itemView);
            saving_text = itemView.findViewById(R.id.saving_text);
            accNo = itemView.findViewById(R.id.accNo);
            actual_text = itemView.findViewById(R.id.actual_text);
            actual_balance = itemView.findViewById(R.id.actual_balance);
            availableNo = itemView.findViewById(R.id.availableNo);
            available_text = itemView.findViewById(R.id.available_text);

            // Set a click listener on the entire itemView
            itemView.setOnClickListener(this);


            hide = itemView.findViewById(R.id.hide);

            hide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle visibility of the TextViews
                    if (isHidden) {
                        availableNo.setVisibility(View.VISIBLE);
                        actual_balance.setVisibility(View.VISIBLE);
                    } else {
                        availableNo.setVisibility(View.INVISIBLE);
                        actual_balance.setVisibility(View.INVISIBLE);
                    }

                    // Update the state
                    isHidden = !isHidden;
                }
            });

        }

        void setCircularData(String saving_text, String accNo, String actual_text,
                             String actual_balance, String available_text, String availableNo) {
            this.saving_text.setText(saving_text);
            this.accNo.setText(accNo);
            this.actual_text.setText(actual_text);
            this.actual_balance.setText(actual_balance);
            this.availableNo.setText(availableNo);
            this.available_text.setText(available_text);
        }

        @Override
        public void onClick(View view) {
            // Handle the item click here
            // Create an Intent to navigate to the desired activity
            Intent intent = new Intent(view.getContext(), CircularViewActivity.class);
            // Start the activity
            view.getContext().startActivity(intent);
        }
    }

    class ButtoncardViewHolder extends RecyclerView.ViewHolder{
        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView text4;

        private Button button;
        private Button button2;

        private Button button3;
        private Button button4;



        public ButtoncardViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            text4 = itemView.findViewById(R.id.text4);
            text4 = itemView.findViewById(R.id.text4);
            button = itemView.findViewById(R.id.button);
            button2 = itemView.findViewById(R.id.button2);
            button3 = itemView.findViewById(R.id.button3);
            button4 = itemView.findViewById(R.id.button4);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AccountsStatement.class);
                    v.getContext().startActivity(intent);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AccountsGovernment.class);
                    v.getContext().startActivity(intent);
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AccountsGovernment.class);
                    v.getContext().startActivity(intent);
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AccountsStatement.class);
                    v.getContext().startActivity(intent);
                }
            });

        }


        void setButtonData(String text1,String text2,String text3,String text4){

            this.text1.setText(text1);
            this.text2.setText(text2);
            this.text3.setText(text3);
            this.text4.setText(text4);
        }



    }
    class CrdbcardViewHolder extends RecyclerView.ViewHolder{
        private TextView lipa;
        private TextView pay;




        public CrdbcardViewHolder(@NonNull View itemView) {
            super(itemView);

            lipa = itemView.findViewById(R.id.lipa);
            pay = itemView.findViewById(R.id.pay);
        }


        void setCrdbData(String lipa, String pay){
            this.lipa.setText(lipa);
            this.pay.setText(pay);

        }

    }



}
