package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.hotel.dao.HotelDao;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.enums.Preco;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ApplicationScoped
public class HotelService {

    List<Hotel> hotels;

    @PostConstruct
    public void init() {
        hotels = new ArrayList<>();
        HotelDao dao = new HotelDao();

        hotels.add(new Hotel(1,"IBIS Styles São Paulo Anhembi","Av. Cruzeiro do Sul, 1709 - Santana, São Paulo - SP, 02031-000","https://www.revistahoteis.com.br/wp-content/uploads/2015/01/img1409843931.jpeg",355,"São Paulo",Preco.MEDIO,4));
        hotels.add(new Hotel(2,"Comfort Ibirapuera","Av. Sabiá, 825 - Indianópolis, São Paulo - SP, 04515-001","https://cf.bstatic.com/images/hotel/max1280x900/202/202261960.jpg",214,"São Paulo",Preco.MEDIO,3));
        hotels.add(new Hotel(3,"Blue Tree Premium Morumbi","Av. Roque Petroni Júnior, 1000 - Vila Gertrudes, São Paulo - SP, 04707-000","https://media-cdn.tripadvisor.com/media/photo-s/05/68/77/3c/hotel-blue-tree-towers.jpg",592,"São Paulo",Preco.ALTO,4));

//        dao.save(new Hotel(null,"IBIS Styles São Paulo Anhembi","Av. Cruzeiro do Sul, 1709 - Santana, São Paulo - SP, 02031-000","https://www.revistahoteis.com.br/wp-content/uploads/2015/01/img1409843931.jpeg",355,"São Paulo",Preco.MEDIO,4));
//        dao.save(new Hotel(null,"Comfort Ibirapuera","Av. Sabiá, 825 - Indianópolis, São Paulo - SP, 04515-001","https://cf.bstatic.com/images/hotel/max1280x900/202/202261960.jpg",214,"São Paulo",Preco.MEDIO,3));
//        dao.save(new Hotel(null,"Blue Tree Premium Morumbi","Av. Roque Petroni Júnior, 1000 - Vila Gertrudes, São Paulo - SP, 04707-000","https://media-cdn.tripadvisor.com/media/photo-s/05/68/77/3c/hotel-blue-tree-towers.jpg",592,"São Paulo",Preco.ALTO,4));
    }

    public List<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public List<Hotel> getHotels(int size) {

        if (size > hotels.size()) {
            Random rand = new Random();

            List<Hotel> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(hotels.size());
                randomList.add(hotels.get(randomIndex));
            }
            return randomList;
        }

        else {
            return new ArrayList<>(hotels.subList(0, size));
        }

    }

}
