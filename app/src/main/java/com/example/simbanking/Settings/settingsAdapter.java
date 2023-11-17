package com.example.simbanking.Settings;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_FIVE;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_FOUR;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_ONE;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_THREE;
import static com.example.simbanking.Settings.SettingModel.LAYOUT_TWO;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simbanking.CircularViewActivity;
import com.example.simbanking.Mandates;
import com.example.simbanking.MandatesActivity;
import com.example.simbanking.ProfileActivity;
import com.example.simbanking.R;

import java.util.List;

public class settingsAdapter extends RecyclerView.Adapter {

    List<SettingModel> list;
    Context context;
    private RecyclerViewClickListener listener;

    public interface UnregisterButtonClickListener {
        void onUnregisterButtonClick(int position);
    }

    private UnregisterButtonClickListener unregisterListener;

    public settingsAdapter(List<SettingModel> list, Context context,
                           RecyclerViewClickListener listener,
                           UnregisterButtonClickListener unregisterListener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
        this.unregisterListener = unregisterListener;
    }



    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getViewType()) {

            case 1:
                return LAYOUT_ONE;
            case 5:
                return LAYOUT_FIVE;
            case 2:
                return LAYOUT_TWO;
            case 3:
                return LAYOUT_THREE;
            case 4:
                return LAYOUT_FOUR;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case LAYOUT_ONE:
                View layoutOne = LayoutInflater.from(context).inflate(R.layout.settings1_cardview,
                        parent, false);
                return new Settings1ViewHolder(layoutOne);
            case LAYOUT_FIVE:
                View layoutFive = LayoutInflater.from(context).inflate(R.layout.settings_cardview,
                        parent, false);
                return new SettingsViewHolder(layoutFive);

            case LAYOUT_TWO:
                View layoutTwo = LayoutInflater.from(context).inflate(R.layout.settings2_cardview,
                        parent, false);
                return new Settings2ViewHolder(layoutTwo);
            case LAYOUT_THREE:
                View layoutThree = LayoutInflater.from(context).inflate(R.layout.settings3_cardview,
                        parent, false);
                return new Settings3ViewHolder(layoutThree);
            case LAYOUT_FOUR:
                View layoutFour = LayoutInflater.from(context).inflate(R.layout.settings4_cardview,
                        parent, false);
                return new Settings4ViewHolder(layoutFour);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType()) {
            case LAYOUT_ONE:
                String mandates = list.get(position).getMandates();
                String mandates_button = list.get(position).getMandates_button();
                ((Settings1ViewHolder) holder).setSettings1Data(mandates,
                        mandates_button);
                break;

            case LAYOUT_FIVE:
                String profile = list.get(position).getProfile();
                ((SettingsViewHolder) holder).setSettingsData(profile);
                break;

            case LAYOUT_TWO:
                String account_button = list.get(position).getAccount_button();
                String set_button = list.get(position).getSet_button();
                String bio_update = list.get(position).getBio_update();
                String fav_button = list.get(position).getFav_button();
                ((Settings2ViewHolder) holder).setSettings2Data(account_button, set_button,
                        bio_update, fav_button);
                break;

            case LAYOUT_THREE:
                String security = list.get(position).getSecurity();
                String pin_button = list.get(position).getPin_button();
                String validator_button = list.get(position).getValidator_button();
                ((Settings3ViewHolder) holder).setSettings3Data(security, pin_button, validator_button
                );
                break;
            case LAYOUT_FOUR:
                String application = list.get(position).getApplication();
                String switch_button = list.get(position).getSwitch_button();
                String biologin_button = list.get(position).getBiologin_button();
                String theme_button = list.get(position).getTheme_button();
                String unregister_button = list.get(position).getUnregister_button();
                ((Settings4ViewHolder) holder).setSettings4Data(application, switch_button, biologin_button,
                        theme_button, unregister_button
                );
                break;

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Settings1ViewHolder extends RecyclerView.ViewHolder{

        private TextView mandates;
        private Button mandates_button;


        public Settings1ViewHolder(@NonNull View itemView) {
            super(itemView);

            mandates = itemView.findViewById(R.id.mandates);
            mandates_button = itemView.findViewById(R.id.mandates_button);

            mandates_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class);
                    // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

        }


        void setSettings1Data(String mandates,
                              String mandates_button) {
            this.mandates.setText(mandates);
            this.mandates_button.setText(mandates_button);
        }

    }



    class SettingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView profile;


        public SettingsViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            itemView.setOnClickListener(this);

        }

        void setSettingsData(String profile) {

           this.profile.setText(profile);
        }

        @Override
        public void onClick(View v) {

            listener.onClick(v,getAdapterPosition());
            // Create an Intent to navigate to the desired activity
            Intent intent = new Intent(v.getContext(), CircularViewActivity.class);

            // You can also pass any extra data to the target activity using intent.putExtra() if needed
            // Start the activity
            v.getContext().startActivity(intent);
        }
    }

    class Settings2ViewHolder extends RecyclerView.ViewHolder {
        private Button account_button, set_button,
                bio_update, fav_button;

        public Settings2ViewHolder(@NonNull View itemView) {
            super(itemView);
            account_button = itemView.findViewById(R.id.account_button);
            set_button = itemView.findViewById(R.id.set_button);
            bio_update = itemView.findViewById(R.id.bio_update);
            fav_button = itemView.findViewById(R.id.fav_button);


            account_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });


            set_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });


            bio_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });


            fav_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });
        }

        void setSettings2Data(String account_button, String set_button,
                              String bio_update,String fav_button) {

            this.account_button.setText(account_button);
            this.set_button.setText(set_button);
            this.bio_update.setText(bio_update);
            this.fav_button.setText(fav_button);

        }

    }

    class Settings3ViewHolder extends RecyclerView.ViewHolder {

        private TextView security;
        private Button pin_button, validator_button;


        public Settings3ViewHolder(@NonNull View itemView) {
            super(itemView);

            security = itemView.findViewById(R.id.security);
            pin_button = itemView.findViewById(R.id.pin_button);
            validator_button = itemView.findViewById(R.id.validator_button);


            security.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            pin_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

            validator_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MandatesActivity.class); // Replace YourNewActivity with the actual activity you want to start
                    context.startActivity(intent);
                }
            });

        }

        void setSettings3Data(String security, String pin_button, String validator_button) {

            this.security.setText(security);
            this.pin_button.setText(pin_button);
            this.validator_button.setText(validator_button);
        }

    }
    class Settings4ViewHolder extends RecyclerView.ViewHolder {

        private TextView application;
        private Button switch_button, biologin_button, theme_button, unregister_button;


        public Settings4ViewHolder(@NonNull View itemView) {
            super(itemView);

            application = itemView.findViewById(R.id.application);
            switch_button = itemView.findViewById(R.id.switch_button);
            biologin_button = itemView.findViewById(R.id.biologin_button);
            theme_button = itemView.findViewById(R.id.theme_button);
            unregister_button = itemView.findViewById(R.id.unregister_button);

            // Set a click listener for the unregister_button
            unregister_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the unregister_button click here
                    int position = getAdapterPosition();

                    unregisterListener.onUnregisterButtonClick(position);
                }
            });

        }

        void setSettings4Data(String application,
                              String switch_button,
                              String biologin_button,
                              String theme_button,
                              String unregister_button) {

            this.application.setText(application);
            this.switch_button.setText(switch_button);
            this.biologin_button.setText(biologin_button);
            this.theme_button.setText(theme_button);
            this.unregister_button.setText(unregister_button);
        }

    }


    public interface RecyclerViewClickListener{
       void onClick(View v, int position);

    }

}

