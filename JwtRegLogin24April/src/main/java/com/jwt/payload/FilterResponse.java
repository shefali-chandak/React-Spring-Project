package com.jwt.payload;

public class FilterResponse {
    private String name;
    private int ambiance;
    private int cleanliness;
    private int service;
    private int food;
    private int drinks;

    public FilterResponse(String name, int ambiance, int cleanliness,int drinks,int food, int service) {
        this.name = name;
        this.ambiance = ambiance;
        this.cleanliness = cleanliness;
        this.service = service;
        this.food = food;
        this.drinks = drinks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }
}
