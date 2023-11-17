package com.example.simbanking.services;

import android.widget.Button;
import android.widget.TextView;

public class ServiceModel {

    public static final int LAYOUT_ONE=1;
    public static final int LAYOUT_TWO=2;
    public static final int LAYOUT_THREE=3;



    private int ViewType;
    private String categories;
    private String see;
    private String luku;
    private String airtime;
    private String tv;

    public String getCategories() {
        return categories;
    }

    public String getSee() {
        return see;
    }

    public String getLuku() {
        return luku;
    }

    public String getAirtime() {
        return airtime;
    }

    public String getTv() {
        return tv;
    }

    public String getGovernment() {
        return government;
    }

    public String getEducation() {
        return education;
    }

    public String getAirline() {
        return airline;
    }

    public String getWater() {
        return water;
    }

    public String getQr() {
        return qr;
    }

    public String getInsurance() {
        return insurance;
    }

    public String getHospitals() {
        return hospitals;
    }

    public String getStocks() {
        return stocks;
    }

    public String getRates() {
        return rates;
    }

    public String getTickets() {
        return tickets;
    }

    public String getInvestiments() {
        return investiments;
    }

    public String getGames() {
        return games;
    }

    public String getTembo() {
        return tembo;
    }

    public String getFootball() {
        return football;
    }

    public String getMore() {
        return more;
    }

    public int getViewType() {
        return ViewType;
    }

    public String getPayments() {
        return payments;
    }

    public ServiceModel(int viewType, String categories, String see,
                        String luku, String airtime, String tv,
                        String government, String education, String airline,
                        String water, String qr, String insurance, String hospitals,
                        String stocks, String rates, String tickets, String investiments,
                        String games,
                        String tembo, String football) {
        ViewType = viewType;
        this.categories = categories;
        this.see = see;
        this.luku = luku;
        this.airtime = airtime;
        this.tv = tv;
        this.government = government;
        this.education = education;
        this.airline = airline;
        this.water = water;
        this.qr = qr;
        this.insurance = insurance;
        this.hospitals = hospitals;
        this.stocks = stocks;
        this.rates = rates;
        this.tickets = tickets;
        this.investiments = investiments;
        this.games = games;
        this.tembo = tembo;
        this.football = football;
        this.more = more;
        this.payments = payments;
    }

    private String government;
    private String education;
    private String airline;
    private String water;
    private String qr;
    private String insurance;
    private String hospitals;
    private String stocks;
    private String rates;
    private String tickets;
    private String investiments;
    private String games;
    private String tembo;
    private String football;
    private String more;
    private String payments;


    public String getFavorite() {
        return favorite;
    }

    public String getReccuring() {
        return reccuring;
    }

    public ServiceModel(int viewType, String favorite, String reccuring) {
        ViewType = viewType;
        this.favorite = favorite;
        this.reccuring = reccuring;
    }

    private String favorite, reccuring;

    public String getYou() {
        return you;
    }

    public String getMoreservice() {
        return moreservice;
    }

    public ServiceModel(int viewType, String you, String moreservice,String more, String payments) {
        ViewType = viewType;
        this.you = you;
        this.moreservice = moreservice;
        this.more = more;
        this.payments = payments;
    }

    private String you;
    private String moreservice;

}
