package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="temperature")
public class Temperature implements Serializable {
   
    private int id;
    private int temperatureMin;
    private int temperatureMax;

    @Id
    @Column(name = "idtemperature")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
