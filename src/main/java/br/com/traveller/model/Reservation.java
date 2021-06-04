package br.com.traveller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

    @JoinColumn(name = "cd_cliente", nullable = false)
    private Customer customer;

    @JoinColumn(name = "cd_hotel", nullable = false)
    private Hotel hotel;

    @Override
    public String toString() {
        return "Reservation [days=" + days + ", id=" + id + "]";
    }

    public Reservation() {
    }

    public Reservation(Long id, Integer days, Customer customer, Hotel hotel) {
        this.id = id;
        this.days = days;
        this.customer = customer;
        this.hotel = hotel;
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

}
