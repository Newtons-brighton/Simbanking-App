package com.example.simbanking.Agent;
public class AgentModalClass {

    public static final int LAYOUT_ONE=1;
    public static final int LAYOUT_TWO=2;
    public static final int LAYOUT_THREE=3;


    private String visit;
    private int viewType;

    private String withdraw;

    public String getVisit() {
        return visit;
    }

    public String getWithdraw() {
        return withdraw;
    }

    public String getAmount() {
        return amount;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getDescription() {
        return description;
    }

    public String getProceed() {
        return proceed;
    }

    public AgentModalClass(int viewType,String visit,String withdraw) {
        this.viewType = viewType;
        this.visit = visit;
        this.withdraw = withdraw;
    }


    private String amount;

    public AgentModalClass(int viewType, String amount) {
        this.viewType = viewType;
        this.amount = amount;
    }

    public int getViewType() {
        return viewType;
    }

    private String transaction;
    private String description;
    private  String proceed;

    public AgentModalClass(int viewType, String transaction, String description, String proceed) {
        this.viewType = viewType;
        this.transaction = transaction;
        this.description = description;
        this.proceed = proceed;
    }


}
