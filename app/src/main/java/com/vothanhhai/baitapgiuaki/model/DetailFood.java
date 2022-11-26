package com.vothanhhai.baitapgiuaki.model;

import java.io.Serializable;

public class DetailFood implements Serializable {


    String name;
    String price;
    Integer imageURL;
    String rating;
    String description;



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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DetailFood( String name, String price, Integer imageURL, String rating, String description) {

        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.rating = rating;
        this.description = description;
    }
}
