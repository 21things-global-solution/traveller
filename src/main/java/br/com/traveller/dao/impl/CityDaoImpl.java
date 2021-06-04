package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.CityDao;
import br.com.traveller.model.City;

public class CityDaoImpl extends PersistedImpl<City, Long> implements CityDao {

    protected CityDaoImpl(EntityManager manager) {
        super(manager);
    }

}
