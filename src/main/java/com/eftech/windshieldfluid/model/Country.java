package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name="country")
@NamedQuery(name="Country.getAll", query = "select c from Country c")
public class Country implements Serializable {
    
    private int id;
    private String countryName;
    private String pictureName;
    private List<Fluid> fluids;
    
    @Id
    @Column(name = "idcountry")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Size(min=2, max=100)
    @Column(name = "country", nullable = false)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Size(min=1, max=45)
    @Column(name = "picturename", nullable = false)
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true, mappedBy = "country")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
    }
    
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id != other.id) || (this.countryName != other.countryName) || (this.pictureName != other.pictureName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return "com.eftech.windshieldfluid.model.Country[ id=" + id + ", name=" + countryName + ", pictureName="
				+ pictureName +  " ]";
    }
    
}
