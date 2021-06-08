package com.fiap.globalsolution.domain.reserva.bean;

import com.fiap.globalsolution.domain.endereco.entity.Endereco;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import com.fiap.globalsolution.util.DataUtil;
import com.fiap.globalsolution.util.ReservaService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean(name = "reservaBean")
@ViewScoped
public class ReservaBean {

    private Date dataInicial;
    private Date dataFinal;

    @Inject
    private Usuario usuario;
    @Inject
    private Reserva reserva;

    private List<Date> invalidDates;

    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date minTime;
    private Date maxTime;
    private Date minDateTime;
    private Date maxDateTime;

    List<Reserva> reservas;

    private Date dateDe;
    private Date dateTimeDe;

    private int qtdDias;

    private double precoTotal;

    private String enderecoCompleto;

    private Reserva novaReserva;

    private Hotel hotel;


    private int qtdTotal;

    private String linkApi;

    @Inject
    private ReservaService service;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        usuario = (Usuario) sessionMap.get("usuario");
        hotel = (Hotel) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("hotel");
        qtdTotal = service.getQtdReservas(hotel.getNome());
        linkApi = apiLink();
    }

    public String apiLink() {
        try {
            //Av. Cruzeiro+do+Sul%2C+1709+-+Santana%2C+S%C3%A3o+Paulo+-+SP%2C+02031-000
            enderecoCompleto = "Rua: " + hotel.getEndereco().getRua() + ", " + hotel.getEndereco().getNumero() + " - " + hotel.getEndereco().getBairro() + ", " + hotel.getEndereco().getCidade() + " - " + hotel.getEndereco().getCep();
            return hotel.getEndereco().getRua().replace(" ", "+") + "%2C" + hotel.getEndereco().getNumero() + "+-+" + hotel.getEndereco().getBairro() + "%2C+" + hotel.getEndereco().getCidade() + "+-+%2C+" + hotel.getEndereco().getCep();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String editarReserva() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        String dataInicial1 = sdf.format(dataInicial.getTime());
        String dataFinal1 = sdf.format(dataFinal.getTime());

        Calendar dt1 = Calendar.getInstance();
        Calendar dt2 = Calendar.getInstance();

        dt1.setTime(sdf.parse(dataInicial1));
        dt2.setTime(sdf.parse(dataFinal1));

        dt1.add(Calendar.DAY_OF_MONTH, 1);
        dt2.add(Calendar.DAY_OF_MONTH, 1);


        precoTotal = DataUtil.calculaDias(dt1, dt2, hotel.getPreco());

        if (getPrecoTotal() < 0) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Digite uma data valida", "Error when registering"));
        } else {
            //TODO: Fazer modificação para pegar id da reserva
            reserva.setEntrada(dt1);
            reserva.setSaida(dt2);
            reserva.setPrecoTotal(precoTotal);
            service.updateReserva(reserva);
            return "minha-reserva?faces-redirect=true";
        }
        return null;

    }

    public String salvarReserva() throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        String dataInicial1 = sdf.format(dataInicial.getTime());
        String dataFinal1 = sdf.format(dataFinal.getTime());

        Calendar dt1 = Calendar.getInstance();
        Calendar dt2 = Calendar.getInstance();

        dt1.setTime(sdf.parse(dataInicial1));
        dt2.setTime(sdf.parse(dataFinal1));

        dt1.add(Calendar.DAY_OF_MONTH, 1);
        dt2.add(Calendar.DAY_OF_MONTH, 1);


        precoTotal = DataUtil.calculaDias(dt1, dt2, hotel.getPreco());

        if (getPrecoTotal() < 0) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Digite uma data valida", "Error when registering"));
        } else {


            reserva.setEntrada(dt1);
            reserva.setSaida(dt2);
            reserva.setPrecoTotal(precoTotal);
            reserva.setHotel(hotel);
            reserva.setUsuario(usuario);
            hotel.getReservas().add(reserva);
            usuario.getReserva().add(reserva);
            service.saveReserva(reserva);

            return "minha-reserva?faces-redirect=true";
        }
        return null;

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

    public Reserva getNovaReserva() {
        return novaReserva;
    }

    public void setNovaReserva(Reserva novaReserva) {
        this.novaReserva = novaReserva;
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

    public Date getDataInicial() throws ParseException {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) throws ParseException {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(Date dataFinal) throws ParseException {
        this.dataFinal = dataFinal;
    }

    public Date getDataFinal() throws ParseException {
        return dataFinal;
    }


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Date> getInvalidDates() {
        return invalidDates;
    }

    public void setInvalidDates(List<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public List<Integer> getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(List<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public Date getMinDateTime() {
        return minDateTime;
    }

    public void setMinDateTime(Date minDateTime) {
        this.minDateTime = minDateTime;
    }

    public Date getMaxDateTime() {
        return maxDateTime;
    }

    public void setMaxDateTime(Date maxDateTime) {
        this.maxDateTime = maxDateTime;
    }

    public Date getDateDe() {
        return dateDe;
    }

    public void setDateDe(Date dateDe) {
        this.dateDe = dateDe;
    }

    public Date getDateTimeDe() {
        return dateTimeDe;
    }

    public void setDateTimeDe(Date dateTimeDe) {
        this.dateTimeDe = dateTimeDe;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public ReservaService getService() {
        return service;
    }

    public void setService(ReservaService service) {
        this.service = service;
    }
}
