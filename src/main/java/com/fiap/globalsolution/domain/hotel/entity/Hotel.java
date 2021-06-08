package com.fiap.globalsolution.domain.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.globalsolution.domain.dica.entity.Dica;
import com.fiap.globalsolution.domain.endereco.entity.Endereco;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_GS_HOTEL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hotel {

    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nm_hotel")
    private String nome;

    @Column(name = "ft_hotel", length = 255)
    private String foto;

    @Column(name = "vl_preco")
    private Double preco;

    @Column(name = "ds_descricao", length = 455)
    private String descricao;

    @Column(name = "nr_rating")
    private int rating;

    @Column(name = "ds_link", length = 255)
    private String link;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_endereco")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dica")
    private Dica dica;

    public Hotel() {
    }


    public Hotel(String nome, Endereco endereco, String foto, Double preco,int rating, String link, String descricao,  Dica dica) {
        super();
        this.nome = nome;
        this.foto = foto;
        this.preco = preco;
        this.descricao = descricao;
        this.rating = rating;
        this.link = link;
        this.endereco = endereco;
        this.dica = dica;
    }

    public Hotel(Hotel obj){
        this.nome = obj.getNome();
        this.foto =  obj.getFoto();
        this.preco =  obj.getPreco();
        this.descricao =  obj.getDescricao();
        this.rating =  obj.getRating();
        this.link =  obj.getLink();
        this.endereco =  obj.getEndereco();
        this.dica =  obj.getDica();
    }



    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Dica getDica() {
        return dica;
    }


    public void setDica(Dica dica) {
        this.dica = dica;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public int getRating() {
        return rating;
    }

    public void setRatiing(int ratiing) {
        this.rating = ratiing;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
