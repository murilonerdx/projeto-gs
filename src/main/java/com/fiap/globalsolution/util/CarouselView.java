package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CarouselView implements Serializable {

    private List<Hotel> hotels;


    @Inject
    private HotelService service;

    @PostConstruct
    public void init() {
        this.hotels = service.getHotels(9);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

}