package br.com.traveller.bean;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.HotelDao;
import br.com.traveller.dao.impl.HotelDaoImpl;
import br.com.traveller.model.Hotel;

@Named
public class HotelBean {

    private static final EntityManager manager = ConnectionFactory.getInstance().createEntityManager();

    private static final HotelDao dao = new HotelDaoImpl(manager);

    private Hotel hotel = new Hotel();

    public List<Hotel> getHotels() {
        return dao.findAll();
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
