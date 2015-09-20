package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;

@Entity
@Table(name="temperature")
@NamedQuery(name="Temperature.getAll", query = "select c from Temperature c")
public class Temperature implements Serializable {
   
    private Long id;
    private int temperatureMin;
    private int temperatureMax;
    private List<Fluid> fluids;

    @Id
    @Column(name = "idtemperature")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name = "temperatureMin", nullable = false)
    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    @Column(name = "temperatureMax", nullable = false)
    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "temperature")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
    }

    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Temperature)) {
            return false;
        }
        Temperature other = (Temperature) object;
        if ((this.id != other.id) || (this.temperatureMin != other.temperatureMin) 
                || (this.temperatureMax != other.temperatureMax)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Temperature[ id=" + id + ", temperatureMin=" 
                + temperatureMin + ", temperatureMax=" + temperatureMax + " ]";
    }
    
}
