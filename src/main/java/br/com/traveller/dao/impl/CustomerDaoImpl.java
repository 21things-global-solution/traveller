package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.traveller.dao.CustomerDao;
import br.com.traveller.model.Customer;

public class CustomerDaoImpl extends PersistedImpl<Customer, Long> implements CustomerDao {

    public CustomerDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public Customer findByMailAndPassword(Customer customer) {
        TypedQuery<Customer> query = manager
                .createQuery("from Customer c where lower(c.mail) = :mail and c.password = :pass", Customer.class)
                .setParameter("mail", customer.getMail())
                .setParameter("pass", customer.getPassword());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
