package com.jwt.model;

import javax.persistence.*;

@Entity
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rating_id;

    private int ambiance;
    private int food;
    private int service;
    private int drinks;
    private int cleanliness;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;

    public Ratings() {
    }

    public Ratings(int rating_id, int ambiance, int food, int service, int drinks, int cleanliness, User user) {
        this.rating_id = rating_id;
        this.ambiance = ambiance;
        this.food = food;
        this.service = service;
        this.drinks = drinks;
        this.cleanliness = cleanliness;
        this.user = user;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "rating_id=" + rating_id +
                ", ambiance=" + ambiance +
                ", food=" + food +
                ", service=" + service +
                ", drinks=" + drinks +
                ", cleanliness=" + cleanliness +
                ", user=" + user +
                '}';
    }
}
