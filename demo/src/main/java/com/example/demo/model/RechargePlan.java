package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RechargePlan {
    @Id
    private long id;
    private String planName;
    private String planDescription;
    private int planDuration;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @JsonBackReference
    private User user;


    public RechargePlan() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPlanName() {
        return planName;
    }
    public void setPlanName(String planName) {
        this.planName = planName;
    }
    public String getPlanDescription() {
        return planDescription;
    }
    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }
    public int getPlanDuration() {
        return planDuration;
    }
    public void setPlanDuration(int planDuration) {
        this.planDuration = planDuration;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}

