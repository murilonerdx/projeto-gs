package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CarouselView implements Serializable {

    private List<Hotel> hotels;

    @Inject
    private HotelService service;

    @PostConstruct
    public void init() {
        try{
            this.hotels = service.getHotels(9);
        }catch(RuntimeException e){
            this.hotels = new ArrayList<>();
        }
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

}