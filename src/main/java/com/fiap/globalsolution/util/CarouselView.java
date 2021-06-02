package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CarouselView implements Serializable {

    private List<Hotel> hotels;

    private Hotel selectedHotel;

    @Inject
    private HotelService service;

    @PostConstruct
    public void init() {
        hotels = service.getHotels();
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setService(HotelService service) {
        this.service = service;
    }

    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    public void setSelectedProduct(Hotel selectedProduct) {
        this.selectedHotel = selectedProduct;
    }
}
