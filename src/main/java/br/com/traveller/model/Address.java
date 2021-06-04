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
@Table(name = "T_GS_CEP_ENDERECO")
@SequenceGenerator(name = "address", allocationSize = 1, sequenceName = "SQ_GS_CEP_ENDERECO")
public class Address {

    @Id
    @GeneratedValue(generator = "address", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_endereco")
    private Long id;

    @Column(name = "nr_hotel", length = 5)
    private String number;

    @Column(name = "ds_complemento", length = 50)
    private String complement;

    @Id
    @JoinColumn(name = "cd_hotel", nullable = false)
    private Hotel hotel;

    @Id
    @JoinColumn(name = "cd_logradouro", nullable = false)
    private Street street;

    @Override
    public String toString() {
        return "Address [complement=" + complement + ", hotel=" + hotel + ", id=" + id + ", number=" + number
                + ", street=" + street + "]";
    }

    public Address() {
    }

    public Address(Long id, String number, String complement) {
        this.id = id;
        this.number = number;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

}
