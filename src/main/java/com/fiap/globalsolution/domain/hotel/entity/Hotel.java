package com.fiap.globalsolution.domain.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import com.fiap.globalsolution.domain.enums.Preco;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String image;
    private double price;
    private String cidade;

    @ManyToMany()
    @JoinTable(name = "tb_hotel_usuario", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

    @Transient
    @JsonIgnore
    private Preco priceHigth;
    private int rating;

    public Hotel(Integer id, String name, String description, String image, double price, String cidade, Preco priceHigth, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String category) {
        this.cidade = category;
    }
}
