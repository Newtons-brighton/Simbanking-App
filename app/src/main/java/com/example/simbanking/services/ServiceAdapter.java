package com.example.simbanking.services;

import static com.example.simbanking.services.ServiceModel.LAYOUT_ONE;
import static com.example.simbanking.services.ServiceModel.LAYOUT_THREE;
import static com.example.simbanking.services.ServiceModel.LAYOUT_TWO;

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
import com.example.simbanking.ServiceAirtimeButton;
import com.example.simbanking.ServiceGovernmentButton;
import com.example.simbanking.ServiceLukuButton;
import com.example.simbanking.ServiceTvButton;
import com.example.simbanking.Settings.settingsAdapter;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter {
    List<ServiceModel> list;
    Context context;

    private settingsAdapter.RecyclerViewClickListener listener;

    public ServiceAdapter(List<ServiceModel> list, Context context) {
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
                View layoutOne = LayoutInflater.from(context).inflate(R.layout.service_1,parent,false);
                  return new Service1ViewHolder(layoutOne);

            case LAYOUT_TWO:
                View layoutTwo = LayoutInflater.from(context).inflate(R.layout.service_2,parent, false);
                    return new Service2ViewHolder(layoutTwo);

            case LAYOUT_THREE:
                View layoutThree = LayoutInflater.from(context).inflate(R.layout.service_3,parent,false);
                  return  new Service3ViewHolder(layoutThree);

            default:
                return null;

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
               switch (list.get(position).getViewType()){
                   case LAYOUT_ONE:
                       String categories=list.get(position).getCategories();
                       String see = list.get(position).getSee();
                       String luku = list.get(position).getLuku();
                       String airtime = list.get(position).getAirtime();
                       String tv = list.get(position).getTv();
                       String government = list.get(position).getGovernment();
                       String education= list.get(position).getEducation();
                       String airline = list.get(position).getAirline();
                       String water= list.get(position).getWater();
                       String qr = list.get(position).getQr();
                       String insurance = list.get(position).getInsurance();
                       String hospitals = list.get(position).getHospitals();
                       String stocks = list.get(position).getStocks();
                       String rates = list.get(position).getRates();
                       String tickets = list.get(position).getTickets();
                       String investiments = list.get(position).getInvestiments();
                       String games = list.get(position).getGames();
                       String tembo = list.get(position).getTembo();
                       String football = list.get(position).getFootball();


                       ((ServiceAdapter.Service1ViewHolder) holder).setService1Data(categories,
                               see,luku,airtime,tv,government,education,
                               airline,water,qr,insurance,hospitals,stocks,rates,
                               tickets,investiments,games,tembo,football
                               );
                       break;
                       case LAYOUT_TWO:
                       String you =list.get(position).getYou();
                       String moreservice = list.get(position).getMoreservice();
                       String more = list.get(position).getMore();
                       String payments = list.get(position).getPayments();

                       ((ServiceAdapter.Service2ViewHolder) holder).setService2Data(you,
                               moreservice,more,payments

                               );
                       break;
                       case LAYOUT_THREE:
                       String favorites =list.get(position).getFavorite();
                       String reccuring = list.get(position).getReccuring();

                       ((ServiceAdapter.Service3ViewHolder) holder).setService3Data(favorites,
                               reccuring
                               );
                       break;


               }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Service1ViewHolder extends RecyclerView.ViewHolder {

        private TextView categories,luku,airtime,tv,government,education,airline,
                water,qr,insurance,hospitals,stocks,rates,tickets,
                investiments,games,tembo,football;
        private Button see;
        private Button Buttonluku,Buttonairtime,Buttontv,
                Buttongovernment,Buttoneducation,Buttonairline,
                Buttonwater,Buttonqr,Buttoninsurance,
                Buttonhospitals,Buttonstocks,Buttontickets,
                Buttoninvestiments,Buttongames,Buttontembo,Buttonfootball;


        public Service1ViewHolder(@NonNull View itemView) {
            super(itemView);

            categories = itemView.findViewById(R.id.categories);
            see = itemView.findViewById(R.id.see);
            luku = itemView.findViewById(R.id.luku);
            Buttonluku = itemView.findViewById(R.id.Buttonluku);
            Buttontv = itemView.findViewById(R.id.Buttontv);
            airtime = itemView.findViewById(R.id.airtime);
            Buttonairtime = itemView.findViewById(R.id.Buttonairtime);
            Buttongovernment = itemView.findViewById(R.id.Buttongovernment);
            Buttoneducation = itemView.findViewById(R.id.Buttoneducation);
            Buttonairline = itemView.findViewById(R.id.Buttonairline);
            Buttonwater = itemView.findViewById(R.id.Buttonwater);
            Buttonqr = itemView.findViewById(R.id.Buttonqr);
            Buttonhospitals = itemView.findViewById(R.id.Buttonhospitals);
            Buttoninsurance = itemView.findViewById(R.id.Buttoninsurance);
            Buttonstocks = itemView.findViewById(R.id.Buttonstocks);
            Buttontickets = itemView.findViewById(R.id.Buttontickets);
            Buttoninvestiments = itemView.findViewById(R.id.Buttoninvestiments);
            Buttongames = itemView.findViewById(R.id.Buttongames);
            Buttontembo = itemView.findViewById(R.id.Buttontembo);
            Buttonfootball = itemView.findViewById(R.id.Buttonfootball);
            tv = itemView.findViewById(R.id.tv);
            government = itemView.findViewById(R.id.government);
            education = itemView.findViewById(R.id.education);
            airline = itemView.findViewById(R.id.airline);
            water = itemView.findViewById(R.id.water);
            qr = itemView.findViewById(R.id.qr);
            insurance = itemView.findViewById(R.id.insurance);
            hospitals = itemView.findViewById(R.id.hospitals);
            stocks = itemView.findViewById(R.id.stocks);
            rates = itemView.findViewById(R.id.rates);
            tickets = itemView.findViewById(R.id.tickets);
            investiments = itemView.findViewById(R.id.investiments);
            games = itemView.findViewById(R.id.games);
            tembo = itemView.findViewById(R.id.tembo);
            football = itemView.findViewById(R.id.football);

            Buttonluku.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ServiceLukuButton.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            luku.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ServiceLukuButton.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttonairtime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ServiceAirtimeButton.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            airtime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ServiceAirtimeButton.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttontv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ServiceTvButton.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttongovernment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ServiceGovernmentButton.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttoneducation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttonairline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttonwater.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });
            Buttonqr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });
            Buttoninsurance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttonhospitals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttonstocks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });
            Buttontickets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttoninvestiments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            Buttongames.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });
            Buttontembo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

        Buttonfootball.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });


        }

        void setService1Data(String categories,String see,
                             String luku,String airtime,String tv,
                             String government, String education, String airline,
                             String water,String qr,String insurance,String hospitals,
                             String stocks,String rates,String tickets,String investiments,
                             String games,String tembo,String football
                             ) {

            this.categories.setText(categories);
            this.see.setText(see);
            this.luku.setText(luku);
            this.airtime.setText(airtime);
            this.tv.setText(tv);
            this.government.setText(government);
            this.education.setText(education);
            this.airline.setText(airline);
            this.water.setText(water);
            this.qr.setText(qr);
            this.insurance.setText(insurance);
            this.hospitals.setText(hospitals);
            this.stocks.setText(stocks);
            this.rates.setText(rates);
            this.tickets.setText(tickets);
            this.investiments.setText(investiments);
            this.games.setText(games);
            this.tembo.setText(tembo);
            this.football.setText(football);

        }

    }

 class Service2ViewHolder extends RecyclerView.ViewHolder {

        private TextView you,more,payments;
        private Button moreservice,Buttonmore;


        public Service2ViewHolder(@NonNull View itemView) {
            super(itemView);

            you = itemView.findViewById(R.id.you);
            moreservice = itemView.findViewById(R.id.moreservice);
            more= itemView.findViewById(R.id.more);
            payments= itemView.findViewById(R.id.payments);
            Buttonmore = itemView.findViewById(R.id.Buttonmore);



            Buttonmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            moreservice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });
        }

        void setService2Data(String you,String moreservice,String more,String payments

                             ) {

            this.you.setText(you);
            this.moreservice.setText(moreservice);
            this.more.setText(more);
            this.payments.setText(payments);
        }

    }

 class Service3ViewHolder extends RecyclerView.ViewHolder {

        private Button favorite,reccuring;

        public Service3ViewHolder(@NonNull View itemView) {
            super(itemView);

            favorite = itemView.findViewById(R.id.favorite);
            reccuring = itemView.findViewById(R.id.reccuring);


            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            reccuring.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

        }

        void setService3Data(String favorite,String reccuring

                             ) {

            this.favorite.setText(favorite);
            this.reccuring.setText(reccuring);

        }

    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);

    }


}
