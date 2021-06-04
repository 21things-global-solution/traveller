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
@Table(name = "T_GS_CEP_LOGRADOURO")
@SequenceGenerator(name = "street", allocationSize = 1, sequenceName = "SQ_GS_CEP_LOGRADOURO")
public class Street {

    @Id
    @GeneratedValue(generator = "street", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_logradouro")
    private Long id;

    @Column(name = "nr_cep", length = 8, nullable = false, unique = true)
    private String zipCode;

    @Column(name = "ds_logradouro", nullable = false)
    private String name;

    @JoinColumn(name = "cd_bairro", nullable = false)
    private District district;

    public Street() {
    }

    public Street(Long id, String zipCode, String name, District district) {
        this.id = id;
        this.zipCode = zipCode;
        this.name = name;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
