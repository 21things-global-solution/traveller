package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.ReservationDao;
import br.com.traveller.model.Reservation;

public class ReservationDaoImpl extends PersistedImpl<Reservation, Long> implements ReservationDao {

    public ReservationDaoImpl(EntityManager manager) {
        super(manager);
    }

}
