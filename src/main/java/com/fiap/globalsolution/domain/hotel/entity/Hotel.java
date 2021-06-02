package com.fiap.globalsolution.domain.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import com.fiap.globalsolution.domain.enums.Preco;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="T_GS_HOTEL")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String logalizacao;
    private String image;
    private double price;
    private String cidade;
    private String linkHotel;

    @OneToMany(mappedBy = "hotel")
    private List<Reserva> reservas;

    @ManyToMany()
    @JoinTable(name = "tb_hotel_usuario", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

    @Transient
    @JsonIgnore
    private Preco priceHigth;
    private int rating;

    public Hotel(Integer id, String name, String logalizacao, String image, double price, String cidade, Preco priceHigth, int rating, String linkHotel) {
        this.id = id;
        this.name = name;
        this.logalizacao = logalizacao;
        this.image = image;
        this.price = price;
        this.cidade = cidade;
        this.linkHotel = linkHotel;
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

    public String getLinkHotel() {
        return linkHotel;
    }

    public void setLinkHotel(String linkHotel) {
        this.linkHotel = linkHotel;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    public String getLogalizacao() {
        return logalizacao;
    }

    public void setLogalizacao(String description) {
        this.logalizacao = description;
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
