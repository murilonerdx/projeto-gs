package com.fiap.globalsolution.domain.reserva.bean;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.reserva.dao.ReservaDao;
import com.fiap.globalsolution.util.ReservaService;
import org.hibernate.service.spi.InjectService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "reservaUsuario")
@RequestScoped
public class ReservaBean {

    private Hotel hotel;

    private int qtdTotal;

    private String linkApi;

    @Inject
    private ReservaService service;

    @PostConstruct
    public void init(){
        hotel = (Hotel) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("hotel");
        qtdTotal = service.getQtdReservas();
        linkApi = apiLink();
    }

    public String apiLink(){
        List<String> localizacaoPartes = Arrays.asList(hotel.getLocalization().split(","));
        String primeiraParte = localizacaoPartes.get(0).replace(" ", "+");
        String segundaParte = "2C" + localizacaoPartes.get(1) + "%2C+";
        String terceiraParte = localizacaoPartes.get(2) + "%2C+";
        String quartaParte = localizacaoPartes.get(3);
        return primeiraParte.concat(segundaParte).concat(terceiraParte).concat(quartaParte);
    }

    public String getLinkApi() {
        return linkApi;
    }

    public void setLinkApi(String linkApi) {
        this.linkApi = linkApi;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
