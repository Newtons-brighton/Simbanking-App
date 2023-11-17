package com.example.simbanking.Cards;

public class CardsModelClass {
    public CardsModelClass(int wifi, int crdblogo, int chip,
                           int elephant, int visa, String tembo, String debit) {
        this.wifi = wifi;
        this.crdblogo = crdblogo;
        this.chip = chip;
        this.elephant = elephant;
        this.visa = visa;
        this.tembo = tembo;
        this.debit = debit;
    }

    private int  wifi, crdblogo,chip, elephant,visa;

    public int getWifi() {
        return wifi;
    }

    public int getCrdblogo() {
        return crdblogo;
    }

    public int getChip() {
        return chip;
    }

    public int getElephant() {
        return elephant;
    }

    public int getVisa() {
        return visa;
    }

    public String getTembo() {
        return tembo;
    }

    public String getDebit() {
        return debit;
    }

    private String tembo,debit;



}
