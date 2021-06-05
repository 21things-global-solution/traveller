package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.RoomDao;
import br.com.traveller.model.Room;

public class RoomDaoImpl extends PersistedImpl<Room, Long> implements RoomDao {

    public RoomDaoImpl(EntityManager manager) {
        super(manager);
    }

}
