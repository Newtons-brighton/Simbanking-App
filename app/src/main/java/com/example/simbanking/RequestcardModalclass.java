package com.example.simbanking;

public class RequestcardModalclass {

    public static final int LAYOUT_ONE=1;
    public static final int LAYOUT_TWO=2;

    private int viewType;
    private String select;
    private String tap1;
    private String tap2;
    private String tap3;
    private String tap4;
    private String tap5;
    private String tap12;
    private String tap22;
    private String tap32;
    private String tap42;
    private String tap52;
    private String tap62;
    private String tap72;
    private String tap82;

    private String visa_tzs_button;
    private String visa_Gold_button;
    private String visa_Platinum_button;
    private String visa_infinite_button;
    private String union_pay_button;
    private String simba_fan_button;
    private String simba_platinum_button;
    private String yanga_visa_button;
    private String simba_club_button;
    private String albarakah_visa_button;
    private String albarakah_gold_button;
    private String albarakah_platinum_button;
    private String albarakah_infinite_button;

    public RequestcardModalclass(int viewType, String select,
                                 String visa_tzs_button,String tap1,
                                 String visa_Gold_button, String tap2,
                                 String visa_Platinum_button,String tap3,
                                 String visa_infinite_button,String tap4,
                                 String union_pay_button,String tap5
    ) {
        this.viewType = viewType;
        this.select = select;
        this.visa_tzs_button = visa_tzs_button;
        this.tap1 = tap1;
        this.visa_Gold_button = visa_Gold_button;
        this.tap2 = tap2;
        this.visa_Platinum_button = visa_Platinum_button;
        this.tap3 = tap3;
        this.visa_infinite_button = visa_infinite_button;
        this.tap4 = tap4;
        this.union_pay_button = union_pay_button;
        this.tap5 = tap5;

    }


    public String getTap1() {
        return tap1;
    }

    public String getTap2() {
        return tap2;
    }

    public RequestcardModalclass(int viewType,
                                 String simba_fan_button, String tap12,
                                 String simba_platinum_button,
                                 String tap22,
                                 String yanga_visa_button,
                                 String tap32,
                                 String simba_club_button,
                                 String tap42,
                                 String albarakah_visa_button,
                                 String tap52,
                                 String albarakah_gold_button,
                                 String tap62,
                                 String albarakah_platinum_button,
                                 String tap72,
                                 String albarakah_infinite_button,
                                 String tap82

    ) {
        this.viewType = viewType;
        this.simba_fan_button = simba_fan_button;
        this.tap12 = tap12;
        this.simba_platinum_button = simba_platinum_button;
        this.tap22 = tap22;
        this.yanga_visa_button = yanga_visa_button;
        this.tap32 = tap32;
        this.simba_club_button = simba_club_button;
        this.tap42 = tap42;
        this.albarakah_visa_button = albarakah_visa_button;
        this.tap52 = tap52;
        this.albarakah_gold_button = albarakah_gold_button;
        this.tap62 = tap62;
        this.albarakah_platinum_button = albarakah_platinum_button;
        this.tap72 = tap72;
        this.albarakah_infinite_button = albarakah_infinite_button;
        this.tap82 = tap82;

    }

    public String getTap12() {
        return tap12;
    }

    public String getTap32() {
        return tap32;
    }

    public String getTap42() {
        return tap42;
    }

    public String getTap52() {
        return tap52;
    }

    public String getTap62() {
        return tap62;
    }

    public String getTap72() {
        return tap72;
    }

    public String getTap82() {
        return tap82;
    }

    public String getTap3() {
        return tap3;
    }

    public String getTap4() {
        return tap4;
    }

    public String getTap5() {
        return tap5;
    }



    public String getTap22() {
        return tap22;
    }



    public int getViewType() {
        return viewType;
    }

    public String getSelect() {
        return select;
    }

    public String getVisa_tzs_button() {
        return visa_tzs_button;
    }

    public String getVisa_Gold_button() {
        return visa_Gold_button;
    }

    public String getVisa_Platinum_button() {
        return visa_Platinum_button;
    }

    public String getVisa_infinite_button() {
        return visa_infinite_button;
    }

    public String getUnion_pay_button() {
        return union_pay_button;
    }

    public String getSimba_fan_button() {
        return simba_fan_button;
    }

    public String getSimba_platinum_button() {
        return simba_platinum_button;
    }

    public String getYanga_visa_button() {
        return yanga_visa_button;
    }

    public String getSimba_club_button() {
        return simba_club_button;
    }

    public String getAlbarakah_visa_button() {
        return albarakah_visa_button;
    }

    public String getAlbarakah_gold_button() {
        return albarakah_gold_button;
    }

    public String getAlbarakah_platinum_button() {
        return albarakah_platinum_button;
    }

    public String getAlbarakah_infinite_button() {
        return albarakah_infinite_button;
    }
}
