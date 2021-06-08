package com.fiap.globalsolution.util.services;

import com.fiap.globalsolution.domain.reserva.dao.ReservaDao;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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

    public void saveReserva(Reserva reserva){
        reservaDao.save(reserva);
    }

    public void updateReserva(Reserva reserva){
        reservaDao.update(reserva);
    }

    public Reserva findById(Integer id){
        return reservaDao.findById(id);
    }



    public void deleteReserva(Integer id){
        reservaDao.delete(id);
    }

    public int getQtdReservas(String name) {
        return reservaDao.searchByName(name);
    }

    public List<Reserva> getMyReservas(Integer id){
        return reservaDao.getAllMyReservas(id);
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
