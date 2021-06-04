package com.fiap.globalsolution.domain.reserva.entity;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="tb_reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vl_preco_total")
    private Double precoTotal;

    @Column(name = "dt_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar entrada;

    @Column(name = "dt_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar saida;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Hotel> hotel = new ArrayList<>();

    @ManyToOne()
    private Usuario usuario;

    public Reserva(Integer id, Double precoTotal, Calendar entrada, Calendar saida) {
        this.id = id;
        this.precoTotal = precoTotal;
        this.entrada = entrada;
        this.saida = saida;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
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
