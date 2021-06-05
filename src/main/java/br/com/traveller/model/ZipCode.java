package br.com.traveller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_CEP")
@SequenceGenerator(name = "zipCode", allocationSize = 1, sequenceName = "SQ_GS_CEP")
public class ZipCode implements Serializable {

    @Id
    @GeneratedValue(generator = "zipCode", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_cep")
    private Long id;

    @Column(name = "nr_cep", length = 8, nullable = false, unique = true)
    private String number;

    @Column(name = "ds_logradouro", nullable = false)
    private String name;

    @Column(name = "ds_bairro", nullable = false, length = 70)
    private String district;

    @Column(name = "ds_cidade", nullable = false, length = 70)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "in_uf", nullable = false, length = 2)
    private State state;

    @OneToMany(mappedBy = "zipCode", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public void addAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
        address.setZipCode(this);
    }

    public ZipCode() {
    }

    public ZipCode(Long id, String number, String name, String district, String city, State state,
            List<Address> addresses) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.district = district;
        this.city = city;
        this.state = state;
        this.addresses = addresses;
    }

    public ZipCode(String name, String district, String city, String number, State state) {
        this.number = number;
        this.name = name;
        this.district = district;
        this.city = city;
        this.state = state;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
