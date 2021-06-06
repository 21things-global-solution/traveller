package br.com.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.traveller.dao.RoomDao;
import br.com.traveller.model.Room;

public class RoomDaoImpl extends PersistedImpl<Room, Long> implements RoomDao {

    public RoomDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public List<Room> findByValueLessThan(Double value) {
        return manager
                .createQuery("from Room r where r.value < :value", Room.class)
                .setParameter("value", value)
                .getResultList();
    }

}
