package com.driver.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SubscriptionType subscriptionType;

    private int noOfScreensSubscribed;

    private Date startSubscriptionDate;

    private int totalAmountPaid;

    @OneToOne
    @JoinColumn
    private User user;

    public Subscription(SubscriptionType subscriptionType, int noOfScreensSubscribed, Date startSubscriptionDate, int totalAmountPaid) {
        this.subscriptionType = subscriptionType;
        this.noOfScreensSubscribed = noOfScreensSubscribed;
        this.startSubscriptionDate = startSubscriptionDate;
        this.totalAmountPaid = totalAmountPaid;
    }

    public Subscription() {

    }
    public enum Plan {
        BASIC, PRO, ELITE
    }

    private Plan plan;
    private int noOfScreensSubscribed;

    public Subscription(Plan plan, int noOfScreensSubscribed) {
        this.plan = plan;
        this.noOfScreensSubscribed = noOfScreensSubscribed;
    }

    public double calculateCost() {
        switch (plan) {
            case BASIC:
                return 500 + 200 * noOfScreensSubscribed;
            case PRO:
                return 800 + 250 * noOfScreensSubscribed;
            case ELITE:
                return 1000 + 350 * noOfScreensSubscribed;
            default:
                throw new IllegalArgumentException("Unknown subscription plan");
        }
    }

    public Plan getPlan() {
        return plan;
    }
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getNoOfScreensSubscribed() {
        return noOfScreensSubscribed;
    }

    public void setNoOfScreensSubscribed(int noOfScreensSubscribed) {
        this.noOfScreensSubscribed = noOfScreensSubscribed;
    }

    public Date getStartSubscriptionDate() {
        return startSubscriptionDate;
    }

    public void setStartSubscriptionDate(Date durationOfSubscription) {
        this.startSubscriptionDate = durationOfSubscription;
    }

    public int getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(int totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
