package com.fiap.globalsolution.domain.reserva.entity;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="tb_reserva")
public class Reserva {

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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name="tb_reserva_hotel",joinColumns = @JoinColumn(name="id_reserva"),inverseJoinColumns = @JoinColumn(name="id_hotel"))
    private List<Hotel> hotel;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public Reserva(Integer id, Double precoTotal, Calendar entrada, Calendar saida) {
        this.id = id;
        this.precoTotal = precoTotal;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Reserva() {
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
