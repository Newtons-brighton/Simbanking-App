package com.example.simbanking.Settings;
public class SettingModel {

public static final int LAYOUT_ONE=1;
public static final int LAYOUT_TWO=2;
public static final int LAYOUT_THREE=3;
public static final int LAYOUT_FOUR=4;

public static final int LAYOUT_FIVE=5;

    public String getApplication() {
        return application;
    }

    private String application;

    private   int viewType;

    public int getViewType() {
        return viewType;
    }

    public String getMandates() {
        return mandates;
    }

    public String getMandates_button() {
        return mandates_button;
    }

    public String getProfile() {
        return profile;
    }

    public String getAccount_button() {
        return account_button;
    }



    public String getBio_update() {
        return bio_update;
    }

    public String getFav_button() {
        return fav_button;
    }

    public String getSecurity() {
        return security;
    }

    public String getPin_button() {
        return pin_button;
    }

    public String getValidator_button() {
        return validator_button;
    }

    public SettingModel(int viewType,
                        String mandates, String mandates_button

                       ) {
        this.viewType = viewType;
        this.mandates = mandates;
        this.mandates_button = mandates_button;
    }
    public SettingModel(int viewType,String security,
                        String pin_button, String validator_button
                       ) {
        this.viewType = viewType;
        this.security = security;
        this.pin_button = pin_button;
        this.validator_button = validator_button;
    }




    private  String validator_button;
    private  String mandates;
    private  String mandates_button;

    public SettingModel(int viewType, String profile) {
        this.viewType = viewType;
        this.profile = profile;
    }

    private  String profile;
    private  String account_button;

    private  String set_button;
    private  String bio_update;

    public String getSet_button() {
        return set_button;
    }

    private  String fav_button;
    private  String security;
    private  String pin_button;


    private String theme_button;



    public String getTheme_button() {
        return theme_button;
    }


    public String getUnregister_button() {
        return unregister_button;
    }

    public SettingModel(int viewType,String account_button,
                        String set_button, String bio_update, String fav_button) {
        this.viewType = viewType;
        this.account_button = account_button;
        this.set_button = set_button;
        this.bio_update = bio_update;
        this.fav_button = fav_button;
    }

    public SettingModel(int viewType, String application,
                        String switch_button,
                        String biologin_button,
                        String theme_button,
                        String unregister_button) {
        this.viewType = viewType;
        this.application= application;
        this.switch_button = switch_button;
        this.biologin_button = biologin_button;
        this.theme_button = theme_button;
        this.unregister_button = unregister_button;
    }

    public String getSwitch_button() {
        return switch_button;
    }

    private String switch_button;
    private String unregister_button;

    public String getBiologin_button() {
        return biologin_button;
    }

    private String biologin_button;


}
