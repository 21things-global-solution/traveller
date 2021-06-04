package br.com.traveller.dao;

import javax.persistence.EntityNotFoundException;

import br.com.traveller.exception.TransactionException;

public interface Persisted<E, K> {

    /**
     * Persist entity
     * 
     * @param entity Entity to persist
     */
    void create(E entity);

    /**
     * Update entity data previously stored
     * 
     * @param entity Entity to update
     */
    void update(E entity);

    /**
     * Search entity by key
     * 
     * @param id Search key
     * @return E instance of entity
     */
    E findById(K id);

    /**
     * Destroy entity data by key
     * 
     * @param id Search key
     * 
     * @throws EntityNotFoundException if entity data not found
     */
    void delete(K id) throws EntityNotFoundException;

    /**
     * Commit transaction
     * 
     * @throws TransactionException if any error occurs, rollback transaction and
     *                              show the given exception
     */
    void commit() throws TransactionException;
}
