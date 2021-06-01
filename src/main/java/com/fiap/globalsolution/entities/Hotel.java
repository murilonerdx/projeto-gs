package com.fiap.globalsolution.entities;

import com.fiap.globalsolution.entities.enums.Preco;

public class Hotel {
    private int id;
    private String code;
    private String name;
    private String description;
    private String image;
    private double price;
    private String category;
    private Preco priceHigth;
    private int rating;

    public Hotel(int id, String code, String name, String description, String image, double price, String category, Preco priceHigth, int rating) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
        this.priceHigth = priceHigth;
        this.rating = rating;
    }

    public Preco getPriceHigth() {
        return priceHigth;
    }

    public void setPriceHigth(Preco priceHigth) {
        this.priceHigth = priceHigth;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
