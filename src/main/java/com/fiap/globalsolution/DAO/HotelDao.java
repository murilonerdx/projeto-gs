package com.fiap.globalsolution.DAO;

import com.fiap.globalsolution.entities.Hotel;
import com.fiap.globalsolution.entities.Usuario;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

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


    public List<Hotel> getAllSetup() {
        TypedQuery<Hotel> query = manager.createQuery("SELECT u FROM Hotel", Hotel.class);
        return query.getResultList();
    }

}
