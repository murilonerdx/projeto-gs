package com.fiap.globalsolution.domain.reserva.dao;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.singleton.EntityManagerFacade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReservaDao {

    private final EntityManager manager = EntityManagerFacade.getEntityManager();

    public void save(Reserva hotel) {
        manager.getTransaction().begin();
        manager.persist(hotel);
        manager.getTransaction().commit();
        manager.clear();
    }

    public List<Reserva> getAll() {
        String jpql = "SELECT s FROM Reserva s";
        TypedQuery<Reserva> query = manager.createQuery(jpql, Reserva.class);
        return query.getResultList();

    }

    public Reserva findById(Integer id){
        return manager.find(Reserva.class,id);
    }

    public void update(Hotel obj){
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.flush();
        manager.getTransaction().commit();
        manager.clear();
    }

    public void delete(Integer id){
        Reserva obj = findById(id);
        manager.getTransaction().begin();
        manager.remove(obj);
        manager.getTransaction().commit();
        manager.clear();
    }

    public int searchByName(String nomeHotel){
        String jpql = "SELECT COUNT(s) FROM Hotel s WHERE s.name = :nomeHotel";
        TypedQuery<Hotel> query = manager.createQuery(jpql, Hotel.class).setParameter("nomeHotel",nomeHotel);
        return query.getSingleResult() != null ? Integer.parseInt(query.getSingleResult().toString()) : 0;
    }
}
