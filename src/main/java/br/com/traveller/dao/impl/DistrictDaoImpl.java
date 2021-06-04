package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.DistrictDao;
import br.com.traveller.model.District;

public class DistrictDaoImpl extends PersistedImpl<District, Long> implements DistrictDao {

    protected DistrictDaoImpl(EntityManager manager) {
        super(manager);
    }

}
