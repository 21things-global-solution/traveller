package br.com.traveller.model;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    public void addRooms(Room room) {
        if (this.rooms == null) {
            this.rooms = new ArrayList<>();
        }
        this.rooms.add(room);
        room.setHotel(this);
    }

    public void addReservation(Reservation reservation) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(reservation);
        reservation.setHotel(this);
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", mail=" + mail + ", name=" + name + ", phone=" + phone + ", reservations="
                + reservations + ", rooms=" + rooms + ", site=" + site + "]";
    }

    public Hotel() {
    }

    public Hotel(Long id, String name, String phone, String mail, String site, List<Reservation> reservations,
            List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.site = site;
        this.reservations = reservations;
        this.rooms = rooms;
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
