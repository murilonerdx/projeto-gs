package com.fiap.globalsolution.domain.usuario.bean;

import com.fiap.globalsolution.domain.usuario.dao.UsuarioDao;
import com.fiap.globalsolution.domain.usuario.entity.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class UsuarioBean {

    private Usuario user = new Usuario();

    public void save() {
        UsuarioDao dao = new UsuarioDao();
        Usuario sellerBanco = dao.findUsuario(this.user.getEmail());
        if (sellerBanco == null) {
            new UsuarioDao().save(this.user);
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Usuario registrado"));
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error when registering, email already exists", "Error when registering"));
        }


    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario logged = new UsuarioDao().login(this.user);
        if (logged != null) {
            context.getExternalContext().getSessionMap().put("usuario", logged);
            return "index?faces-redirect=true";
        }
        context.getExternalContext()
                .getFlash().setKeepMessages(true);
        context
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login invalido", "Erro"));
        return "login?faces-redirect=true";
    }

    public String logout() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.remove("usuario");
        return "login?faces-redirect=true";
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
