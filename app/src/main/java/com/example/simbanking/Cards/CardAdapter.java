package com.example.simbanking.Cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.R; // Replace with your actual package name

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.BankCardViewHolder> {
    private List<CardsModelClass> cardList;
    Context context;

    public CardAdapter(ArrayList<CardsModelClass> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @NonNull
    @Override
    public BankCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_card, parent, false);
        return new BankCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankCardViewHolder holder, int position) {
        CardsModelClass card = cardList.get(position);
        holder.wifiImageView.setImageResource(card.getWifi());
        holder.crdbLogoImageView.setImageResource(card.getCrdblogo());
        holder.chipImageView.setImageResource(card.getChip());
        holder.elephantImageView.setImageResource(card.getElephant());
        holder.visaImageView.setImageResource(card.getVisa());
        holder.temboTextView.setText(card.getTembo());
        holder.debitTextView.setText(card.getDebit());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class BankCardViewHolder extends RecyclerView.ViewHolder {
        ImageView wifiImageView, crdbLogoImageView, chipImageView, elephantImageView, visaImageView;
        TextView temboTextView, debitTextView;

        public BankCardViewHolder(@NonNull View itemView) {
            super(itemView);
            wifiImageView = itemView.findViewById(R.id.wifi); // Replace with your actual ImageView IDs
            crdbLogoImageView = itemView.findViewById(R.id.crdblogo);
            chipImageView = itemView.findViewById(R.id.chip);
            elephantImageView = itemView.findViewById(R.id.elephant);
            visaImageView = itemView.findViewById(R.id.visa);
            temboTextView = itemView.findViewById(R.id.tembo); // Replace with your actual TextView IDs
            debitTextView = itemView.findViewById(R.id.debit);
        }
    }
}
