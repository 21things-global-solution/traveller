package br.com.traveller.dao;

import java.util.List;

import br.com.traveller.model.Customer;
import br.com.traveller.model.Reservation;

public interface ReservationDao extends Persisted<Reservation, Long> {

    /**
     * Find all reservations by customer
     * 
     * @param customer Customer instance
     * 
     * @return List<Reservation> all reservations
     */
    List<Reservation> findAllByCustomer(Customer customer);
}
