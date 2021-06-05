package br.com.traveller.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

import br.com.traveller.dao.Persisted;
import br.com.traveller.exception.TransactionException;

public abstract class PersistedImpl<E, K> implements Persisted<E, K> {

    protected EntityManager manager;
    private Class<E> clazz;

    @SuppressWarnings("unchecked")
    public PersistedImpl(EntityManager manager) {
        this.manager = manager;
        this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(E entity) {
        manager.persist(entity);
    }

    @Override
    public void update(E entity) {
        manager.merge(entity);
    }

    @Override
    public E findById(K id) {
        return manager.find(clazz, id);
    }

    @Override
    public void delete(K id) throws EntityNotFoundException {
        E entity = findById(id);

        if (entity == null) {
            throw new EntityNotFoundException("Data not found for key: " + id);
        }

        manager.remove(entity);
    }

    @Override
    public void commit() throws TransactionException {
        EntityTransaction trx = null;
        try {
            trx = manager.getTransaction();
            trx.begin();
            trx.commit();
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            throw new TransactionException(e.getMessage());
        }
    }

    @Override
    public List<E> findAll() {
        return manager.createQuery("from " + clazz.getName(), clazz).getResultList();
    }
}