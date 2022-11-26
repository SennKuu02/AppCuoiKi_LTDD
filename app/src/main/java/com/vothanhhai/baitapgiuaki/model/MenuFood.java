package com.vothanhhai.baitapgiuaki.model;

import java.io.Serializable;

public class MenuFood implements Serializable {
    String name;
    String price;
    Integer imageURL;
    String rating;


    public MenuFood(String name, String price, Integer imageURL, String rating) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageURL() {
        return imageURL;
    }

    public void setImageURL(Integer imageURL) {
        this.imageURL = imageURL;
    }
}
