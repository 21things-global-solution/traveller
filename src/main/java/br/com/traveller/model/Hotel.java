package br.com.traveller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_HOTEL")
@SequenceGenerator(name = "hotel", allocationSize = 1, sequenceName = "SQ_GS_HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(generator = "hotel", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_hotel")
    private Long id;

    @Column(name = "nm_hotel", length = 90, nullable = false)
    private String name;

    @Column(name = "nr_telefone", length = 11)
    private String phone;

    @Column(name = "ds_email", nullable = false)
    private String mail;

    @Column(name = "ds_site", length = 150)
    private String site;

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", mail=" + mail + ", name=" + name + ", phone=" + phone + ", site=" + site + "]";
    }

    public Hotel() {
    }

    public Hotel(Long id, String name, String phone, String mail, String site) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.site = site;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
