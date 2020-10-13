package com.pierluigi.advertising_campaign.Domain;

public class Counter {
    public enum Categories {
        LISTEN_WEB,
        LISTEN_RADIO
    }
    private Categories category;
    private int listenNumber;


    public Counter(Categories category, int listenNumber) {
        this.category = category;
        this.listenNumber = listenNumber;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public int getListenNumber() {
        return listenNumber;
    }

    public void setListenNumber(int listenNumber) {
        this.listenNumber = listenNumber;
    }
}
