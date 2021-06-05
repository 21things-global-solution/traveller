package br.com.traveller.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_ENDERECO")
@SequenceGenerator(name = "address", allocationSize = 1, sequenceName = "SQ_GS_ENDERECO")
public class Address implements Serializable {

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
    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;

    @Id
    @JoinColumn(name = "cd_logradouro", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private ZipCode zipCode;

    @Override
    public String toString() {
        return "Address [complement=" + complement + ", hotel=" + hotel + ", id=" + id + ", number=" + number
                + ", zipCode=" + zipCode + "]";
    }

    public Address() {
    }

    public Address(Long id, String number, String complement, Hotel hotel, ZipCode zipCode) {
        this.id = id;
        this.number = number;
        this.complement = complement;
        this.hotel = hotel;
        this.zipCode = zipCode;
    }

    public Address(String number, ZipCode zipCode) {
        this.number = number;
        this.zipCode = zipCode;
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

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

}
