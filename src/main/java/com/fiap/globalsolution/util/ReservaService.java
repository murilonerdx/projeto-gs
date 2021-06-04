package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.reserva.dao.ReservaDao;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.domain.usuario.dao.UsuarioDao;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;
import java.util.List;

@Named
@RequestScoped
public class ReservaService {

    private ReservaDao reservaDao = new ReservaDao();

    private int qtdReservas;


    @PostConstruct
    public void init(String nomeHotel) {
        qtdReservas = reservaDao.searchByName(nomeHotel);
    }

    public void saveReservaHotel(Reserva reserva){
        reservaDao.save(reserva);
    }

    public void deleteReserva(Integer id){
        reservaDao.delete(id);
    }

    public int getQtdReservas(String name) {
        return reservaDao.searchByName(name);
    }

    public List<Hotel> getMyReservas(String email){
        return reservaDao.getAllMyReservas(email);
    }

    public ReservaDao getReservaDao() {
        return reservaDao;
    }

    public void setReservaDao(ReservaDao reservaDao) {
        this.reservaDao = reservaDao;
    }

    public int getQtdReservas() {
        return qtdReservas;
    }

    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    }
}
