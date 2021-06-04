package com.fiap.globalsolution.domain.hotel.bean;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import com.fiap.globalsolution.util.ReservaService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "hotelBean")
@RequestScoped
public class HotelBean {

    @Inject
    private ReservaService service;

    List<Hotel> listaReservas;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        Usuario user = (Usuario) sessionMap.get("usuario");
        listaReservas = service.getMyReservas(user.getEmail());

    }

    public void deletarReserva(Integer id){
        service.deleteReserva(id);
        init();
    }

    public ReservaService getService() {
        return service;
    }

    public void setService(ReservaService service) {
        this.service = service;
    }

    public List<Hotel> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Hotel> listaReservas) {
        this.listaReservas = listaReservas;
    }


}
