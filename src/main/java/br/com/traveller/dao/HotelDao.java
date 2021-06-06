package br.com.traveller.dao;

import br.com.traveller.model.Hotel;
import br.com.traveller.model.RoomType;

public interface HotelDao extends Persisted<Hotel, Long> {

    /**
     * Count all instances find in database by {@link RoomType} and hotel name
     * 
     * @param name hotel name
     * @param type instance to find
     * @return Long count all instances
     */
    Long countAllByHotelNameAndRoomType(String name, RoomType type);
}
