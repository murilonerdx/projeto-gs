package com.fiap.globalsolution.domain.hotel.resource;

import com.fiap.globalsolution.domain.hotel.dao.HotelDao;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hotels")
public class HotelResource {
    private HotelDao dao = new HotelDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> getAll() {
        return dao.getAll();
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