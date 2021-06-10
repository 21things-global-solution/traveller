package br.com.traveller.model;

import java.io.Serializable;
import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_check_in")
    private Calendar checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_check_out")
    private Calendar checkOut;

    @Override
    public String toString() {
        return "Reservation [checkIn=" + checkIn + ", checkOut=" + checkOut + ", customer=" + customer + ", id=" + id
                + ", room=" + room + "]";
    }

    public Reservation(Calendar checkIn, Calendar checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reservation() {
    }

    public Reservation(Long id, Customer customer, Room room, Calendar checkIn, Calendar checkOut) {
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

    public Calendar getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Calendar checkIn) {
        this.checkIn = checkIn;
    }

    public Calendar getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Calendar checkOut) {
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
