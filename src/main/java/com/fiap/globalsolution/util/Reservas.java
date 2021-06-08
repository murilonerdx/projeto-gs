package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "reservaLista")
@RequestScoped
public class Reservas {

    @Inject
    private ReservaService service;

    private List<Reserva> listaReservas;


    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        Usuario user = (Usuario) sessionMap.get("usuario");
        listaReservas = service.getMyReservas(user.getId());
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void deletarReserva(Integer id) {
        service.deleteReserva(id);
        init();
    }
}
