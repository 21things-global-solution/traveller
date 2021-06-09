package br.com.traveller.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.HotelDao;
import br.com.traveller.dao.impl.HotelDaoImpl;
import br.com.traveller.exception.TransactionException;
import br.com.traveller.model.Hotel;

@Path("hotels")
@Produces(MediaType.APPLICATION_JSON)
public class HotelEndpoint {

    private EntityManager manager = ConnectionFactory.getInstance().createEntityManager();

    private HotelDao dao = new HotelDaoImpl(manager);

    @GET
    public List<Hotel> index() {
        List<Hotel> hotels = dao.findAll();

        hotels.stream().forEach(hotel -> {
            hotel.setReservations(null);
            hotel.setAddress(null);
            hotel.setRooms(null);
        });

        return hotels;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response store(Hotel hotel) {
        if (hotel == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dao.create(hotel);
        try {
            dao.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Hotel hotel) {
        if (hotel == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        boolean exists = dao.exists(id);
        if (!exists) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        hotel.setId(id);
        dao.update(hotel);
        try {
            dao.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).build();
    }

}
