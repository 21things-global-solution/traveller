package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.StreetDao;
import br.com.traveller.model.Street;

public class StreetDaoImpl extends PersistedImpl<Street, Long> implements StreetDao {

    protected StreetDaoImpl(EntityManager manager) {
        super(manager);
    }

}
