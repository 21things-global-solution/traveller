package br.com.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.traveller.dao.ReservationDao;
import br.com.traveller.model.Customer;
import br.com.traveller.model.Reservation;

public class ReservationDaoImpl extends PersistedImpl<Reservation, Long> implements ReservationDao {

    public ReservationDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public List<Reservation> findAllByCustomer(Customer customer) {
        return manager
                .createQuery("from Reservation r where r.customer = :customer", Reservation.class)
                .setParameter("customer", customer)
                .getResultList();
    }

}
