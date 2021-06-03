package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.reserva.dao.ReservaDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Calendar;

@Named
@ApplicationScoped
public class ReservaService {

    private ReservaDao dao = new ReservaDao();

    private int qtdReservas;

    private Calendar qtdDias;

    @PostConstruct
    public void init(String nomeHotel) {
        qtdReservas = dao.searchByName(nomeHotel);
    }


    public int getQtdReservas() {
        return qtdReservas;
    }

    public Calendar getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(Calendar qtdDias) {
        this.qtdDias = qtdDias;
    }

    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    }
}
