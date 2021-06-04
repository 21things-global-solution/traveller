package br.com.traveller.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_QUARTO")
@SequenceGenerator(name = "room", allocationSize = 1, sequenceName = "SQ_GS_QUARTO")
public class Room {

    @Id
    @GeneratedValue(generator = "room", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_quarto")
    private Long id;

    @Column(name = "ds_quarto")
    private String description;

    @Column(name = "tp_quarto", length = 30)
    private RoomType type;

    @Column(name = "vl_quarto", length = 15, precision = 2)
    private BigDecimal value;

    @JoinColumn(name = "cd_hotel", nullable = false)
    private Hotel hotel;

    @Override
    public String toString() {
        return "Room [description=" + description + ", hotel=" + hotel + ", id=" + id + ", type=" + type + ", value="
                + value + "]";
    }

    public Room() {
    }

    public Room(Long id, String description, RoomType type, BigDecimal value, Hotel hotel) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.value = value;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
