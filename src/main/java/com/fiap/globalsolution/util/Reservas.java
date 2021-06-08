package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import com.fiap.globalsolution.util.services.ReservaService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
        FacesContext.getCurrentInstance().getExternalContext().getFlash().clear();
        listaReservas = service.getMyReservas(user.getId());
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void deletarReserva(Integer id) {
        try{
            service.deleteReserva(id);
            init();
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }

    public String editarReserva(Integer id){
        return "/hotel-reserva-editar?faces-redirect=true&id=" + id;
    }
}
