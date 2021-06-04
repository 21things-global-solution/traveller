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
@Table(name = "T_GS_TELEFONE")
@SequenceGenerator(name = "phone", allocationSize = 1, sequenceName = "SQ_GS_PHONE")
public class Phone {

    @Id
    @GeneratedValue(generator = "phone", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_telefone")
    private Long id;

    @JoinColumn(name = "cd_cliente", nullable = false)
    private Customer customer;

    @Column(name = "tp_telefone", length = 9, nullable = false)
    private PhoneType type;

    @Column(name = "nr_telefone", length = 11, nullable = false)
    private String number;

    @Override
    public String toString() {
        return "Phone [customer=" + customer + ", id=" + id + ", number=" + number + ", type=" + type + "]";
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

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
