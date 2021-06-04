package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.HotelDao;
import br.com.traveller.model.Hotel;

public class HotelDaoImpl extends PersistedImpl<Hotel, Long> implements HotelDao {

    protected HotelDaoImpl(EntityManager manager) {
        super(manager);
    }

}
