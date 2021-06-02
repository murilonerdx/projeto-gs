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

        hotels.add(new Hotel(1,"IBIS Styles São Paulo Anhembi","Av. Cruzeiro do Sul, 1709 - Santana, São Paulo - SP, 02031-000","https://www.revistahoteis.com.br/wp-content/uploads/2015/01/img1409843931.jpeg",355,"São Paulo",Preco.MEDIO,4,"https://all.accor.com/hotel/9596/index.pt-br.shtml"));
        hotels.add(new Hotel(2,"Comfort Ibirapuera","Av. Sabiá, 825 - Indianópolis, São Paulo - SP, 04515-001","https://cf.bstatic.com/images/hotel/max1024x768/202/202264542.jpg",214,"São Paulo",Preco.MEDIO,3,"https://www.atlanticahotels.com.br/hotel/comfort-ibirapuera/"));
        hotels.add(new Hotel(3,"Blue Tree Premium Morumbi","Av. Roque Petroni Júnior, 1000 - Vila Gertrudes, São Paulo - SP, 04707-000","https://media-cdn.tripadvisor.com/media/photo-s/05/68/77/3c/hotel-blue-tree-towers.jpg",592,"São Paulo",Preco.ALTO,4,"https://www.bluetree.com.br/hotel/blue-tree-premium-morumbi/"));
        hotels.add(new Hotel(4,"Mercure São Paulo Pamplona","R. Pamplona, 1315 - Jardim Paulista, São Paulo - SP, 01405-002","https://content.r9cdn.net/rimg/himg/bc/ff/95/leonardo-1123814-6284_ho_05_p_3000x2250_O-962980.jpg?width=1004&height=500&xhint=1500&yhint=1125&crop=true",502,"São Paulo",Preco.ALTO,4,"https://all.accor.com/hotel/6284/index.pt-br.shtml"));
        hotels.add(new Hotel(5,"Sheraton São Paulo WTC Hotel","Av. das Nações Unidas, 12559 - Brooklin Novo, São Paulo - SP, 04578-903","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/itemimages/10/49/104958_v3.jpeg",1365,"São Paulo",Preco.ALTO,4,"https://www.tripadvisor.com.br/Hotel_Review-g303631-d306521-Reviews-Sheraton_Sao_Paulo_WTC_Hotel-Sao_Paulo_State_of_Sao_Paulo.html"));
        hotels.add(new Hotel(6,"Bourbon Convention Ibirapuera","Av. Ibirapuera, 2927 - Ibirapuera, São Paulo - SP, 04029-200","https://www.guiadoturismobrasil.com/up/img/1470862785.jpg",592,"São Paulo",Preco.ALTO,4,"https://www.bourbon.com.br/hotel/bourbon-convention-ibirapuera-hotel/"));
        hotels.add(new Hotel(7,"Blue Tree Premium Paulista","Rua Peixoto Gomide, 707 - Bela Vista, São Paulo - SP, 01409-001","https://cf.bstatic.com/images/hotel/max1024x768/198/198280352.jpg",534,"São Paulo",Preco.ALTO,4,"https://www.bluetree.com.br/hotel/blue-tree-premium-paulista/"));
        hotels.add(new Hotel(8,"Golden Tulip Paulista Plaza","Alameda Santos, 85 - Jardins, São Paulo - SP, 01419-000","https://lh3.googleusercontent.com/proxy/MwSf8REHrsgg_4ziDdBi_d6JJPUqVGId9s_TLmYiXsLLxwfmuyL30Cvn81uTM--_afBnRfXqYMhXcHitanMpaTR-QrqLx7r7BEBYvSApGKgpPCGtamSUfA13gju6QMzYBrrQL9Qn0p8bK6BntIyqnnAqFBdJVl_e4w",273,"São Paulo",Preco.MEDIO,4,"https://www.tripadvisor.com.br/LocationPhotoDirectLink-g303631-d301508-i280141509-Radisson_Paulista-Sao_Paulo_State_of_Sao_Paulo.html"));
        hotels.add(new Hotel(9,"Renaissance São Paulo Hotel","Alameda Santos, 2233 - Jardim Paulista, São Paulo - SP, 01419-002","https://thumbcdn-0.hotelurbano.net/kTxbFMzxL5B-wI1yLpDBjmlMNfo=/trim:bottom-right:80/fit-in/625x0/bottom/filters:quality(30)/https%3A//novo-hu.s3.amazonaws.com/reservas/ota/prod/hotel/2059/001-fachada-renaissance-sao-paulo-001_20200108150214.jpg",1910,"São Paulo",Preco.ALTO,5,"https://www.marriott.com.br/hotels/travel/saobr-renaissance-sao-paulo-hotel/"));
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
