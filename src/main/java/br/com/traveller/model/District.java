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
@Table(name = "T_GS_CEP_BAIRRO")
@SequenceGenerator(name = "district", allocationSize = 1, sequenceName = "SQ_GS_CEP_BAIRRO")
public class District {

    @Id
    @GeneratedValue(generator = "district", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_bairro")
    private Long id;

    @Column(name = "ds_bairro", length = 70, nullable = false)
    private String name;

    @JoinColumn(name = "cd_cidade", nullable = false)
    private City city;

    @Override
    public String toString() {
        return "District [city=" + city + ", id=" + id + ", name=" + name + "]";
    }

    public District() {
    }

    public District(Long id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
