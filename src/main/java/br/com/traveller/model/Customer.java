package br.com.traveller.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_GS_CLIENTE")
@SequenceGenerator(name = "cliente", allocationSize = 1, sequenceName = "SQ_GS_CLIENTE")
public class Customer {

    @Id
    @GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_cliente")
    private Long id;

    @Column(name = "nm_cliente", nullable = false)
    private String name;

    @Column(name = "ds_email")
    private String mail;

    @Column(name = "nr_cpf", length = 14, nullable = false, unique = true)
    private String nin;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false, updatable = false)
    private Calendar register;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Phone> phones;

    public void addPhone(Phone phone) {
        if (this.phones == null) {
            this.phones = new ArrayList<>();
        }

        this.phones.add(phone);
        phone.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", mail=" + mail + ", name=" + name + ", nin=" + nin + ", phones=" + phones
                + ", register=" + register + "]";
    }

    public Customer() {
    }

    public Customer(Long id, String name, String mail, String nin, Calendar register, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.nin = nin;
        this.register = register;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public Calendar getRegister() {
        return register;
    }

    public void setRegister(Calendar register) {
        this.register = register;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
