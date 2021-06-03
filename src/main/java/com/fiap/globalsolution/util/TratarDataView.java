package com.fiap.globalsolution.util;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Named
@RequestScoped
public class TratarDataView {

    private String dataInicial;
    private String dataFinal;

    private int quantidadeDias;

    @PostConstruct
    public void init() throws ParseException {
        System.out.println(dataInicial + " " + dataFinal);
    }
    public int tratarDias() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String newDataInicial = sdf.format(dataInicial);
        String newDataFinal = sdf.format(dataFinal);

        Calendar dataInicialConvertida = Calendar.getInstance();
        dataInicialConvertida.setTime(sdf.parse(newDataInicial));

        Calendar dataFinalConvertida = Calendar.getInstance();
        dataFinalConvertida.setTime(sdf.parse(newDataFinal));
        return quantidadeDias = dataFinalConvertida.get(Calendar.DAY_OF_MONTH -2) - dataInicialConvertida.get(Calendar.DAY_OF_MONTH -2);
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }
}
