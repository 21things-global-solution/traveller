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

    @Column(name = "nr_tel", length = 11)
    private String phone;

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

    public Hotel() {
    }

    public Hotel(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

}
