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
@Table(name = "T_GS_TELEFONE")
@SequenceGenerator(name = "phone", allocationSize = 1, sequenceName = "SQ_GS_TELEFONE")
public class Phone {

    @Id
    @GeneratedValue(generator = "phone", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_telefone")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cliente", nullable = false)
    private Customer customer;

    @Column(name = "tp_telefone", length = 9, nullable = false)
    private PhoneType type;

    @Column(name = "nr_telefone", length = 11, nullable = false)
    private String number;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false, updatable = false)
    private Calendar register;

    @Override
    public String toString() {
        return "Phone [customer=" + customer + ", id=" + id + ", number=" + number + ", register=" + register
                + ", type=" + type + "]";
    }

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public Phone(String number, PhoneType type, Customer customer) {
        this.number = number;
        this.type = type;
        this.customer = customer;
    }

    public Phone(Long id, Customer customer, PhoneType type, String number, Calendar register) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.number = number;
        this.register = register;
    }

    public Phone() {
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

    public Calendar getRegister() {
        return register;
    }

    public void setRegister(Calendar register) {
        this.register = register;
    }
}
