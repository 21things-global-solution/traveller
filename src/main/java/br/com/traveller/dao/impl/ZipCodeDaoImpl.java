package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.ZipCodeDao;
import br.com.traveller.model.ZipCode;

public class ZipCodeDaoImpl extends PersistedImpl<ZipCode, Long> implements ZipCodeDao {

    protected ZipCodeDaoImpl(EntityManager manager) {
        super(manager);
    }

}
