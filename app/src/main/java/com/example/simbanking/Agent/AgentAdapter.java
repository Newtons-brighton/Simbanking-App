package com.example.simbanking.Agent;
import static com.example.simbanking.Accounts.AccountsModelClass.LAYOUT_ONE;
import static com.example.simbanking.Accounts.AccountsModelClass.LAYOUT_THREE;
import static com.example.simbanking.Accounts.AccountsModelClass.LAYOUT_TWO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.R;

import java.util.ArrayList;
import java.util.List;

public class AgentAdapter extends RecyclerView.Adapter{

    List<AgentModalClass>list;
    Context context;
    public AgentAdapter(ArrayList<AgentModalClass> list, Context context) {
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
                View layoutOne = LayoutInflater.from(context).inflate(R.layout.agent1,parent,false);
                return new Agent1ViewHolder(layoutOne);
            case LAYOUT_TWO:
                View layoutTwo = LayoutInflater.from(context).inflate(R.layout.agent2,parent,false);
                return new Agent2ViewHolder(layoutTwo);
            case LAYOUT_THREE:
                View layoutThree = LayoutInflater.from(context).inflate(R.layout.agent3,parent,false);
                return new Agent3ViewHolder(layoutThree);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType()){
            case  LAYOUT_ONE:
                String visit = list.get(position).getVisit();
                String withdraw = list.get(position).getWithdraw();
                ((Agent1ViewHolder) holder).setAgent1Data(visit,withdraw);
                break;

            case  LAYOUT_TWO:
                String amount = list.get(position).getAmount();
                ((Agent2ViewHolder) holder).setAgent2Data(amount);
                break;

            case  LAYOUT_THREE:
                String transaction  =list.get(position).getTransaction();
                String description =list.get(position).getDescription();
                String proceed =list.get(position).getProceed();
                ((Agent3ViewHolder) holder).setAgent3Data(transaction,description,proceed);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class Agent1ViewHolder extends RecyclerView.ViewHolder{

        private TextView visit;
        private TextView withdraw;

        public Agent1ViewHolder(@NonNull View itemView) {
            super(itemView);
            visit = itemView.findViewById(R.id.visit);
            withdraw = itemView.findViewById(R.id.withdraw);
        }

        void setAgent1Data(String visit, String withdraw){
            this.visit.setText(visit);
            this.withdraw.setText(withdraw);
        }
    }

    class Agent2ViewHolder extends RecyclerView.ViewHolder{
        private TextView amount;

        public Agent2ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.amount);
        }


        void setAgent2Data(String amount){
            this.amount.setText(amount);
        }

    }

    class Agent3ViewHolder extends RecyclerView.ViewHolder{
        private TextView transaction;
        private TextView description;
        private Button proceed;

        public Agent3ViewHolder(@NonNull View itemView) {
            super(itemView);
            transaction = itemView.findViewById(R.id.transaction);
            description= itemView.findViewById(R.id.description);
            proceed = itemView.findViewById(R.id.proceed);

        }


        void setAgent3Data(String transaction,String description,String proceed){

            this.transaction.setText(transaction);
            this.description.setText(description);
            this.proceed.setText(proceed);
        }

    }





}
