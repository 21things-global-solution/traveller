package br.com.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.traveller.dao.AddressDao;
import br.com.traveller.model.Address;

public class AddressDaoImpl extends PersistedImpl<Address, Long> implements AddressDao {

    public AddressDaoImpl(EntityManager manager) {
        super(manager);
    }

}
