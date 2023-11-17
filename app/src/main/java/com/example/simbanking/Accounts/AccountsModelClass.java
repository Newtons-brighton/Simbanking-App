package com.example.simbanking.Accounts;

public class AccountsModelClass {

    public static final int LAYOUT_ONE=1;
    public static final int LAYOUT_TWO=2;
    public static final int LAYOUT_THREE=3;

    private int viewType;

    private  String saving_text;

    public String getAccNo() {
        return accNo;
    }

    private String accNo;
    public  String actual_text;

    public String getActual_balance() {
        return actual_balance;
    }

    private String actual_balance;

    public String getActual_text() {
        return actual_text;
    }

    public String getSaving_text() {
        return saving_text;
    }

    public AccountsModelClass(int viewType, String saving_text, String accNo,
                              String actual_text, String actual_balance,
                              String available_text, String availableNo) {
        this.viewType = viewType;
        this.available_text = available_text;
        this.availableNo = availableNo;
        this.saving_text = saving_text;
        this.accNo = accNo;
        this.actual_text = actual_text;
        this.actual_balance = actual_balance;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public String getText4() {
        return text4;
    }

    public String getText1() {
        return text1;
    }

    public AccountsModelClass(int viewType, String text1, String text2, String text3, String text4) {
        this.viewType = viewType;
        this.text1= text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;

    }


    public int getViewType() {
        return viewType;
    }


    public String getAvailableNo() {
        return availableNo;
    }

    public String getAvailable_text() {
        return available_text;
    }



    private String available_text;

    private  String availableNo;

    private String text2;

    private String text1;
    private String text3;
    private String text4;

    public String getLipa() {
        return lipa;
    }

    public String getPay() {
        return pay;
    }

    public AccountsModelClass(int viewType, String lipa, String pay) {
        this.viewType = viewType;
        this.lipa = lipa;
        this.pay = pay;
    }

    private String lipa;
    private String pay;


}


