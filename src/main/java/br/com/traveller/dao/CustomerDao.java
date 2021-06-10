package br.com.traveller.dao;

import br.com.traveller.model.Customer;

public interface CustomerDao extends Persisted<Customer, Long> {

    /**
     * Find customer data by mail and password
     * 
     * @param customer Customer instance with mail and password
     * 
     * @return Customer Customer data
     */
    Customer findByMailAndPassword(Customer customer);
}
