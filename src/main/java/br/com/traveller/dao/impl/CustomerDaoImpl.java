package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.CustomerDao;
import br.com.traveller.model.Customer;

public class CustomerDaoImpl extends PersistedImpl<Customer, Long> implements CustomerDao {

    public CustomerDaoImpl(EntityManager manager) {
        super(manager);
    }

}
