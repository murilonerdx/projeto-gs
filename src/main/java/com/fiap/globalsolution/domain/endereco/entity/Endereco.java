package com.fiap.globalsolution.domain.endereco.entity;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "TB_GS_ENDERECO")
public class Endereco {

    @Id
    @Column(name = "id_endereco", length = 3)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    @Column(name = "ds_rua", length = 50)
    private String rua;

    @Column(name = "ds_cep", length = 9)
    private String cep;

    @Column(name = "ds_bairro", length = 50)
    private String bairro;

    @Column(name = "ds_cidade", length = 50)
    private String cidade;

    @Column(name = "ds_uf", length = 2)
    private String uf;

    @Column(name = "nr_numero", length = 5)
    private int numero;


    @OneToOne(mappedBy = "endereco")
    private Usuario usuario;

    @OneToOne(mappedBy = "endereco")
    private Hotel hotel;

    public Endereco() {
    }


    public Endereco(String rua, String cep, String bairro, String cidade, String uf, int numero) {
        super();
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

}
