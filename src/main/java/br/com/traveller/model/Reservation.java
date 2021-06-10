package br.com.traveller.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_GS_RESERVA")
@SequenceGenerator(name = "reservation", allocationSize = 1, sequenceName = "SQ_GS_RESERVA")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(generator = "reservation", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_reserva")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cliente", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_quarto", nullable = false)
    private Room room;

    @CreationTimestamp
    @Column(name = "dt_check_in")
    private LocalDate checkIn;

    @Column(name = "dt_check_out")
    private LocalDate checkOut;

    @Override
    public String toString() {
        return "Reservation [checkIn=" + checkIn + ", checkOut=" + checkOut + ", customer=" + customer + ", id=" + id
                + ", room=" + room + "]";
    }

    public Reservation(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reservation() {
    }

    public Reservation(Long id, Customer customer, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
