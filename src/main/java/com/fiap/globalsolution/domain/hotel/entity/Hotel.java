package com.fiap.globalsolution.domain.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.globalsolution.domain.enums.Preco;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String localization;
    private String description;
    private String image;
    private double price;
    private String city;
    private String linkHotel;

    @ManyToMany(mappedBy = "hotel")
    private List<Reserva> reservas;

    @Transient
    @JsonIgnore
    private Preco priceHigth;
    private int rating;

    public Hotel(Integer id, String name, String localization, String image, double price, String city, Preco priceHigth, int rating, String linkHotel, String description) {
        this.id = id;
        this.name = name;
        this.localization = localization;
        this.image = image;
        this.price = price;
        this.city = city;
        this.linkHotel = linkHotel;
        this.priceHigth = priceHigth;
        this.rating = rating;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLinkHotel() {
        return linkHotel;
    }

    public void setLinkHotel(String linkHotel) {
        this.linkHotel = linkHotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String description) {
        this.localization = description;
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

    public String getCity() {
        return city;
    }

    public void setCity(String category) {
        this.city = category;
    }
}
