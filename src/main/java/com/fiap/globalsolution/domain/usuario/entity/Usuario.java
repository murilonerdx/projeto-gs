package com.fiap.globalsolution.domain.usuario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.globalsolution.domain.endereco.entity.Endereco;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_GS_USUARIO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_senha")
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento")
    private Calendar dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToOne()
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Calendar dataNascimento, Endereco endereco) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Reserva> getReserva() {
        return reservas;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reservas = reserva;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}