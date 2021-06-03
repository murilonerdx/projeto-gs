package com.fiap.globalsolution.domain.usuario.dao;

import com.fiap.globalsolution.singleton.EntityManagerFacade;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Named
@ApplicationScoped
public class UsuarioDao {

    private final EntityManager manager = EntityManagerFacade.getEntityManager();

    public void save(Usuario user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.clear();
    }

    public List<Usuario> getAll() {
        String jpql = "SELECT s FROM Usuario s";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        return query.getResultList();

    }

    public Usuario login(Usuario user) {
        try {
            TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE " +
                    "u.email = :email AND " +
                    "u.senha = :password", Usuario.class)
                    .setParameter("email", user.getEmail())
                    .setParameter("password", user.getSenha());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public List<Usuario> getAllSetup(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();

        Usuario user = (Usuario) sessionMap.get("seller");
        String emailAtual = user.getEmail();

        TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                .setParameter("email",emailAtual);
        return query.getResultList();
    }

    public Usuario findUsuario(String email){
        try {
            TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email like :email", Usuario.class)
                    .setParameter("email",email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}