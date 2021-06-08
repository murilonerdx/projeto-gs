package com.fiap.globalsolution.domain.hotel.dto;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.persistence.Column;

public class HotelDTO {

    private Integer id;

    private String nome;

    private String foto;

    private Double preco;

    private String descricao;

    private int rating;

    private String link;


    public HotelDTO(Integer id, String nome, String foto, Double preco, String descricao, int rating, String link) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.preco = preco;
        this.descricao = descricao;
        this.rating = rating;
        this.link = link;
    }

    public HotelDTO(Hotel obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.foto = obj.getFoto();
        this.preco = obj.getPreco();
        this.descricao = obj.getDescricao();
        this.rating = obj.getRating();
        this.link = obj.getLink();
    }

    public HotelDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
