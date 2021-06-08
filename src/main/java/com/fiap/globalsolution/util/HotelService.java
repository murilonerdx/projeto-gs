package com.fiap.globalsolution.util;

import com.fiap.globalsolution.domain.dica.entity.Dica;
import com.fiap.globalsolution.domain.endereco.entity.Endereco;
import com.fiap.globalsolution.domain.enums.Idioma;
import com.fiap.globalsolution.domain.hotel.dao.HotelDao;
import com.fiap.globalsolution.domain.enums.Preco;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;

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
        //Adicionar todos os hotels, verificar se já existe algum hotel, caso não exista ele executar o script de adicionar hotel, caso exista, ele vai fazer um get all no banco com os hotels
        hotels = new ArrayList<>();

        //IBIS Styles São Paulo Anhembi
        //"Av. Cruzeiro do Sul, 1709 - Santana, São Paulo - SP, 02031-000"
        Endereco enderecoIbis = new Endereco("Av. Cruzeiro do Sul","02031-000","Santana","São Paulo","SP",1709);
        Dica dicaEnderecoIbis = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Comfort Ibirapuera
        //"Av. Sabiá, 825 - Indianópolis, São Paulo - SP, 04515-001"
        Endereco enderecoComfort = new Endereco("Av. Sabiá","04515-001","Indianópolis","São Paulo","SP",825);
        Dica dicaEnderecoComfort = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Blue Tree Premium Morumbi
        //"Av. Roque Petroni Júnior, 1000 - Vila Gertrudes, São Paulo - SP, 04707-000"
        Endereco enderecoBlueTreePremiumMorumbi = new Endereco("Av. Roque Petroni Júnior","04707-000","Vila Gertrudes","São Paulo","SP",1000);
        Dica dicaEnderecoBlueTreePremiumMorumbi = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Mercure São Paulo Pamplona
        //"R. Pamplona, 1315 - Jardim Paulista, São Paulo - SP, 01405-002"
        Endereco enderecoMercure = new Endereco("R. Pamplona","01405-002","Jardim Paulista","São Paulo","SP",1315);
        Dica dicaEnderecoMercure = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Sheraton São Paulo WTC Hotel
        //"Av. das Nações Unidas, 12559 - Brooklin Novo, São Paulo - SP, 04578-903"
        Endereco enderecoSheraton = new Endereco("Av. das Nações Unidas","","Brooklin Novo","São Paulo","SP",12559);
        Dica dicaEnderecoSheraton = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Bourbon Convention Ibirapuera
        //"Av. Ibirapuera, 2927 - Ibirapuera, São Paulo - SP, 04029-200"
        Endereco enderecoBourbon = new Endereco("Av. Ibirapuera","04029-200","Ibirapuera","São Paulo","SP",2927);
        Dica dicaEnderecoBourbon = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Blue Tree Premium Paulista
        //"Rua Peixoto Gomide, 707 - Bela Vista, São Paulo - SP, 01409-001"
        Endereco enderecoBlueTreePremiumPaulista = new Endereco("Rua Peixoto Gomide","01409-001","Bela Vista","São Paulo","SP",707);
        Dica dicaEnderecoBlueTreePremiumPaulista = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");



        //Golden Tulip Paulista Plaza
        //"Alameda Santos, 85 - Jardins, São Paulo - SP, 01419-000"
        Endereco enderecoGolden = new Endereco("Alameda Santos","01419-000","Jardins","São Paulo","SP",85);
        Dica dicaEnderecoGolden = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        //Renaissance São Paulo Hotel
        //"Alameda Santos, 2233 - Jardim Paulista, São Paulo - SP, 01419-002"
        Endereco enderecoRenaissance = new Endereco("Alameda Santos","01419-002","Jardim Paulista","","SP",2233);
        Dica dicaEnderecoRenaissance = new Dica("Quando quiser",25.00, Idioma.PORTUGUES,"","","","","");

        hotels.add(new Hotel("IBIS Styles São Paulo Anhembi",enderecoIbis,"https://www.revistahoteis.com.br/wp-content/uploads/2015/01/img1409843931.jpeg",355.00,4,"https://all.accor.com/hotel/9596/index.pt-br.shtml","Embarque, literalmente, em uma experiência diferenciada, confortável e com ótima relação custo-benefício no ibis Styles São Paulo Anhembi. Com design moderno e decoração inspirada no tema aviação, o hotel oferece quartos com camas Sweet Bed by Ibis, Wi-Fi grátis e um delicioso café da manhã servido diariamente.",dicaEnderecoIbis));
        hotels.add(new Hotel("Comfort Ibirapuera",enderecoComfort,"https://cf.bstatic.com/images/hotel/max1024x768/202/202264542.jpg",214.00,3,"https://www.atlanticahotels.com.br/hotel/comfort-ibirapuera/","O Comfort Ibirapuera está localizado na Av. Sabiá, esquina com a Av. Ibirapuera, em frente à Igreja de Moema. Além de estar em um centro de compras e lazer, o Comfort Ibirapuera tem fácil acesso para as principais vias da cidade, ao Aeroporto de Congonhas, Centro de Convenções Imigrantes e ao Parque do Ibirapuera.",dicaEnderecoComfort));
        hotels.add(new Hotel("Blue Tree Premium Morumbi",enderecoBlueTreePremiumMorumbi,"https://media-cdn.tripadvisor.com/media/photo-s/05/68/77/3c/hotel-blue-tree-towers.jpg",592.00,4,"https://www.bluetree.com.br/hotel/blue-tree-premium-morumbi/","O hotel Blue Tree Premium Morumbi está localizado em frente ao Shopping Morumbi e próximo aos grandes centros empresariais da região da Berrini. ... O hotel fornece serviço de quarto 24 horas, e há disponibilidade Wi-Fi.",dicaEnderecoBlueTreePremiumMorumbi));
        hotels.add(new Hotel("Mercure São Paulo Pamplona",enderecoMercure,"https://content.r9cdn.net/rimg/himg/bc/ff/95/leonardo-1123814-6284_ho_05_p_3000x2250_O-962980.jpg?width=1004&height=500&xhint=1500&yhint=1125&crop=true",502.00,4,"https://all.accor.com/hotel/6284/index.pt-br.shtml","O hotel Mercure São Paulo Pamplona está cercado de ótimas opções de lazer, cultural e boêmio. Além de ser um hotel perto da Paulista, a Rua Augusta está a 3 km de carro, com uma agitada vida noturna. ",dicaEnderecoMercure));
        hotels.add(new Hotel("Sheraton São Paulo WTC Hotel",enderecoSheraton,"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/itemimages/10/49/104958_v3.jpeg",1365.00,4,"https://www.tripadvisor.com.br/Hotel_Review-g303631-d306521-Reviews-Sheraton_Sao_Paulo_WTC_Hotel-Sao_Paulo_State_of_Sao_Paulo.html","Localizado no coração da região da Berrini, onde você pode encontrar sedes de grandes corporações e uma ampla variedade de entretenimento, restaurantes e compras.",dicaEnderecoSheraton));
        hotels.add(new Hotel("Bourbon Convention Ibirapuera",enderecoBourbon,"https://www.guiadoturismobrasil.com/up/img/1470862785.jpg",592.00,4,"https://www.bourbon.com.br/hotel/bourbon-convention-ibirapuera-hotel/","O Bourbon Ibirapuera Convention Hotel é referência em convenções e eventos, com capacidade para receber até 1.100 pessoas simultaneamente, possui modernos equipamentos audiovisuais e equipe especializada para tornar o seu evento memorável.",dicaEnderecoBourbon));
        hotels.add(new Hotel("Blue Tree Premium Paulista",enderecoBlueTreePremiumPaulista,"https://cf.bstatic.com/images/hotel/max1024x768/198/198280352.jpg",534.00,4,"https://www.bluetree.com.br/hotel/blue-tree-premium-paulista/","Localizado a uma quadra da Av. Paulista, o Blue Tree Premium Paulista Hotel está no coração de São Paulo tem endereço privilegiado: está cercado de teatros, museus, shoppings, bares, restaurantes e da elegante Rua Oscar Freire. ",dicaEnderecoBlueTreePremiumPaulista));
        hotels.add(new Hotel("Golden Tulip Paulista Plaza",enderecoGolden,"https://lh3.googleusercontent.com/proxy/irkYtlIsFYpRc-_WcdVcW-YCiBkWC2E_YPpqqiAqhjL5dYYRZnG67Xl-22OtpGQz4cPFylQDX52Xkaahh4HLo5vdkLQNGGzQYncPmyHzKlWeuFCF0pEwmMYqgpIBsXn9s4sRuGSe2-mQiPxHpnMviMXA2380978Img",273.00,4,"https://www.tripadvisor.com.br/LocationPhotoDirectLink-g303631-d301508-i280141509-Radisson_Paulista-Sao_Paulo_State_of_Sao_Paulo.html","O Golden Tulip Paulista Plaza com a sua arquitetura moderna e cosmopolita. ",dicaEnderecoGolden));
        hotels.add(new Hotel("Renaissance São Paulo Hotel",enderecoRenaissance,"https://thumbcdn-0.hotelurbano.net/kTxbFMzxL5B-wI1yLpDBjmlMNfo=/trim:bottom-right:80/fit-in/625x0/bottom/filters:quality(30)/https%3A//novo-hu.s3.amazonaws.com/reservas/ota/prod/hotel/2059/001-fachada-renaissance-sao-paulo-001_20200108150214.jpg",1910.00,5,"https://www.marriott.com.br/hotels/travel/saobr-renaissance-sao-paulo-hotel/","Com ótima localização em São Paulo (na área de Jardins).",dicaEnderecoRenaissance));
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
