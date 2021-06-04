package br.com.traveller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_CEP_CIDADE")
@SequenceGenerator(name = "city", allocationSize = 1, sequenceName = "SQ_GS_CEP_CIDADE")
public class City {

    @Id
    @GeneratedValue(generator = "city", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_cidade")
    private Long id;

    @Column(name = "ds_cidade", nullable = false, length = 70)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "in_uf", nullable = false, length = 2)
    private State state;

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", state=" + state + "]";
    }

    public City() {
    }

    public City(Long id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
