package br.com.traveller.dao;

import java.util.List;

import br.com.traveller.model.Phone;

public interface PhoneDao extends Persisted<Phone, Long> {

    /**
     * Find all phone instances
     * 
     * @param name Customer name
     * 
     * @return List<Phone> all phone entities
     */
    List<Phone> findByCustomerNameContainingIgnoreCase(String name);
}
