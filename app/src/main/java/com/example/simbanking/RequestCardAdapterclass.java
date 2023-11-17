package com.example.simbanking;

import static com.example.simbanking.Settings.SettingModel.LAYOUT_FIVE;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_FOUR;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_ONE;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_THREE;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_TWO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.Settings.settingsAdapter;

import java.util.List;

public class RequestCardAdapterclass extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<RequestcardModalclass> list;
    Context context;

    public RequestCardAdapterclass(List<RequestcardModalclass> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getViewType()) {

            case 1:
                return LAYOUT_ONE;
            case 2:
                return LAYOUT_TWO;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case LAYOUT_ONE:
                View layoutOne = LayoutInflater.from(context).inflate(R.layout.requestcard,
                        parent, false);
                return new RequestCardAdapterclass.RequestCardViewHolder(layoutOne);
            case LAYOUT_TWO:
                View layoutTwo = LayoutInflater.from(context).inflate(R.layout.requestcard2,
                        parent, false);
                return new RequestCardAdapterclass.RequestCard2ViewHolder(layoutTwo);
            default:
                return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType()) {
            case LAYOUT_ONE:
                String select = list.get(position).getSelect();
                String visa_tzs_button = list.get(position).getVisa_tzs_button();
                String tap1 = list.get(position).getTap1();
                String visa_Gold_button = list.get(position).getVisa_Gold_button();
                String tap2 = list.get(position).getTap2();
                String visa_Platinum_button = list.get(position).getVisa_Platinum_button();
                String tap3 = list.get(position).getTap3();
                String visa_infinite_button = list.get(position).getVisa_infinite_button();
                String tap4 = list.get(position).getTap4();
                String union_pay_button = list.get(position).getUnion_pay_button();
                String tap5 = list.get(position).getTap5();
                ((RequestCardAdapterclass.RequestCardViewHolder) holder).setRequestCardData(
                        select,
                        visa_tzs_button,
                        tap1,
                        visa_Gold_button,
                        tap2,
                        visa_Platinum_button,
                        tap3,
                        visa_infinite_button,
                        tap4,
                        union_pay_button,
                        tap5
                       );
                break;

            case LAYOUT_TWO:
                String simba_fan_button = list.get(position).getSimba_fan_button();
                String simba_platinum_button = list.get(position).getSimba_platinum_button();
                String yanga_visa_button = list.get(position).getYanga_visa_button();
                String tap12 = list.get(position).getTap12();
                String tap22 = list.get(position).getTap22();
                String tap32 = list.get(position).getTap32();
                String tap42 = list.get(position).getTap42();
                String tap52 = list.get(position).getTap52();
                String tap62 = list.get(position).getTap62();
                String tap72 = list.get(position).getTap72();
                String tap82 = list.get(position).getTap82();
                String simba_club_button = list.get(position).getSimba_club_button();
                String albarakah_visa_button = list.get(position).getAlbarakah_visa_button();
                String albarakah_gold_button = list.get(position).getAlbarakah_gold_button();
                String albarakah_platinum_button = list.get(position).getAlbarakah_platinum_button();
                String albarakah_infinite_button = list.get(position).getAlbarakah_infinite_button();
                ((RequestCardAdapterclass.RequestCard2ViewHolder) holder).setRequestCard2Data(
                        simba_fan_button,
                        tap12,
                        simba_platinum_button,
                        tap22,
                        yanga_visa_button,
                        tap32,
                        simba_club_button,
                        tap42,
                        albarakah_visa_button,
                        tap52,
                        albarakah_gold_button,
                        tap62,
                        albarakah_platinum_button,
                        tap72,
                        albarakah_infinite_button,
                        tap82
                );
                break;


        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class RequestCardViewHolder extends RecyclerView.ViewHolder {

        private TextView pleaseselect;
        private TextView visa_Tz,tap1, visa_Gold,tap2, visa_Platinum,tap3,
                visa_infinite,tap4,union_pay,tap5;


        public RequestCardViewHolder(@NonNull View itemView) {
            super(itemView);

            pleaseselect = itemView.findViewById(R.id.pleaseselect);
            visa_Tz = itemView.findViewById(R.id.visa_Tz);
            tap1 = itemView.findViewById(R.id.tap1);
            visa_Gold = itemView.findViewById(R.id.visa_Gold);
            tap2 = itemView.findViewById(R.id.tap2);
            visa_Platinum = itemView.findViewById(R.id.visa_platinum);
            tap3 = itemView.findViewById(R.id.tap3);
            visa_infinite = itemView.findViewById(R.id.visa_infinite);
            tap4 = itemView.findViewById(R.id.tap4);
            union_pay = itemView.findViewById(R.id.union_pay);
            tap5 = itemView.findViewById(R.id.tap5);

        }

        void setRequestCardData(String pleaseselect,
                              String visa_Tz,
                              String tap1,
                              String visa_Gold,
                              String tap2,
                              String visa_Platinum,
                              String tap3,
                              String visa_infinite,
                              String tap4,
                              String union_pay,
                              String tap5
                                ) {

            this.pleaseselect.setText(pleaseselect);
            this.visa_Tz.setText(visa_Tz);
            this.tap1.setText(tap1);
            this.visa_Gold.setText(visa_Gold);
            this.tap2.setText(tap2);
            this.visa_Platinum.setText(visa_Platinum);
            this.tap3.setText(tap3);
            this.visa_infinite.setText(visa_infinite);
            this.tap4.setText(tap4);
            this.union_pay.setText(union_pay);
            this.tap5.setText(tap5);
        }

    }

    class RequestCard2ViewHolder extends RecyclerView.ViewHolder {

        private TextView simba_fan;
        private TextView tap12,simba_platinum, tap22,yanga_visa, tap32,simba_club,
                tap42,al_barakah_visa,tap52,
                al_barakah_gold,tap62,al_barakah_platinum,tap72,
                al_barakah_infinite,tap82;


        public RequestCard2ViewHolder(@NonNull View itemView) {
            super(itemView);

            simba_fan = itemView.findViewById(R.id.simba_fan);
            tap12 = itemView.findViewById(R.id.tap12);
            simba_platinum = itemView.findViewById(R.id.simba_platinum);
            tap22 = itemView.findViewById(R.id.tap22);
            yanga_visa = itemView.findViewById(R.id.yanga_visa);
            tap32 = itemView.findViewById(R.id.tap32);
            simba_club = itemView.findViewById(R.id.simba_club);
            tap42 = itemView.findViewById(R.id.tap42);
            al_barakah_visa = itemView.findViewById(R.id.al_barakah_visa);
            tap52 = itemView.findViewById(R.id.tap52);
            al_barakah_gold = itemView.findViewById(R.id.al_barakah_gold);
            tap62 = itemView.findViewById(R.id.tap62);
            al_barakah_platinum = itemView.findViewById(R.id.al_barakah_platinum);
            tap72 = itemView.findViewById(R.id.tap72);
            al_barakah_infinite = itemView.findViewById(R.id.al_barakah_infinite);
            tap82 = itemView.findViewById(R.id.tap82);
        }

        void setRequestCard2Data(
                              String simba_fan,
                              String tap12,
                              String simba_platinum,
                              String tap22,
                              String yanga_visa,
                              String tap32,
                              String simba_club,
                              String tap42,
                              String al_barakah_visa,
                              String tap52,
                                String al_barakah_gold,
                              String tap62,
                              String al_barakah_platinum,
                              String tap72,
                              String al_barakah_infinite,
                              String tap82
                                ) {

            this.simba_fan.setText(simba_fan);
            this.tap12.setText(tap12);
            this.simba_platinum.setText(simba_platinum);
            this.tap22.setText(tap22);
            this.yanga_visa.setText(yanga_visa);
            this.tap32.setText(tap32);
            this.simba_club.setText(simba_club);
            this.tap42.setText(tap42);
            this.al_barakah_visa.setText(al_barakah_visa);
            this.tap52.setText(tap52);
            this.al_barakah_gold.setText(al_barakah_gold);
            this.tap62.setText(tap62);
            this.al_barakah_platinum.setText(al_barakah_platinum);
            this.tap72.setText(tap72);
            this.al_barakah_infinite.setText(al_barakah_infinite);
            this.tap82.setText(tap82);
        }

    }
}
