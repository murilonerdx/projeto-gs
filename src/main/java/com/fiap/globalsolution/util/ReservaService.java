package com.fiap.globalsolution.util;

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

@Named
@RequestScoped
public class ReservaService {

    private UsuarioDao dao = new UsuarioDao();
    private ReservaDao reservaDao = new ReservaDao();

    private int qtdReservas;

    private Calendar qtdDias;

    @PostConstruct
    public void init(String nomeHotel) {
        qtdReservas = reservaDao.searchByName(nomeHotel);
    }

    public void saveReserva(Usuario reserva) {
        dao.save(reserva);
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
