package com.fiap.globalsolution.domain.hotel.dao;

import com.fiap.globalsolution.singleton.EntityManagerFacade;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HotelDao {
    private EntityManager manager = EntityManagerFacade.getEntityManager();

    public void save(Hotel hotel) {
        manager.getTransaction().begin();
        manager.persist(hotel);
        manager.getTransaction().commit();
        manager.clear();
    }

    public List<Hotel> getAll() {
        String jpql = "SELECT s FROM Hotel s";
        TypedQuery<Hotel> query = manager.createQuery(jpql, Hotel.class);
        return query.getResultList();

    }

    public Hotel findById(Integer id){
        return manager.find(Hotel.class,id);
    }

    public void update(Hotel obj){
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.flush();
        manager.getTransaction().commit();
        manager.clear();
    }

    public void delete(Integer id){
        Hotel obj = findById(id);
        manager.getTransaction().begin();
        manager.remove(obj);
        manager.getTransaction().commit();
        manager.clear();
    }

}
