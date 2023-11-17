package com.example.simbanking.Loans;

import android.widget.Button;

public class LoansModelClass {

    public static final int LAYOUT_ONE=1;

    public String getLoans() {
        return Loans;
    }

    public static final int LAYOUT_TWO=2;
    public static final int LAYOUT_THREE=3;

    private int viewType;

    private  String enjoy;

    public String getEnjoy() {
        return enjoy;
    }

    private String branches;

    private String button;
    private String button2;
    private String button3;
    private String button4;

    public LoansModelClass(int viewType, String enjoy, String branches) {
        this.viewType = viewType;
        this.enjoy = enjoy;
        this.branches = branches;
    }

    public String getLoan() {
        return Loan;
    }

    public String getApply() {
        return Apply;
    }

    public String getRepay() {
        return Repay;
    }

    public String getTerms() {
        return Terms;
    }
    public String getService() {
        return Service;
    }

    public LoansModelClass(int viewType, String Apply, String Loans, String Repay, String Loan,String Summary,
                           String Terms, String Service,String button, String button2,
                           String button3, String button4) {
        this.viewType = viewType;
        this.Apply= Apply;
        this.Loans = Loans;
        this.Repay = Repay;
        this.Loan = Loan;
        this.Summary = Summary;
        this.Terms = Terms;
        this.Service = Service;
        this.button = button;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
    }


    // Getter methods for the buttons
    public String getButton() {
        return button;
    }

    public String getButton2() {
        return button2;
    }

    public String getButton3() {
        return button3;
    }

    public String getButton4() {
        return button4;
    }

    public String getSummary() {
        return Summary;
    }

    private String Apply;

    private String Summary;
    private String Loans;

    private String Repay;
    private String Loan;

    private String Terms;
    private String Service;


    public int getViewType() {
        return viewType;
    }

    public String getSalary() {
        return Salary;
    }

    public String getUp() {
        return Up;
    }

    public String getInterest() {
        return Interest;
    }
    public String getIn() {
        return In;
    }

    public LoansModelClass(int viewType, String Salary, String Up, String Interest, String In) {
        this.viewType = viewType;
        this.Salary = Salary;
        this.Up = Up;
        this.Interest = Interest;
        this.In = In;
    }

    private String Salary;
    private String Up;

    public String getBranches() {
        return branches;
    }

    private String Interest;
    private String In;


}


