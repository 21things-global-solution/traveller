package br.com.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.traveller.dao.PhoneDao;
import br.com.traveller.model.Phone;

public class PhoneDaoImpl extends PersistedImpl<Phone, Long> implements PhoneDao {

    public PhoneDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public List<Phone> findByCustomerNameContainingIgnoreCase(String name) {
        return manager
                .createQuery("from Phone p where LOWER(p.customer.name) LIKE CONCAT('%', :name, '%')", Phone.class)
                .setParameter("name", name.toLowerCase())
                .getResultList();
    }

}
