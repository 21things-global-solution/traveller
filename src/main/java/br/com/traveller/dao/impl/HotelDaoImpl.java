package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.HotelDao;
import br.com.traveller.model.Hotel;
import br.com.traveller.model.RoomType;

public class HotelDaoImpl extends PersistedImpl<Hotel, Long> implements HotelDao {

    public HotelDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public Long countAllByHotelNameAndRoomType(String name, RoomType type) {
        return manager
                .createQuery("select COUNT(r) from Room r where r.hotel.name = :name and r.type = :type", Long.class)
                .setParameter("name", name)
                .setParameter("type", type)
                .getSingleResult();
    }

    @Override
    public boolean exists(Long id) {
        Hotel instance = findById(id);
        return instance != null;
    }

}
