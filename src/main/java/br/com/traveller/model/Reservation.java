package br.com.traveller.model;

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
public class Reservation {

    @Id
    @GeneratedValue(generator = "reservation", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_reserva")
    private Long id;

    @Column(name = "nr_dias", length = 3, nullable = false)
    private Integer days;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cliente", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_hotel", nullable = false)
    private Hotel hotel;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_check_in")
    private Calendar checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_check_out")
    private Calendar checkOut;

    @Override
    public String toString() {
        return "Reservation [checkIn=" + checkIn + ", checkOut=" + checkOut + ", customer=" + customer + ", days="
                + days + ", hotel=" + hotel + ", id=" + id + "]";
    }

    public Reservation() {
    }

    public Reservation(Long id, Integer days, Customer customer, Hotel hotel, Calendar checkIn, Calendar checkOut) {
        this.id = id;
        this.days = days;
        this.customer = customer;
        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

}
