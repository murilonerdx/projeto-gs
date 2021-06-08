package com.fiap.globalsolution.domain.reserva.dao;

import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.reserva.entity.Reserva;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;
import com.fiap.globalsolution.singleton.EntityManagerFacade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReservaDao {

    private EntityManager manager = EntityManagerFacade.getEntityManager();

    public void save(Reserva reserva) {
        manager.getTransaction().begin();
        manager.merge(reserva);
        manager.getTransaction().commit();
        manager.clear();
    }


    public List<Reserva> getAllMyReservas(Integer id) {
        String jpql = "SELECT s from Reserva s WHERE s.usuario.id = :id";
        TypedQuery<Reserva> query = manager.createQuery(jpql, Reserva.class).setParameter("id",id);
        return query.getResultList();
    }


    public Usuario findByEmail(String email){
        String jpql = "SELECT s FROM Usuario s WHERE s.email = :email";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class).setParameter("email",email);
        return query.getSingleResult();
    }

    public Reserva findById(Integer id){
        return manager.find(Reserva.class,id);
    }

    public void update(Reserva obj){
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.flush();
        manager.getTransaction().commit();
        manager.clear();
    }

    public void delete(Integer id){
        Reserva reserva = findById(id);
        manager.getTransaction().begin();
        manager.remove(reserva);
        manager.getTransaction().commit();
        manager.clear();
    }

    public int searchByName(String nomeHotel){
        String jpql = "SELECT COUNT(s) FROM Hotel s WHERE s.nome = :nomeHotel";
        TypedQuery<Long> q = manager.createQuery(jpql,Long.class).setParameter("nomeHotel",nomeHotel);
        Long total = q.getSingleResult();
        return Math.toIntExact(total);
    }

}
