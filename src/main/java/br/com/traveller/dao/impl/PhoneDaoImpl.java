package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.PhoneDao;
import br.com.traveller.model.Phone;

public class PhoneDaoImpl extends PersistedImpl<Phone, Long> implements PhoneDao {

    public PhoneDaoImpl(EntityManager manager) {
        super(manager);
    }

}
