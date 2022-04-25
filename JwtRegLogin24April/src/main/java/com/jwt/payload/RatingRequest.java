package com.jwt.payload;

import javax.validation.constraints.NotBlank;

public class RatingRequest {
    @NotBlank
    private String ambiance;
    @NotBlank
    private String food;
    @NotBlank
    private String service;
    @NotBlank
    private String drinks;
    @NotBlank
    private String cleanliness;

    public String getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(String ambiance) {
        this.ambiance = ambiance;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    @Override
    public String toString() {
        return "RatingRequest{" +
                "ambiance=" + ambiance +
                ", food=" + food +
                ", service=" + service +
                ", drinks=" + drinks +
                ", cleanliness=" + cleanliness +
                '}';
    }
}
