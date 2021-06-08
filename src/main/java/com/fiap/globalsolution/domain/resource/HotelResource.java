package com.fiap.globalsolution.domain.resource;

import com.fiap.globalsolution.domain.hotel.dao.HotelDao;
import com.fiap.globalsolution.domain.hotel.dto.HotelDTO;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hotels")
public class HotelResource {

    @Inject
    private HotelDao dao;

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Hotel> lista = dao.getAll();
//        List<HotelDTO> listaDTO = dao.updateData(lista);
        return Response.ok(lista).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Path("/{id}")
    public Hotel findById(@PathParam("id") Integer id) {
        return dao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Hotel setup) {
        if (setup == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dao.save(setup);
        return Response.status(Response.Status.CREATED).entity(setup).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Hotel setup) {
        if (setup == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        setup.setId(id);
        dao.update(setup);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dao.delete(id);
        return Response.status(Response.Status.ACCEPTED).build();
    }




}