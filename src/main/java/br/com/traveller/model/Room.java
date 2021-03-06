package br.com.traveller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_QUARTO")
@SequenceGenerator(name = "room", allocationSize = 1, sequenceName = "SQ_GS_QUARTO")
public class Room implements Serializable {

    @Id
    @GeneratedValue(generator = "room", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_quarto")
    private Long id;

    @Column(name = "ds_quarto")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_quarto", length = 30)
    private RoomType type;

    @Column(name = "vl_quarto", length = 15)
    private Double value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_hotel", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "Room [description=" + description + ", hotel=" + hotel + ", id=" + id + ", type=" + type + ", value="
                + value + "]";
    }

    public void addReservation(Reservation reservation) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        reservation.setRoom(this);
        this.reservations.add(reservation);
    }

    public Room() {
    }

    public Room(Long id, String description, RoomType type, Double value, Hotel hotel) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.value = value;
        this.hotel = hotel;
    }

    public Room(String description, RoomType type, Double value, Hotel hotel) {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
