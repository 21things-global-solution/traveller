package br.com.traveller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

    @Column(name = "nr_cpf", length = 14, nullable = false)
    private String nin;

    @Override
    public String toString() {
        return "Customer [id=" + id + ", mail=" + mail + ", name=" + name + ", nin=" + nin + "]";
    }

    public Customer() {
    }

    public Customer(Long id, String name, String mail, String nin) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.nin = nin;
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
}
