package br.com.traveller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_HOTEL")
@SequenceGenerator(name = "hotel", allocationSize = 1, sequenceName = "SQ_GS_HOTEL")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(generator = "hotel", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_hotel")
    private Long id;

    @Column(name = "nm_hotel", length = 90, nullable = false)
    private String name;

    @Column(name = "nr_telefone", length = 11)
    private String phone;

    @Column(name = "ds_email")
    private String mail;

    @Column(name = "ds_site", length = 150)
    private String site;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @Column(name = "in_classificacao")
    private Integer rating;

    @Column(name="im_hotel")
    private String image;

    public void addRooms(Room room) {
        if (this.rooms == null) {
            this.rooms = new ArrayList<>();
        }
        this.rooms.add(room);
        room.setHotel(this);
    }

    @Override
    public String toString() {
        return "Hotel [address=" + address + ", id=" + id + ", image=" + image + ", mail=" + mail + ", name=" + name
                + ", phone=" + phone + ", rating=" + rating + ", site=" + site + "]";
    }

    public Hotel(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Hotel() {
    }

    public Hotel(Long id, String name, String phone, String mail, String site, Address address, Integer rating) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.site = site;
        this.address = address;
        this.rating = rating;
    }

    public Hotel(String name, String phone, String site, String mail) {
        this.name = name;
        this.phone = phone;
        this.site = site;
        this.mail = mail;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
