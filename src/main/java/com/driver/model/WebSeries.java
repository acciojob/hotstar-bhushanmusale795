package com.driver.model;


import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class
WebSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String seriesName;

    private int ageLimit;

    private double rating;

    private SubscriptionType subscriptionType; //This denotes with which of subscriptionType this webseries comes ie. BASIC,PRO, ELITE

    @ManyToOne
    @JoinColumn
    private ProductionHouse productionHouse;

    public WebSeries(String seriesName, int ageLimit, double rating, SubscriptionType subscriptionType) {
        this.seriesName = seriesName;
        this.ageLimit = ageLimit;
        this.rating = rating;
        this.subscriptionType = subscriptionType;
    }

    public WebSeries() {

    }
    public WebSeries(String title, Subscription.Plan requiredPlan, double rating) {
        this.title = title;
        this.requiredPlan = requiredPlan;
        this.rating = rating;
    }

    public boolean isAccessible(@NotNull Subscription subscription) {
        if (subscription.getPlan() == Subscription.Plan.ELITE) {
            return true; // ELITE can access everything
        }
        return subscription.getPlan() == requiredPlan ||
                (subscription.getPlan() == Subscription.Plan.PRO && requiredPlan == Subscription.Plan.BASIC);
    }

    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public ProductionHouse getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(ProductionHouse productionHouse) {
        this.productionHouse = productionHouse;
    }
}
