package com.fiap.globalsolution.domain.reserva.entity;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="T_GS_RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="vl_preco_total")
    private Double precoTotal;

    @Column(name="dt_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar entrada;

    @Column(name="dt_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar saida;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Hotel hotel;

    public Reserva(Integer id, Double precoTotal, Calendar entrada, Calendar saida, Usuario usuario, Hotel hotel) {
        this.id = id;
        this.precoTotal = precoTotal;
        this.entrada = entrada;
        this.saida = saida;
        this.usuario = usuario;
        this.hotel = hotel;
    }

    public Reserva() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Calendar getEntrada() {
        return entrada;
    }

    public void setEntrada(Calendar entrada) {
        this.entrada = entrada;
    }

    public Calendar getSaida() {
        return saida;
    }

    public void setSaida(Calendar saida) {
        this.saida = saida;
    }
}
