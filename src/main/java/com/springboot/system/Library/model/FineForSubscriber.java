package com.springboot.system.Library.model;

import com.springboot.system.Library.entities.Subscriber;

public class FineForSubscriber {
    private Boolean yesOrNo;
    private Double fineAmount;
    private Subscriber subscriber;

    public FineForSubscriber() {
    }

    public FineForSubscriber(Double fineAmount, Subscriber subscriber, Boolean yesOrNo) {
        this.fineAmount = fineAmount;
        this.subscriber = subscriber;
        this.yesOrNo = yesOrNo;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Boolean getYesOrNo() {
        return yesOrNo;
    }

    public void setYesOrNo(Boolean yesOrNo) {
        this.yesOrNo = yesOrNo;
    }

    @Override
    public String toString() {
        return "FineForSubscriber{" +
                "yesOrNo=" + yesOrNo +
                ", fineAmount=" + fineAmount +
                ", subscriber=" + subscriber +
                '}';
    }
}
