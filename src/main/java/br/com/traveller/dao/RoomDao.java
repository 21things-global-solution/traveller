package br.com.traveller.dao;

import java.util.List;

import br.com.traveller.model.Room;

public interface RoomDao extends Persisted<Room, Long> {

    /**
     * Find all rooms with value less than informed
     * 
     * @param value max value to search
     * 
     * @return List<Room> all instances
     */
    List<Room> findByValueLessThan(Double value);
}
